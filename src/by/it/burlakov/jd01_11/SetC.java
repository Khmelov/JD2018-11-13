package by.it.burlakov.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetC<T> implements Set<T> {

    private T[] elements = (T[]) new Object[]{};

    private int size = 0;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delim = "";
        for (int i = 0; i < size; i++) {
            sb.append(delim).append(elements[i]);
            delim = ", ";
        }
        sb.append("]");
        return  sb.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return elements.length == 0;
    }

    public int indexOf(Object o) {
        int result = -1;
        if (o != null) {
            for (int i = 0; i < size; i++){
                if (o.equals(elements[i])){
                    result = i;
                }
            }
        } else {
            for (int i = 0; i < size; i++){
                if (elements[i] == null){
                    result = i;
                }
            }
        }
        return result;
    }


    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return elements;

    }


    @Override
    public boolean add(T element) {
        if (!contains(element)){
            if (size == elements.length){
                elements = Arrays.copyOf(elements, size * 3 / 2 + 1);
            }
                elements[size++] = element;
                return true;
        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> coll) {
        T[] copyColl = (T[]) coll.toArray();
        for (T element : copyColl) add(element);

        return false;
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index > 0) {
            System.arraycopy(elements, index + 1, elements, index, --size - index);
        }
        return (index > 0);
    }

    @Override
    public boolean containsAll(Collection<?> coll) {
        for (Object obj : coll) {
            if (!contains(obj)){
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        elements = Arrays.copyOf(elements, 0);
        size = 0;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> coll) {

        T []copyColl = (T[]) coll.toArray();

        for(Object obj : copyColl){
            remove(obj);
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }
}

