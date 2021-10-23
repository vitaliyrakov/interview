package com.hw2;

public class MyLinkedListImpl<E> implements MyList<E> {

    private int size;
    private E[] arrayData;

    public MyLinkedListImpl() {
        this.arrayData = (E[]) new Comparable[10];
    }

    @Override
    public void add(E value) {
        arrayData[size++] = value;
    }

    @Override
    public boolean add(int index, E value) {
        checkIndex(index);

        System.arraycopy(arrayData, index, arrayData, index + 1, size - index);
        arrayData[index] = value;
        size++;
        return true;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(
                    String.format("Индекс должен соответствовать диапазону [0..%s].", size - 1)
            );
        }
    }

    @Override
    public E get(int index) {
        return arrayData[index];
    }

    @Override
    public void set(int index, E value) {

    }

    @Override
    public boolean remove(int index) {
        return true;
    }

    @Override
    public int remove(E value) {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
