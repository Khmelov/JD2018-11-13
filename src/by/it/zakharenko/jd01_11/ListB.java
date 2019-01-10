package by.it.zakharenko.jd01_11;

import java.util.*;

public class ListB<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] mas;
    private int size;

    ListB() {
        mas = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    ListB(int capacity) {
        mas = new Object[capacity];
        size = 0;
    }

    private void controlSize() {
        if (size == mas.length) {
            int newLength = size * 3 / 2 + 1;
            Object[] nmas = new Object[newLength];
            System.arraycopy(mas, 0, nmas, 0, size);
            mas = nmas;
        }
    }

    private void controlSize(int ns) {
        if (mas.length < ns) {
            int newLength = ns * 3 / 2 + 1;
            Object[] nmas = new Object[newLength];
            System.arraycopy(mas, 0, nmas, 0, size);
            mas = nmas;
        }
    }


    @Override
    public boolean add(E e) {
        controlSize();
        mas[size++] = e;
        return true;
    }

    @Override
    public E remove(int index) {
        if (index < size && index >= 0) {
            E e = (E) mas[index];
            System.arraycopy(mas, index + 1, mas, index, size - 1 - index);
            size--;
            return e;
        } else return null;
    }

    @Override
    public E get(int index) {
        return (E) mas[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            if (mas[i] != null) sb.append(mas[i].toString());
            else sb.append("null");
            if (i != size - 1) sb.append(", ");
        }
        sb.append(']');
        return sb.toString();
    }

    @Override
    public E set(int index, E element) {
        E pr = get(index);
        mas[index] = element;
        return pr;
    }

    @Override
    public void add(int index, E element) {
        controlSize();
        System.arraycopy(mas, index, mas, index + 1, size - index);
        size++;
        mas[index] = element;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] o = c.toArray();
        int newLen = size + o.length;
        controlSize(newLen);
        System.arraycopy(o, 0, mas, size, o.length);
        size = newLen;
        return o.length != 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(mas, size);
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public int indexOf(Object o) {
        if (o != null) {
            for (int i = 0; i < size; i++) {
                if (mas[i] != null && mas[i].equals(o)) return i;
            }
            return -1;
        } else return -1;
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }


    //============= STUBS =============================================




    @Override
    public Iterator<E> iterator() {
        return null;
    }


    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


    @Override
    public boolean remove(Object o) {
        return false;
    }




    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
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
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }


}
