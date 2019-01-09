package by.it.kruglenja.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {

    public HashMap<T, Object> hashMap = new HashMap<>();
    private static Object object = new Object();


    @Override
    public int size() {
        return hashMap.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return hashMap.containsKey(o);
    }

    @Override
    public Iterator<T> iterator() {
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
    public boolean add(T e) {
        return hashMap.put(e, object) == object;
    }

    @Override
    public boolean remove(Object o) {
        return hashMap.remove(o) == object;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        Iterator<?> iterator = c.iterator();
        for (Object o1 : c) {
            if (!contains(iterator.next()))
                return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean res = false;
        for (T t : c) {
            res = add(t);
        }
        return res;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean res = false;
        Iterator<?> iterator = c.iterator();
        while (iterator.hasNext()) {
            res = remove(iterator.next());
        }
        return res;
    }

    @Override
    public void clear() {
        hashMap.clear();
    }

    @Override
    public String toString() {
        Iterator<T> iterator = hashMap.keySet().iterator();
        StringBuilder sb = new StringBuilder();
        if (!iterator.hasNext()) {
            return sb.append("[]").toString();
        } else {
            sb.append("[");
            while (iterator.hasNext()) {
                sb.append(iterator.next());
                if (iterator.hasNext()) sb.append(", ");
            }
            return sb.append("]").toString();
        }
    }
}
