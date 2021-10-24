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
        checkIndex(index);
        Node<E> current = firstElement;
        Node<E> next = current.next;
        Node<E> previous = null;
        int counter = 0;

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
        if (index < 0) throw new IndexOutOfBoundsException();
    }

    @Override
    public E get(int index) {
        checkIndex(index);
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

        Node<E> current = firstElement;
        int counter = 0;

        while (counter < index) {
            current = current.next;
            if (current == null) throw new IndexOutOfBoundsException();
            counter++;
        }
        current.item = value;
    }

    @Override
    public boolean remove(int index) {
        checkIndex(index);

        Node<E> current = firstElement;
        Node<E> next = current.next;
        Node<E> previous = null;
        int counter = 0;

        while (counter < index) {
            previous = current;
            current = current.next;
            next = current.next;
            if (current == null) throw new IndexOutOfBoundsException();
            counter++;
        }
        if (index==0){
            firstElement = next;
        } else {
            previous.next = next;
        }
        next.previous = previous;
        current = null;
        size--;
        return true;
    }

    @Override
    public int remove(E value) {
        if (size == 0) return 0;

        Node<E> current = firstElement;
        Node<E> next = current.next;
        Node<E> previous = null;
        int removeCounter = 0;

        while (current != null) {
            if (current.item.equals(value)) {
                if (current == firstElement) {
                    firstElement = next;
                    next.previous = null;
                } else if (current == lastElement) {
                    lastElement = previous;
                    previous.next = null;
                } else {
                    previous.next = current.next;
                    next.previous = current.previous;
                }
                size--;
                removeCounter++;
            }
            if (next == null) break;

            current = next;
            next = current.next;
            previous = current.previous;
        }

        return removeCounter;
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
        Node<E> current = firstElement;
        while (current != null) {
            if (current.item.equals(value)) return true;
            current = current.next;
        }
        return false;
    }
}
