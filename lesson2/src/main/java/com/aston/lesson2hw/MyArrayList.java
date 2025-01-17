package com.aston.lesson2hw;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
/**trimToSize() для удаления лишних пустых ячеек*/

/**
 * Реализуем интерфейс MyList для нашего MyArrayList, чтобы реализовать методы,
 * находящиеся в MyList.*/
public class MyArrayList<T> implements MyList<T>{
    /**
     * DEFAULT_CAPACITY стандартная ёмкость для созданного нами объекта MyArrayList - 10 */
    private static final int DEFAULT_CAPACITY = 10;
    /** Object[] elements массив элемментов, нужен для складывания в него элементы, тип Object т.к.
     * все типы наследуются от него и мы в таком случаем можем запихнуть сюда любой элемент с любым типом данных */
    private Object[] elements;
    /** size количество элементов списка */
    private int size;

    /** Первый конструктор класса, ничего не принимает,
     * создает новый массив со стандартной емкостью DEFAULT_CAPACITY ,
     * инициализирует size = 0 */
    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /** Второй конструктор класса, принимает значение ёмкости списка,
     * 1 условие если ёмкость > 0, то создаёт новый список типа Object, с размером = capacity;
     * 2 условие если ёмкость == 0, то список остаётся не инициализорованным
     * 3 в остальных случаях недопстимое значение capacity
     * это нужно для проверки на не допустимые значения на вход, т.к. в таком случае могут быть ошибки с недопустимым
     * параметром */
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
    /** Третий конструктор класса, нужен в случаях, если у нас есть колекция и нам нужно копировать элементы из
     * сторонней коллекции в нашу MyArrayList, в таком случае создастся наша коллекция с данными из другой
     * Запись вида "? extends ..." или "? super ..." — называется wildcard или символом подстановки, с верхней границей
     * (extends) или с нижней границей (super). Collection<? extends T> может содержать объекты, класс которых является
     * Collection или наследуется от Collection */
    public MyArrayList(Collection<? extends T> collection) {
        /** Конвертируем коллецию из параметра в массив*/
        Object[] array = collection.toArray();
        /** Если массив получлся не пустой */
        if ((size = array.length) != 0) {
            /** Если классы и размер совпадают, то можно просто копировать таким образом элементы */
            if (collection.getClass() == ArrayList.class) {
                elements = array;
            } else {
            /** В противном случае инициализируется новый массив типа Object с нужным нам размером size */
                elements = Arrays.copyOf(array, size, Object[].class);
            }
        /** Если пустой, то и значений в нём не должно быть */
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
            int newCapacity = elements.length + (int) (elements.length * 0.5);
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
}
