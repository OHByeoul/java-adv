package thread.cas.collection.simple.list;

import java.util.Arrays;

public class SyncList implements SimpleList{
    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elements;
    private int size = 0;

    public SyncList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public synchronized int size() {
        return size;
    }

    @Override
    public synchronized void add(Object o) {
        elements[size] = o;
        size++;
    }

    @Override
    public synchronized Object get(int index) {
        return null;
    }

    @Override
    public synchronized String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size))+
                " size = "+size + ", capacity = "+elements.length;
    }
}
