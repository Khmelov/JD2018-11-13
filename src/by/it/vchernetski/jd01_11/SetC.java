package by.it.vchernetski.jd01_11;

import java.util.*;

public class SetC<E> implements Set<E> {
    private HashMap<E, Object> mymap = new HashMap<E, Object>();
    private static Object mine = new Object();

    @Override
    public int size() {
        return mymap.size();
    }

    @Override
    public boolean isEmpty() {
        return mymap.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return mymap.containsKey(o);
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return mymap.put(e, mine)==mine;
    }

    @Override
    public boolean remove(Object o) {
        return mymap.remove(o)==mine;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator<?> i = c.iterator();
        while (i.hasNext()) {
            if (!contains(i.next())) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean ret = false;
        for(E e: c){
            ret = add(e);
        }
        return ret;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean ret = false;
        Iterator<?> i = c.iterator();
        while (i.hasNext()){
            ret = remove(i.next());
        }
        return ret;
    }

    @Override
    public void clear() {
        mymap.clear();
    }
    public String toString(){
        Iterator<E> i = mymap.keySet().iterator();
        StringBuilder sb = new StringBuilder();
        if(!i.hasNext()) return sb.append("[]").toString();
        sb.append("[");
        while(i.hasNext()){
            sb.append(i.next());
            if(i.hasNext()) sb.append(", ");
        }
        return sb.append("]").toString();
    }
}
