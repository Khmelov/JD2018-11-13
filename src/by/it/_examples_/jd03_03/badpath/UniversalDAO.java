package by.it._examples_.jd03_03.badpath;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Изучите чуть более сложный пример с Generics.
// Потенциально способен обработать произольный bean со стандартными полями.
// Ограничение. Первым полем в bean должен быть id.

// Код написал для примера и сильно не проверял, так что к прямому использованию он точно не готов,
// просто давайте повторим generics.

//  нет потокобезопасности, совсем, т.к. это только пример, иначе код заметно усложнится.
//  Поэтому - никакого реального применения, используйте сие только в учебных целях!

public class UniversalDAO<TypeBean> implements InterfaceDAO<TypeBean> {

    private TypeBean bean; //это некий неизвестный bean
    private String table; //это его таблица в базе
    private Field[] fields; //это поля bean

    //конструктор DAO
    public UniversalDAO(TypeBean bean, String sqlTableName) {
        this.bean = bean;
        this.table = sqlTableName;
        this.fields = bean.getClass().getDeclaredFields();
    }

    //=======================================================================================================
    public List<TypeBean> getAll(String WHERE) throws SQLException {
        List<TypeBean> beans = new ArrayList<>();
        String sql = "SELECT * FROM " + table + " " + WHERE + " ;";
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            //            for (int i = 0; i < fields.length; i++) {
            //                System.out.println(fields[i]+":"+fields[i].getType());}
            while (rs.next()) {
                //создаем копию бина, в который будем складывать запись из Recordset
                TypeBean newBean = newBean();
                for (int i = 1; i < fields.length+1; i++) {
                    //перебирая поля бина по очереди извлекаем значения в соответствии с их типом
                    Field f = fields[i - 1];
                    f.setAccessible(true);
                    String strType = f.getType().toString();
                    try {
                        if (f.getType() == Boolean.class || strType.equals("boolean"))
                            f.set(newBean, rs.getBoolean(f.getName()));
                        if (f.getType() == Byte.class || strType.equals("byte"))
                            f.set(newBean, rs.getByte(f.getName()));
                        if (f.getType() == Integer.class || strType.equals("int"))
                            f.set(newBean, rs.getInt(f.getName()));
                        if (f.getType() == Double.class || strType.equals("double"))
                            f.set(newBean, rs.getDouble(f.getName()));
                        if (f.getType() == Float.class || strType.equals("float"))
                            f.set(newBean, rs.getFloat(f.getName()));
                        if (f.getType() == Long.class || strType.equals("long"))
                            f.set(newBean, rs.getLong(f.getName()));
                        if (f.getType() == Short.class || strType.equals("short"))
                            f.set(newBean, rs.getShort(f.getName()));
                        if (f.getType() == String.class)
                            f.set(newBean, rs.getString(f.getName()));
                        if (f.getType() == Date.class)
                            f.set(newBean, rs.getDate(f.getName()));
                        //... и т.д. Но учтите, что протестированы только String int и Integer
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                beans.add(newBean);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return beans;
    }

    //=======================================================================================================
    //метод чтения по ID делает выборку получая все, но с условием.
    public TypeBean read(int id) throws SQLException {
        List<TypeBean> beans = getAll("WHERE ID=" + id + " LIMIT 0,1");
        if (beans.size() > 0) {
            return beans.get(0);
        } else
            return null;
    }


    //=======================================================================================================
    //команда обновления
    public boolean update(TypeBean bean) throws SQLException {
        // собираем SQL по шаблону
        // "UPDATE `users` SET
        // `Login` = '%s', `Password` = '%s', `Email` = '%s', `FK_Role` = '%d'
        // WHERE `users`.`ID` = %d",
        String sql = "UPDATE `" + table + "` SET ";
        String delimiter = "";
        try {
            for (int i = 1; i < fields.length; i++) { //начинаем со второго поля
                Field f = fields[i];
                f.setAccessible(true);
                //добавляем `FieldName` = 'Value', в цикле
                sql = sql.concat(delimiter + "`" + f.getName() + "` = '" + f.get(bean) + "'");
                delimiter = ", "; //добавим запятую перед каждым последующим полем
            }
            fields[0].setAccessible(true);
            sql = sql.concat(" WHERE `" + fields[0].getName() + "` = '" + fields[0].get(bean) + "'");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        //System.out.println(sql);
        return (0 < executeUpdate(sql, false));
    }

    //=======================================================================================================
    public boolean create(TypeBean bean) throws SQLException {
        // собираем SQL по шаблону
        // insert INTO users(Login,Password,Email,FK_Role)
        // values('%s','%s','%s',%d)
        String names = "";
        String values = "";
        String delimiter = "";
        try {
            for (int i = 1; i < fields.length; i++) { //начинаем со второго поля
                Field f = fields[i];
                f.setAccessible(true);
                names = names.concat(delimiter + f.getName());
                values = values.concat(delimiter + "'" + f.get(bean) + "'");
                delimiter = ", "; //добавим запятую перед каждым последующим полем
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        String sql = "insert INTO " + table + " (" + names + ") values(" + values + ")";
        //System.out.println(sql);
        int id = executeUpdate(sql, true);
        if (id > 0) try {
            fields[0].setAccessible(true);
            fields[0].set(bean, id);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (id > 0);
    }

    //=======================================================================================================
    public boolean delete(TypeBean bean) throws SQLException {
        String sql = null;
        try {
            sql = "DELETE FROM `" + table + "` WHERE `" + table + "`.`ID` = '" + fields[0].get(bean) + "'";
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return (0 < executeUpdate(sql, false));
    }


    //=======================================================================================================
    //т.к. в Generics невозможно сделать new TypeBean(), а новые объекты нужны,
    //создадим объект и приведем его тип к TypeBean "вручную"
    @SuppressWarnings("unchecked") //подавление warning-а
    private TypeBean newBean() {
        try {
            return (TypeBean) bean.getClass().getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null; //если не создался вернем null
    }

    //=======================================================================================================
    //общая команда для Create Update Delete
    private static int executeUpdate(String sql, boolean returnLastID) throws SQLException {
        int result;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            result = statement.executeUpdate(sql,Statement.RETURN_GENERATED_KEYS);
            //получим ID, если это требуется извне.
            if (result>0 && returnLastID) {
                //в MySQL можно так .executeQuery("SELECT LAST_INSERT_ID();");
                //но этот способ надежнее (не зависит от базы данных и безопаснее)
                ResultSet resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) result = resultSet.getInt(1);
                System.out.println("id: "+result);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return result;
    }

}