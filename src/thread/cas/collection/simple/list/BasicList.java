package thread.cas.collection.simple.list;

import java.util.Arrays;

public class BasicList implements SimpleList{
    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elements;
    private int size = 0;

    public BasicList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Object o) {
        elements[size] = o;
        size++;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size))+
                " size = "+size + ", capacity = "+elements.length;
    }
}
