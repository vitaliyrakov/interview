package com.hw2;

public interface MyList<E> {

    void add(E value);

    boolean add(int index, E value);

    E get(int index);

    void set(int index, E value);

    int remove(E value);

    boolean remove(int index);

    boolean contains(E value);

    boolean isEmpty();

    int size();
}
