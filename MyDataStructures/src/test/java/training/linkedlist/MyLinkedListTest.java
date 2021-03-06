package training.linkedlist;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;

public class MyLinkedListTest {

    private List<Integer> emptyList;
    private List<Integer> listWithThreeElements = new MyLinkedList<>();
    private List<Integer> listWithThreeElementsOneIsNull = new MyLinkedList<>();
    private List<Integer> listWithOneNullElement = new MyLinkedList<>();
    private Integer[] empty;
    private Integer[] oneNull;
    private Integer[] array3NotNull;
    private Integer[] array3OneNull;

    @Before
    public void init() {
        emptyList = new MyLinkedList<>();
        listWithThreeElements.add(1);
        listWithThreeElements.add(2);
        listWithThreeElements.add(3);
        listWithThreeElementsOneIsNull.add(1);
        listWithThreeElementsOneIsNull.add(null);
        listWithThreeElementsOneIsNull.add(3);
        listWithOneNullElement.add(null);

        empty = new Integer[0];
        oneNull = new Integer[1];
        oneNull[0] = null;
        array3NotNull = new Integer[3];
        array3NotNull[0] = 1;
        array3NotNull[1] = 2;
        array3NotNull[2] = 3;
        array3OneNull = new Integer[3];
        array3OneNull[0] = 1;
        array3OneNull[1] = null;
        array3OneNull[2] = 3;
    }

    @Test
    public void testMyLinkedListCreation() {
        Assert.assertNotNull("1. Not null", emptyList);
    }

    @Test
    public void testSize() throws Exception {
        org.junit.Assert.assertEquals("1. Size=0", 0, emptyList.size());
        org.junit.Assert.assertEquals("2. Size=3", 3, listWithThreeElements.size());
        org.junit.Assert.assertEquals("3. Size=3", 3, listWithThreeElementsOneIsNull.size());
        System.out.println(listWithThreeElementsOneIsNull);
        listWithThreeElementsOneIsNull.remove(0);
        System.out.println(listWithThreeElementsOneIsNull.size());
        System.out.println(listWithThreeElementsOneIsNull);
        org.junit.Assert.assertEquals("4. Size=2 after removing", 2, listWithThreeElementsOneIsNull.size());
        listWithThreeElementsOneIsNull.add(0);
        org.junit.Assert.assertEquals("5. Size=3 after adding", 3, listWithThreeElementsOneIsNull.size());
        org.junit.Assert.assertEquals("6. Size=1 with one null element", 1, listWithOneNullElement.size());
    }

    @Test
    public void testIsEmpty() throws Exception {
        org.junit.Assert.assertTrue("1. Empty", emptyList.isEmpty());
        org.junit.Assert.assertFalse("2. Not Empty", listWithThreeElements.isEmpty());
        org.junit.Assert.assertFalse("3. Not Empty", listWithOneNullElement.isEmpty());
    }

    @Test
    public void testContains() throws Exception {
        org.junit.Assert.assertFalse("1. Empty", emptyList.contains(null));
        org.junit.Assert.assertFalse("2. Empty", emptyList.contains(0));
        org.junit.Assert.assertFalse("3. Non empty not null not contains", listWithThreeElements.contains(0));
        org.junit.Assert.assertTrue("4. Non empty not null contains", listWithThreeElements.contains(2));
        org.junit.Assert.assertFalse("5. Non empty not null not contains null", listWithThreeElements.contains(null));
        org.junit.Assert.assertTrue("6. Non empty with null contains null", listWithThreeElementsOneIsNull.contains(null));
    }

