package com.hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MyListTest {
    private MyList<String> arrayList;
    private MyList<String> linkedList;

    @BeforeEach
    void init() {
        arrayList = new MyArrayListImpl();
        linkedList = new MyLinkedListImpl();
    }

    @Test
    void alSize() {
        assertEquals(0, arrayList.size());
        arrayList.add("1");
        assertEquals(1, arrayList.size());
    }

    @Test
    void llSize() {
        assertEquals(0, linkedList.size());
        linkedList.add("1");
        assertEquals(1, linkedList.size());
    }

    @Test
    void alIsEmpty() {
        assertTrue(arrayList.isEmpty());
    }

    @Test
    void llIsEmpty() {
        assertTrue(linkedList.isEmpty());
    }

    @Test
    void alAdd() {
        arrayList.add("1");
        assertEquals("1", arrayList.get(arrayList.size() - 1));
    }
//    @Test
//    void lladd() {
//        linkedList.add("1");
//        assertEquals("1", linkedList.get(linkedList.size() - 1));
//    }

    @Test
    void alAddIndex() {
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add(1, "3");
        assertEquals("3", arrayList.get(1));
        assertEquals("2", arrayList.get(2));
    }
//    @Test
//    void lladdIndex() {
//        linkedList.add("1");
//        linkedList.add("2");
//        linkedList.add(0, "3");
//        assertEquals("3", linkedList.get(0));
//        assertEquals("1", linkedList.get(1));
//    }

    @Test
    void alGet() {
        assertEquals(null, arrayList.get(0));
        arrayList.add("1");
        assertEquals("1", arrayList.get(arrayList.size() - 1));
    }

    @Test
    void llGet() {
        assertEquals(null, linkedList.get(0));
        linkedList.add("1");
        assertEquals("1", linkedList.get(linkedList.size() - 1));
    }

    @Test
    void alSet() {
        arrayList.add("1");
        arrayList.add("2");
        arrayList.set(0, "3");
        assertEquals("3", arrayList.get(0));
        assertEquals("2", arrayList.get(1));
    }

    @Test
    void alRemoveInd() {
        arrayList.add("1");
        arrayList.add("2");
        arrayList.remove(0);
        assertEquals("2", arrayList.get(0));
        assertEquals(null, arrayList.get(1));
    }

    @Test
    void alRemove() {
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("1");
        arrayList.remove("1");
        assertEquals("2", arrayList.get(0));
        assertEquals(null, arrayList.get(1));
        assertEquals(null, arrayList.get(2));
    }

    @Test
    void alContains() {
        arrayList.add("1");
        arrayList.add("2");
        assertEquals(true, arrayList.contains("2"));
        assertEquals(false, arrayList.contains("3"));
    }

}

