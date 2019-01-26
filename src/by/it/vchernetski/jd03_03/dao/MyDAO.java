package by.it.vchernetski.jd03_03.dao;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MyDAO<T> implements InterfaceDAO {
    private String qm = "`";
    private T bean;
    private static MyDAO dao;
    private volatile static boolean DaoCreated = false;

    private MyDAO(T bean) {
        this.bean = bean;
    }

    public static MyDAO getDao(Object bean){
        if(!DaoCreated){
            synchronized (MyDAO.class){
                if(!DaoCreated) dao = new MyDAO(bean);
            }
        }
        return dao;
    }

    @Override
    public boolean create() throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO `").append(bean.getClass().getSimpleName().toLowerCase() + "s").append("`").append(" (");
        Field[] fields = bean.getClass().getDeclaredFields();
        Method[] methods = bean.getClass().getDeclaredMethods();
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getName().equalsIgnoreCase("id")) continue;
            if (i == fields.length - 1) {
                sql.append(qm).append(fields[i].getName()).append(qm).append(")");
                continue;
            }
            sql.append(qm).append(fields[i].getName()).append(qm).append(", ");
        }
        sql.append("VALUES (");
        String f = "";
        for (int i = 0; i < fields.length; i++) {
            f = fields[i].getName();
            if (f.equalsIgnoreCase("id")) continue;
            for (int j = 0; j < methods.length; j++) {
                if (methods[j].getName().equalsIgnoreCase("get" + f) && i == fields.length - 1) {
                    sql.append("'").append(methods[j].invoke(bean)).append("')");
                    break;
                }
                if (methods[j].getName().equalsIgnoreCase("get" + f)) {
                    sql.append("'").append(methods[j].invoke(bean)).append("', ");
                    break;
                }
            }
        }
        try (Statement statement = Connect.getConnection().createStatement()) {
            if (1 == statement.executeUpdate(sql.toString(), Statement.RETURN_GENERATED_KEYS)) {
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    for (Method method : methods) {
                        if (method.getName().equalsIgnoreCase("setId")) {
                            method.invoke(bean, generatedKeys.getLong(1));
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete() throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM ").append(qm).append(bean.getClass().
                getSimpleName().toLowerCase() + "s").append(qm).append(" WHERE ").
                append(qm).append(bean.getClass().
                getSimpleName().toLowerCase() + "s").append(qm).append(".").
                append(qm).append("id").append(qm).append(" = ");
        Method[] methods = bean.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("getid")) {
                sql.append(method.invoke(bean));
            }
        }
        try (Statement statement = Connect.getConnection().createStatement()) {
            return 1 == statement.executeUpdate(sql.toString());
        }
    }

    @Override
    public boolean update() throws Exception {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE ").append(qm).append(bean.getClass().getSimpleName().toLowerCase() + "s").append(qm).append(" SET ");
        Field[] fields = bean.getClass().getDeclaredFields();
        Method[] methods = bean.getClass().getDeclaredMethods();
        for (int i = 0; i < fields.length; i++) {
            if (!fields[i].getName().equalsIgnoreCase("id")) {
                sql.append(qm).append(fields[i].getName()).append(qm).append(" = ");
                for (Method method : methods) {
                    if (i != fields.length - 1) {
                        if (method.getName().equalsIgnoreCase("get" + fields[i].getName())) {
                            sql.append("'").append(method.invoke(bean)).append("', ");
                        }
                    } else {
                        if (method.getName().equalsIgnoreCase("get" + fields[i].getName())) {
                            sql.append("'").append(method.invoke(bean)).append("'");
                        }
                    }
                }
            }
        }
        sql.append(" WHERE ").append(qm).append(bean.getClass().getSimpleName().toLowerCase() + "s").append(qm).append(".").append(qm).append("id").append(qm).append(" = ");
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("getid")) {
                sql.append(method.invoke(bean));
            }
        }
        try (Statement statement = Connect.getConnection().createStatement()) {
            return (1 == statement.executeUpdate(sql.toString()));
        }
    }

    @Override
    public T read(long id) throws Exception {
        String sqls = String.format("WHERE id = %d",id);
        List<T> beans = getAll(sqls);
        return beans.size()>0?beans.get(0):null;
    }

    @Override
    public List<T> getAll(String sqls) throws Exception {
        List<T> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM ").append(qm).append(bean.getClass().getSimpleName().toLowerCase() + "s").append(qm).append(sqls);
        Field[] fields = bean.getClass().getDeclaredFields();
        Method[] methods = bean.getClass().getDeclaredMethods();
        try (Statement statement = Connect.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql.toString());
            while (resultSet.next()) {
                Object obj = bean.getClass().newInstance();
                for (int i = 0; i < fields.length; i++) {
                    if(fields[i].getType()==int.class||fields[i].getType()==Integer.class){
                        for (int j = 0; j < methods.length; j++) {
                            if(methods[j].getName().equalsIgnoreCase("set"+fields[i].getName())){
                                methods[j].invoke(obj, resultSet.getInt(fields[i].getName()));
                            }
                        }
                    }
                    if(fields[i].getType()==long.class||fields[i].getType()==Long.class){
                        for (int j = 0; j < methods.length; j++) {
                            if(methods[j].getName().equalsIgnoreCase("set"+fields[i].getName())){
                                methods[j].invoke(obj, resultSet.getLong(fields[i].getName()));
                            }
                        }
                    }
                    if(fields[i].getType()==String.class){
                        for (int j = 0; j < methods.length; j++) {
                            if(methods[j].getName().equalsIgnoreCase("set"+fields[i].getName())){
                                methods[j].invoke(obj, resultSet.getString(fields[i].getName()));
                            }
                        }
                    }
                    if(fields[i].getType()==boolean.class){
                        for (int j = 0; j < methods.length; j++) {
                            if(methods[j].getName().equalsIgnoreCase("set"+fields[i].getName())){
                                methods[j].invoke(obj, resultSet.getBoolean(fields[i].getName()));
                            }
                        }
                    }
                    if(fields[i].getType()==short.class||fields[i].getType()==Short.class){
                        for (int j = 0; j < methods.length; j++) {
                            if(methods[j].getName().equalsIgnoreCase("set"+fields[i].getName())){
                                methods[j].invoke(obj, resultSet.getShort(fields[i].getName()));
                            }
                        }
                    }
                    if(fields[i].getType()==byte.class||fields[i].getType()==Byte.class){
                        for (int j = 0; j < methods.length; j++) {
                            if(methods[j].getName().equalsIgnoreCase("set"+fields[i].getName())){
                                methods[j].invoke(obj, resultSet.getByte(fields[i].getName()));
                            }
                        }
                    }
                    if(fields[i].getType()== Date.class){
                        for (int j = 0; j < methods.length; j++) {
                            if(methods[j].getName().equalsIgnoreCase("set"+fields[i].getName())){
                                methods[j].invoke(obj, resultSet.getDate(fields[i].getName()));
                            }
                        }
                    }
                }
                list.add((T)obj);
            }
        }
        return list;
    }
}