    @Test
    public void testIterator() throws Exception {
        Iterator<Integer> iterator = listWithThreeElementsOneIsNull.iterator();
        org.junit.Assert.assertTrue("1", iterator.hasNext());
        org.junit.Assert.assertEquals("2", new Integer(1), iterator.next());
        org.junit.Assert.assertTrue("3", iterator.hasNext());
        org.junit.Assert.assertEquals("4", null, iterator.next());
        org.junit.Assert.assertTrue("5", iterator.hasNext());
        org.junit.Assert.assertEquals("6", new Integer(3), iterator.next());
        org.junit.Assert.assertFalse("7", iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorException() throws Exception {
        Iterator<Integer> iterator = listWithThreeElementsOneIsNull.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
    }

    @Test
    public void testToArray() throws Exception {
        assertArrayEquals("1. Empty", empty, emptyList.toArray());
        assertArrayEquals("2. One null element", oneNull, listWithOneNullElement.toArray());
        assertArrayEquals("3. not empty without null", array3NotNull, listWithThreeElements.toArray());
        assertArrayEquals("4. not empty with null", array3NotNull, listWithThreeElements.toArray());
    }

    @Test
    public void testToArray1() throws Exception {
        Object testArray[];
        testArray = emptyList.toArray();
        assertArrayEquals("1. Empty", empty, testArray);
        testArray = listWithOneNullElement.toArray();
        assertArrayEquals("2. One null element", oneNull, testArray);
        testArray = listWithThreeElements.toArray();
        assertArrayEquals("3. not empty without null", array3NotNull, testArray);
        testArray = listWithThreeElements.toArray();
        assertArrayEquals("4. not empty with null", array3NotNull, testArray);
    }

    @Test
    public void testAdd() throws Exception {
        System.out.println(emptyList);
        emptyList.add(42);
        System.out.println(emptyList);
        org.junit.Assert.assertEquals("1. added not null to empty list", 1, emptyList.size());
        org.junit.Assert.assertEquals("2. retrieved the same element", new Integer(42), emptyList.get(0));
        emptyList.add(null);
        System.out.println(emptyList);
        org.junit.Assert.assertEquals("1. added null list", 2, emptyList.size());
        org.junit.Assert.assertNull("2. retrieved the same null", emptyList.get(1));
    }

    @Test
    public void testRemoveNull() throws Exception {
        listWithOneNullElement.remove(null);
        org.junit.Assert.assertEquals("1. removed null", 0, listWithOneNullElement.size());
        org.junit.Assert.assertFalse("2. removed not in list", listWithOneNullElement.contains(null));
    }

    @Test
    public void testRemoveNotNull() throws Exception {
        listWithThreeElementsOneIsNull.remove(new Integer(1));
        org.junit.Assert.assertEquals("1. removed null", 2, listWithThreeElementsOneIsNull.size());
        org.junit.Assert.assertEquals("2. check 1st elem after remove", null, listWithThreeElementsOneIsNull.get(0));
        org.junit.Assert.assertEquals("2. check 1nd elem after remove", new Integer(3), listWithThreeElementsOneIsNull.get(1));

        listWithThreeElementsOneIsNull.remove(new Integer(3));
        org.junit.Assert.assertEquals("2. check 1nd elem after 2 next remove", null, listWithThreeElementsOneIsNull.get(0));
    }

    @Test
    public void testContainsAll() throws Exception {
        List<Integer> list1 = new LinkedList<>();
        list1.add(1);
        List<Integer> list2 = new LinkedList<>();
        list2.add(2);
        System.out.println(list1.equals(list2));
    }

    @Test
    public void testAddAll() throws Exception {
        List<Integer> testList = new LinkedList<>(listWithThreeElementsOneIsNull);
        testList.addAll(listWithThreeElements);
        listWithThreeElementsOneIsNull.addAll(listWithThreeElements);
        System.out.println((testList.size()));
        System.out.println(listWithThreeElementsOneIsNull.size());
        org.junit.Assert.assertEquals(testList, listWithThreeElementsOneIsNull);
    }

    @Test
    public void testAddAll1() throws Exception {
        List<Integer> testList = new LinkedList<>(listWithThreeElementsOneIsNull);
        testList.addAll(2, listWithThreeElements);
        listWithThreeElementsOneIsNull.addAll(2, listWithThreeElements);
        org.junit.Assert.assertEquals("1. At the end", testList, listWithThreeElementsOneIsNull);

        testList.addAll(3, listWithThreeElements);
        listWithThreeElementsOneIsNull.addAll(3, listWithThreeElements);
        org.junit.Assert.assertEquals("2. at the middle", testList, listWithThreeElementsOneIsNull);

        testList.addAll(0, listWithThreeElements);
        listWithThreeElementsOneIsNull.addAll(0, listWithThreeElements);
        org.junit.Assert.assertEquals("3. at the begin", testList, listWithThreeElementsOneIsNull);
    }

    @Test
    public void testRemoveAll() throws Exception {
        List<Integer> testList = new LinkedList<>(listWithThreeElementsOneIsNull);
        listWithThreeElementsOneIsNull.add(4);
        listWithThreeElementsOneIsNull.add(5);
        listWithThreeElementsOneIsNull.add(6);
        listWithThreeElementsOneIsNull.removeAll(testList);
        testList.clear();
        testList.add(4);
        testList.add(5);
        testList.add(6);
        org.junit.Assert.assertEquals("", testList, listWithThreeElementsOneIsNull);

    }

    @Test
    public void testRetainAll() throws Exception {
        List<Integer> testList = new LinkedList<>(listWithThreeElementsOneIsNull);
        listWithThreeElementsOneIsNull.add(4);
        listWithThreeElementsOneIsNull.add(5);
        listWithThreeElementsOneIsNull.add(6);
        listWithThreeElementsOneIsNull.retainAll(testList);
        testList.clear();
        testList.add(1);
        testList.add(null);
        testList.add(3);
        System.out.println(testList);
        System.out.println(listWithThreeElementsOneIsNull);

        org.junit.Assert.assertEquals("", testList, listWithThreeElementsOneIsNull);
    }

    @Test
    public void testClear() throws Exception {
        listWithThreeElementsOneIsNull.clear();
        org.junit.Assert.assertEquals(0, listWithThreeElementsOneIsNull.size());
    }

    @Test
    public void testGet() throws Exception {
        org.junit.Assert.assertEquals(new Integer(2), listWithThreeElements.get(1));
    }

    @Test
    public void testSet() throws Exception {
        listWithThreeElementsOneIsNull.set(1,2);
        org.junit.Assert.assertEquals(new Integer(2), listWithThreeElementsOneIsNull.get(1));
    }

    @Test
    public void testAddToPosition() throws Exception {
        List<Integer> testList = new LinkedList<>(listWithThreeElementsOneIsNull);
        testList.add(1,2);
        listWithThreeElementsOneIsNull.add(1,2);
        org.junit.Assert.assertEquals(testList, listWithThreeElementsOneIsNull);
    }

    @Test
    public void testRemoveByIndex() throws Exception {
        List<Integer> testList = new LinkedList<>(listWithThreeElementsOneIsNull);
        testList.remove(1);
        listWithThreeElementsOneIsNull.remove(1);
        org.junit.Assert.assertEquals(testList, listWithThreeElementsOneIsNull);
    }

    @Test
    public void testIndexOf() throws Exception {
        listWithThreeElementsOneIsNull.add(2,3);
        listWithThreeElementsOneIsNull.add(2,null);
        System.out.println(listWithThreeElementsOneIsNull);
        org.junit.Assert.assertEquals("1. No such element", -1, listWithThreeElementsOneIsNull.indexOf(5));
        org.junit.Assert.assertEquals("2. Has element", 3, listWithThreeElementsOneIsNull.indexOf(3));
        org.junit.Assert.assertEquals("3. Has element", 0, listWithThreeElementsOneIsNull.indexOf(1));
        org.junit.Assert.assertEquals("4. Has null element", 1, listWithThreeElementsOneIsNull.indexOf(null));
        org.junit.Assert.assertEquals("5. Has no null element", -1, listWithThreeElements.indexOf(null));
    }


    @Test
    public void testLastIndexOf() {
        listWithThreeElementsOneIsNull.add(2,3);
        listWithThreeElementsOneIsNull.add(2,null);
        org.junit.Assert.assertEquals("1. No such element", -1, listWithThreeElementsOneIsNull.lastIndexOf(5));
        org.junit.Assert.assertEquals("2. Has element", 4, listWithThreeElementsOneIsNull.lastIndexOf(3));
        org.junit.Assert.assertEquals("3. Has element", 0, listWithThreeElementsOneIsNull.lastIndexOf(1));
        org.junit.Assert.assertEquals("4. Has null element", 2, listWithThreeElementsOneIsNull.lastIndexOf(null));
        org.junit.Assert.assertEquals("5. Has no null element", -1, listWithThreeElements.lastIndexOf(null));
    }

    @Test
    public void testListIterator() throws Exception {
        ListIterator<Integer> iterator = listWithThreeElementsOneIsNull.listIterator();
        org.junit.Assert.assertTrue("1", iterator.hasNext());
        org.junit.Assert.assertFalse("2", iterator.hasPrevious());
        org.junit.Assert.assertEquals("3", new Integer(1), iterator.next());
        org.junit.Assert.assertTrue("4", iterator.hasNext());
        org.junit.Assert.assertTrue("5", iterator.hasPrevious());
        org.junit.Assert.assertEquals("6", null, iterator.next());
        org.junit.Assert.assertTrue("7", iterator.hasNext());
        org.junit.Assert.assertTrue("8", iterator.hasPrevious());
        org.junit.Assert.assertEquals("9", new Integer(3), iterator.next());
        org.junit.Assert.assertTrue("10", iterator.hasPrevious());
        org.junit.Assert.assertFalse("11", iterator.hasNext());
        org.junit.Assert.assertEquals("12", new Integer(3), iterator.previous());
        org.junit.Assert.assertTrue("13", iterator.hasNext());
        org.junit.Assert.assertTrue("14", iterator.hasPrevious());
        org.junit.Assert.assertEquals("15", new Integer(3), iterator.next());
    }

    @Test(expected = NoSuchElementException.class)
    public void testListIteratorException() throws Exception {
        ListIterator<Integer> iterator = listWithThreeElementsOneIsNull.listIterator();
        iterator.next();
        iterator.next();
        iterator.previous();
        iterator.previous();
        iterator.previous();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testListIteratorConcurrentException() throws Exception {
        for (Integer i : listWithThreeElementsOneIsNull) {
            listWithThreeElementsOneIsNull.remove(i);
        }
    }


    @Test(expected = ConcurrentModificationException.class)
    public void testListIteratorMustBeConcurrentException() throws Exception {
        List<Integer> arrayList = new MyLinkedList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        int counter = 0;
        for (Integer i : arrayList) {
            counter++;
            if (counter == 3 ) {
                arrayList.remove(arrayList.indexOf(i));
            }
        }
    }

    @Test(expected = ConcurrentModificationException.class)
    public void testListIteratorConcurrentException2() throws Exception {
        for (Integer i : listWithThreeElementsOneIsNull) {
            if (i == null) {
                listWithThreeElementsOneIsNull.add(i);
            }
        }
    }

    @Test
    public void testListIterator1() throws Exception {
        ListIterator<Integer> iterator = listWithThreeElementsOneIsNull.listIterator(1);
        org.junit.Assert.assertTrue("1", iterator.hasNext());
        org.junit.Assert.assertTrue("2", iterator.hasPrevious());
        org.junit.Assert.assertEquals("3", null, iterator.next());
    }

}