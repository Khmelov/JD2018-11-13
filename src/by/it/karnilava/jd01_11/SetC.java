package by.it.karnilava.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {

    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public int size() {

        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size()==0){
            return true;
        }

        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {

            if (Objects.equals(elements[i], o)) {
                return true;
            }
        }

        return false;
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
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if (elements.length > 0) {
            if (size == elements.length)
                elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);

            if (contains(t)) {
                return false;
            }
            elements[size++] = t;


        } else {
            elements = Arrays.copyOf(elements, (size * 3 / 2 + 1));
            elements[size++] = t;
        }


        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (size > 0) {
            int index;
            for (int i = 0; i < size; i++) {
                if (Objects.equals(elements[i], o)) {
                    index = i;
                    System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
                    size--;
                    return true;
                }

            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object elementOfCollection : c) {
            if (!contains(elementOfCollection)) {
                return false;

            }

        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T elementOfCollection : c) {
            add(elementOfCollection);
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object elementOfCollection : c) {
            remove(elementOfCollection);
        }
        return true;
    }

    @Override
    public void clear() {
       elements = (T[]) new Object[]{};
        size = 0;


    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {

            sb.append(delimiter).append(elements[i]);
            delimiter = ", ";

        }
        sb.append("]");
        return sb.toString();

    }
}
