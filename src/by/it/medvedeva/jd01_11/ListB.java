package by.it.medvedeva.jd01_11;

import java.util.*;
import java.util.function.UnaryOperator;

public class ListB<T> implements List<T> {

    ArrayList<T> l = new ArrayList<T>();
    public void ListA(){
    }
    @Override
    public boolean add(T e){
        return l.add(e);
    }
    @Override
    public T remove(int index) {
        return  l.remove(index);
    }
    @Override
    public T get(int index){
        return l.get(index);
    }

    @Override
    public String toString() {
        return l.toString();
    }

    @Override
    public T set(int index, T element) {
        return l.set(index, element);
    }

    @Override
    public void add(int index, T element) {
        l.add(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return l.addAll(c);
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

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
    public <T1> T1[] toArray(T1[] a) {
        return null;
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
}

