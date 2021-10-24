package com.hw2;

public class MyLinkedListImpl<E> implements MyList<E> {

    private int size;
    private Node<E> firstElement;
    private Node<E> lastElement;

    class Node<E> {
        E item;
        Node<E> previous;
        Node<E> next;

        public Node(E item, Node<E> previous, Node<E> next) {
            this.item = item;
            this.previous = previous;
            this.next = next;
        }
    }

    @Override
    public void add(E value) {
        Node<E> entry = new Node<>(value, lastElement, null);
        if (isEmpty()) {
            firstElement = entry;
        } else {
            lastElement.next = entry;
        }
        lastElement = entry;
        size++;
    }

    @Override
    public boolean add(int index, E value) {
        Node<E> current = firstElement;
        Node<E> next = current.next;
        Node<E> previous = null;
        int counter = 0;

        if (index < 0) throw new IndexOutOfBoundsException();

        if (index == 0) {
            Node<E> entry = new Node<>(value, null, current);
            current.previous = entry;
            firstElement = entry;
            size++;
            return true;
        }

        while (current != null && counter < index) {
            previous = current;
            current = current.next;
            next = current.next;
            counter++;
        }

        if (current == null) throw new IndexOutOfBoundsException();

        Node<E> entry = new Node<>(value, previous, next);
        if (current.next == null) {
            lastElement = entry;
        }
        previous.next = entry;
        current.previous = entry;
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
        if (index < 0) throw new IndexOutOfBoundsException();
        if (size == 0) throw new IndexOutOfBoundsException();

        Node<E> current = firstElement;
        int counter = 0;

        while (counter < index) {
            current = current.next;
            if (current == null) throw new IndexOutOfBoundsException();
            counter++;
        }
        return current.item;
    }

    @Override
    public void set(int index, E value) {
        checkIndex(index);
    }

    @Override
    public boolean remove(int index) {
        checkIndex(index);
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

    @Override
    public boolean contains(E value) {
        return false;
    }
}
