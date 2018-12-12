package by.it.burlakov.jd01_11;

import java.util.*;

public class ListB<T> implements List<T> {

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
    public boolean add(T element) {
        if(size == elements.length){
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size++] = element;

        return true;
    }
    @Override
    public T remove(int index) {
        T result = elements[index];
        System.arraycopy(elements, index + 1, elements, index, --size - index);
        return result;
    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public T set(int index, T element) {
       T temp = elements[index];
        elements[index] = element;
        return temp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int index, T element) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        System.arraycopy(elements, index, elements, index + 1, size++ - index);
        elements[index] = element;
    }
    @Override
    public boolean addAll(Collection<? extends T> coll) {
        T[] array = (T[]) coll.toArray();
        elements = Arrays.copyOf(elements, elements.length + array.length);
        System.arraycopy(array, 0, elements, size, array.length);
        size += array.length;
        return array.length == 0;
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
                if (elements[i] != null){
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
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        elements = Arrays.copyOf(elements, 0);
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements, size);
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }


    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }



    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
