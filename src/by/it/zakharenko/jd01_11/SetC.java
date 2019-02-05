package by.it.zakharenko.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {
    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    @Override
    public boolean add(T t) {


        for (T element : elements) {
            if (t == element) return false;
        }
        if (size == elements.length) elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);
        if (t == null) elements[size++] = null;
        elements[size++] = t;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < elements.length; i++) {
            if (o == elements[i]) return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        T[] objects = (T[]) c.toArray();
        if (elements.length < size + objects.length) elements = Arrays.copyOf(elements, size + objects.length + 1);
        for (Object object : objects) add((T) object);
        return true;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) return true;
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object object : c) {
            if (!contains(object)) return false;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index > 0) {
            System.arraycopy(elements, index + 1, elements, index, size - index);
            size--;
        }

        return index > 0;
    }

    private int indexOf(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elements[i]==null) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        T[] objects = (T[]) c.toArray();

        for (T object : objects) {
            remove(object);
        }
        return true;
    }

    @Override
    public void clear() {
        elements = Arrays.copyOf(elements,0);
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimeter = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimeter).append(elements[i]);
            delimeter = ", ";
        }
        sb.append("]");
        return sb.toString();
    }
    //sub

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

}
