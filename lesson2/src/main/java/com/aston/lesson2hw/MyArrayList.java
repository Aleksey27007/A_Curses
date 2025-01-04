package com.aston.lesson2hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class MyArrayList<T> implements MyList<T>{
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;
    private int size;

    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public MyArrayList(int capacity) {
        if (capacity > 0) {
            this.elements = new Object[capacity];
        } else if (capacity == 0){
            this.elements = null;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    capacity);
        }
    }

    public MyArrayList(Collection<? extends T> collection) {
        Object[] array = collection.toArray();
        if ((size = array.length) != 0) {
            if (collection.getClass() == ArrayList.class) {
                elements = array;
            } else {
                elements = Arrays.copyOf(array, size, Object[].class);
            }
        } else {
            elements = null;
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index " + index + "Out of size + " + size());
    }

    // проверка ёмкости и обеспечение расширения массива на 30 проц за каждый вызов метода при условии заполненности массива
    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length + (int) (elements.length * 0.3);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    @Override
    public boolean add(T element) {
        ensureCapacity();
        elements[size++] = element;
        return true;
    }

    @Override
    public boolean add(int index, T element) {
        rangeCheckForAdd(index);
        ensureCapacity();

        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        return true;
    }

    @Override
    public T get(int index) {
        rangeCheckForAdd(index);
        return (T) elements[index];
    }

    @Override
    public boolean remove(int index) {
        rangeCheckForAdd(index);
        int numMoved = size - index - 1;

        if(numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return true;
    }

    @Override
    public boolean clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        return true;
    }

    @Override
    public void sort(Comparator<T> comparator) {
        quickSort(0, size - 1, comparator);
    }

    private void quickSort(int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int pivotIndex = partition(low, high, comparator);
            quickSort(low, pivotIndex - 1, comparator);
            quickSort(pivotIndex + 1, high, comparator);
        }
    }

    private int partition(int low, int high, Comparator<T> comparator) {
        T pivot = get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare(get(j), pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    private void swap(int i, int j) {
        Object temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
