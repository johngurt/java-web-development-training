package training.linkedlist;

import java.util.*;

/**
 * @author Hurt Yevhenii
 */
public class MyLinkedList<E> implements List<E> {

    private int size;
    private Node<E> head;
    private Node<E> tail;
    private int modificationCount;

    private class Node<E> {
        E data;
        Node<E> prev;
        Node<E> next;

        Node(E element) {
            this.data = element;
        }

        Node(E data, Node<E> prev, Node<E> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }

    public MyLinkedList() {
        size = 0;
        head = null;
        tail = null;
        modificationCount = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        Node<E> current = this.head;
        if (size == 0) {
            return false;
        }
        if(o == null) {
            while (current.next != null) {
                if (current.data == null) {
                    return true;
                }
                current = current.next;
            }
        } else {
            current = this.head;
            while (current.next != null) {
                if(o.equals(current.data)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result[i] = current.data;
            current = current.next;
        }
        return result;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        modificationCount++;
        Node<E> newNode = new Node<E>(e);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        modificationCount++;
        Node<E> current = head;
        if(o == null) {
            while (current != null) {
                if (current.data == null) {
                    removeNode(current);
                    return true;
                }
                current = current.next;
            }
        } else {
            current = this.head;
            while (current != null) {
                if(o.equals(current.data)) {
                    removeNode(current);
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        c.stream().forEach(this::add);
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        checkIndexForAdd(index);
        int i = index;
        for (E element : c) {
            add(i, element);
            i++;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        modificationCount++;
        int oldSize = size;
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            if (c.contains(iterator.next())) {
                iterator.remove();
            }
        }
        return size != oldSize;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        modificationCount++;
        int oldSize = size;
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            if (!c.contains(iterator.next())) {
                iterator.remove();
            }
        }
        return size != oldSize;
    }

    @Override
    public void clear() {
        modificationCount++;
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return this.getNodeByIndex(index).data;
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        modificationCount++;
        Node<E> current = this.getNodeByIndex(index);
        E objForReturn = current.data;
        current.data = element;
        return objForReturn;
    }

    @Override
    public void add(int index, E element) {
        checkIndexForAdd(index);
        modificationCount++;
        Node<E> newNode = new  Node<E>(element, null, null);
        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (index == size) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        } else {
            Node<E> current = this.getNodeByIndex(index);
            newNode.prev = current.prev;
            newNode.next = current;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        modificationCount++;
        Node<E> current = this.getNodeByIndex(index);
        removeNode(current);
        return current.data;
    }

    @Override
    public int indexOf(Object o) {
        Node<E> current = head;
        if(o == null) {
            for (int i = 0; i < size; i++){
                if (current.data == null) {
                    return i;
                }
                current = current.next;
            }
        } else {
            current = this.head;
            for (int i = 0; i < size; i++) {
                if(o.equals(current.data)) {
                    return i;
                }
                current = current.next;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<E> current = head;
        int index = -1;
        if(o == null) {
            for (int i = 0; i < size; i++){
                if (current.data == null) {
                    index = i;
                }
                current = current.next;
            }
        } else {
            current = this.head;
            for (int i = 0; i < size; i++) {
                if(o.equals(current.data)) {
                    index = i;
                }
                current = current.next;
            }
        }
        return index;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new MyIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return new MyIterator() {
            {
                current = getNodeByIndex(index);
                cursor = index;
            }
        };
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    private Node<E> getNodeByIndex(int index) {

        int curIndex;
        Node<E> current;

        if(index <= size / 2) {
            curIndex = 0;
            current = head;

            while (curIndex < index) {
                current = current.next;
                curIndex++;
            }
            return current;
        } else {
            curIndex = size - 1;
            current = tail;

            while (curIndex > index) {
                current = current.prev;
                curIndex--;
            }
            return current;
        }
    }

    private void removeNode(Node<E> node) {
        if (node == head && node == tail) {
            head = null;
            tail = null;
        } else if (node == head) {
            head = node.next;
            node.next.prev = null;
        } else if (node == tail) {
            node.prev.next = null;
            tail = node.prev;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        size--;
    }

    private class MyIterator implements ListIterator<E> {

        int cursor = 0;
        int iteratorModCount = modificationCount;
        Node<E> current = head;
        Node<E> lastReturned = null;

        @Override
        public boolean hasNext() {
            checkModification();
            return current != null;
        }

        @Override
        public E next() {
            checkModification();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            lastReturned = current;
            current = current.next;
            cursor++;
            return lastReturned.data;
        }

        @Override
        public boolean hasPrevious() {
            checkModification();
            if (cursor > 0 && size != 0) {
                return true;
            }
            return false;
        }

        @Override
        public E previous() {
            checkModification();
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            cursor--;
            if (current == null || lastReturned != null) {
                current = lastReturned;
                return lastReturned.data;
            }
            lastReturned = current.prev;
            current = current.prev;
            return lastReturned.data;
        }

        @Override
        public int nextIndex() {
            return cursor;
        }

        @Override
        public int previousIndex() {
            return cursor - 1;
        }

        @Override
        public void remove() {
            checkModification();
            if (lastReturned == null) {
                throw new IllegalArgumentException();
            }
            removeNode(lastReturned);
            iteratorModCount = modificationCount;
            current = current.next;
            lastReturned = null;
        }

        @Override
        public void set(E e) {
            checkModification();
            if (lastReturned == null) {
                throw new NoSuchElementException();
            }
            modificationCount++;
            iteratorModCount++;
            lastReturned.data = e;
        }

        @Override
        public void add(E e) {
            checkModification();
            iteratorModCount++;
            if (current == null) {
                add(e);
            } else {
                Node<E> temp = new Node<E>(e, current.prev, current);
                if (current.prev != null) {
                    current.prev.next = temp;
                }
                current.prev = temp;
            }
        }

        private void checkModification() {
            if(iteratorModCount != modificationCount) {
                throw new UnsupportedOperationException();
            }
        }
    }

    private boolean checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        } else {
            return true;
        }
    }

    private boolean checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (current.data == null) {
                result.append("null");
            } else {
                result.append(current.data.toString());
            }
            current = current.next;
            if (i < size - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}
