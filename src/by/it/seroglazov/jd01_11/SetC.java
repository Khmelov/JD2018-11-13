package by.it.seroglazov.jd01_11;

import java.util.*;

public class SetC<E> implements Set<E> {

    private HashMap<E, Object> map = new HashMap<E, Object>();
    private static final Object STUB = new Object();

    private int size;

    @Override
    public boolean add(E e) {
        return map.put(e, STUB) == null;
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) == STUB;
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean a = false;
        for (E e : c) {
            a = add(e);
        }
        return a;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator<?> it = c.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) return false;
        }
        return true;


    }

    @Override
    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean a = false;
        Iterator<?> iterator = c.iterator();
        while (iterator.hasNext()) {
            a = remove(iterator.next());
        }
        return a;
    }

    @Override
    public String toString() {
        Iterator<E> iter = iterator();
        if (!iter.hasNext()) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (true) {
            sb.append(iter.next());
            if (!iter.hasNext()) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");

        }
    }

    @Override
    public void clear() {
        map.clear();
    }

    //====================== STUBS ==============================================


    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }




    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
