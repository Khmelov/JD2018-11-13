package by.it.naumenko.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetC<T> implements Set<T> {

    T[] elements = (T[]) new Object[]{};
    int size = 0;

    @Override
    public int size() {
        return size;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(o))
                return i;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return (size != 0) ? false : true;
    }

    @Override
    public boolean contains(Object o) {
        for (T element : elements) {
            if (element.equals(o))
                return true;
        }
        return false;
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
        T1[] mas = (T1[]) new Object[]{};
        System.arraycopy(a, 0, mas, 0, a.length);
        return mas;
    }

    @Override
    public boolean add(T t) {
        boolean flag = false;
        if (size == 0) {
            elements = Arrays.copyOf(elements, elements.length + 1);
            elements[size++] = t;
        } else {
            for (int i = 0; i < elements.length; i++) {
                if (elements[i].equals(t)) {
                    flag = true;
                    return false;
                }
            }
            if (!flag) {
                elements = Arrays.copyOf(elements, elements.length + 1);
                elements[size++] = t;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        String delimetr = "";
        for (int i = 0; i < size; i++) {
            stringBuilder.append(delimetr).append(elements[i]);
            delimetr = ", ";
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }


    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index>=0) {
            System.arraycopy(elements, index + 1, elements, index, size - 1 - index);
            size--;
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean flag = false;
        Object[] a = c.toArray();
        int n = a.length;
        //T[] mas = (T[]) new Object[elements.length+n];
        elements=Arrays.copyOf(elements,size+n);
        System.arraycopy(a,0,elements,size,n);
        size+=n;
        for (int i = 0; i < size; i++){
            for (int j = 0; j < a.length; j++) {
                if (elements[i].equals(a[j])) {

                }
            }

        }
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }


}
