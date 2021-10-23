package com.hw2;

public class MyArrayListImpl<E> implements MyList<E> {
    private int size;
    private E[] arrayData;

    public MyArrayListImpl() {
        this.arrayData = (E[]) new Comparable[10];
    }

    @Override
    public void add(E value) {
//        checkArr();
        arrayData[size++] = value;
    }

    @Override
    public boolean add(int index, E value) {
        checkIndex(index);
//        checkArr();
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
        checkIndex(index);
        arrayData[index] = value;
    }

    @Override
    public boolean remove(int index) {
        checkIndex(index);
        System.arraycopy(arrayData, index + 1, arrayData, index, size - index - 1);
        arrayData[--size] = null;
        return true;
    }

    @Override
    public int remove(E value) {
        int qty = 0;
        for (int i = 0; i < size; i++) {
            if (arrayData[i].equals(value)) {
                remove(i--);
                qty++;
            }
        }
        return qty;
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
