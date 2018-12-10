package by.it.seroglazov.jd01_11;

import java.util.*;

public class ListA<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private Object[] mas;
    private int size;

    ListA(){
        mas = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    ListA(int capacity){
        mas = new Object[capacity];
        size = 0;
    }

    @Override
    public boolean add(E e) {
        if (size == mas.length){
            int newLength = size * 3 / 2 + 1;
            Object[] nmas = new Object[newLength];
            System.arraycopy(mas, 0, nmas, 0, size);
            mas = nmas;
        }
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
        }
        else return null;
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
            sb.append(mas[i].toString());
            if (i != size - 1) sb.append(", ");
        }
        sb.append(']');
        return sb.toString();
    }

    //============= STUBS =============================================

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
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
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
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

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
