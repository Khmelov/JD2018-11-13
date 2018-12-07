package by.it.markelov.jd01_11;

import java.util.*;

public class ListB<T> implements List<T> {
    private T[] elements = (T[]) new Object[0];
    private int size = 0; //количество элементов в массиве

    @Override
    public boolean add(T t) {
        if (size == elements.length) {//если количество элементов достигнет длины массива
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);//увеличиваем размер массива
        }
        elements[size] = t;
        size++;
        return true;
    }

    @Override
    public T remove(int index) {
        T delelement = elements[index];
        if (index >= 0 && index < elements.length) {
            System.arraycopy(elements, index + 1, elements, index, elements.length - index - 1);
            size--;
        }
        return delelement;
    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public T set(int index, T t) {
        T replaceableElement = elements[index];
        elements[index] = t;
        return replaceableElement;
    }

    @Override
    public void add(int index, T t) {
        elements = Arrays.copyOf(elements, elements.length + 1);//увеличиваем размер массива на 1
        System.arraycopy(elements, index, elements, index + 1, elements.length - index - 1);
        size++;
        elements[index] = t;
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

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return true;
    }


    ///////////////////////////////STUBS////////////////////////////////////////////////////////////////////////////////////


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
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
    public <T1> T1[] toArray(T1[] t1s) {
        return null;
    }


    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }


    @Override
    public boolean addAll(int i, Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
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
    public ListIterator<T> listIterator(int i) {
        return null;
    }

    @Override
    public List<T> subList(int i, int i1) {
        return null;
    }
}
