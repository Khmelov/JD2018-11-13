package by.it.kruglenja.jd01_11;

import java.util.*;
import java.util.function.UnaryOperator;

public class ListB<T> implements List<T> {
    private T[] elements = (T[]) new Object[]{};
    private int size = 0;

    @Override
    public boolean addAll(Collection<? extends T> c) {
        T[] arr = (T[]) c.toArray();
        int len = elements.length + arr.length;
        elements = Arrays.copyOf(elements, len);
        for (int i = 0; i < arr.length; i++) {
            elements[i + size] = arr[i];
        }
        size = size + arr.length;
        return (size + arr.length) > 0;
    }

    @Override
    public T remove(int index) {
        T t = elements[index];
        if (index < size) {
            System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
            size--;
            return t;
        }
        return t;
    }

    @Override
    public boolean add(T t) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, (size * 3) / 2 + 1);
        }
        elements[size++] = t;
        return true;
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < size) {
            return elements[index];
        }
        return null;
    }

    @Override
    public T set(int index, T element) {
        T e = elements[index];
        elements[index] = element;
        return e;
    }

    @Override
    public void add(int index, T element) {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, (size / 3) * 2 + 1);
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String dilimetr = "";
        for (int i = 0; i < size; i++) {
            sb.append(dilimetr).append(elements[i]);
            dilimetr = ", ";
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean contains(Object o) {
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
    public void clear() {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
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

    @Override
    public void replaceAll(UnaryOperator<T> operator) {

    }

    @Override
    public void sort(Comparator<? super T> c) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }


    @Override
    public boolean isEmpty() {
        return false;
    }
}
