package training.arraylist;

import java.util.*;

/**
 * @author Hurt Yevhenii
 */
public class MyArrayList <E> implements List <E> {

    public static final int DEFAULT_CAPACITY = 10;
    private int modificationCount;

    private int size;
    Object[] arr;

    public MyArrayList() {
        size = 0;
        arr = new Object[DEFAULT_CAPACITY];
        modificationCount = 0;
    }

    public MyArrayList(int initialSize) {
        if(initialSize < 0) {
            throw new IllegalArgumentException();
        } else {
            size = 0;
            arr = new Object[initialSize];
            modificationCount = 0;
        }
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
        if(o == null) {
            for (int i = 0; i < size; i++) {
                if(arr[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(arr[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(this.arr, 0, result, 0, size);
        return result;
    }

    @Override
    public boolean add(Object o) {
        ensureCapacity(this.size + 1);
        arr[size] = o;
        size++;
        return true;
    }

    public void ensureCapacity(int requiredCapacity) {
        modificationCount++;
        if(requiredCapacity == arr.length) {
            Object[] newArr = new Object[3 * arr.length / 2 + 1];
            System.arraycopy(this.arr, 0, newArr, 0, arr.length);
            this.arr = newArr;
        }
    }

    @Override
    public boolean remove(Object o) {
        modificationCount++;
        if(o == null) {
            for(int i = 0; i < size; i++) {
                if(arr[i] == null) {
                    fastRemove(i);
                    return true;
                }
            }
        } else {
            for(int i = 0; i < size; i++) {
                if(o.equals(arr[i])) {
                    fastRemove(i);
                    return true;
                }
            }
        }
        return false;
    }

    public void fastRemove(int index) {
        int numberOfMoves = size - index - 1;
        if (numberOfMoves > 0) {
            System.arraycopy(arr, index + 1, arr, index, numberOfMoves);
        }
        arr[--size] = null;
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
            this.add(i, element);
            i++;
        }
        return true;
    }

    @Override
    public void clear() {
        modificationCount++;
        arr = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) arr[index];
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        modificationCount++;
        E objForReturn = (E) arr[index];
        arr[index] = element;
        return objForReturn;
    }

    @Override
    public void add(int index, Object element) {
        checkIndexForAdd(index);
        ensureCapacity(size + 1);
        System.arraycopy(arr, index, arr, index + 1, size - index);
        arr[index] = element;
        size++;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        modificationCount++;
        E objForReturn = (E) arr[index];
        fastRemove(index);
        return objForReturn;
    }

    @Override
    public int indexOf(Object o) {
        if(o == null) {
            for (int i = 0; i < size; i++) {
                if(arr[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(arr[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        if(o == null) {
            for (int i = 0; i < size; i++) {
                if(arr[i] == null) {
                    index = i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(arr[i])) {
                    index = i;
                }
            }
        }
        return index;
    }

    @Override
    public ListIterator listIterator() {
        return new MyListIterator();
    }

    @Override
    public ListIterator listIterator(int index) {
        return new  MyListIterator(index);
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        modificationCount++;
        int oldSize = size;
        Iterator iterator = this.iterator();
        while (iterator.hasNext()) {
            if(!c.contains(iterator.next())) {
                iterator.remove();
            }
        }
        return size != oldSize;
    }

    @Override
    public boolean removeAll(Collection c) {
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
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(arr[i]);
            if (i < size - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
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

    private class MyIterator implements Iterator<E> {
        int cursor;
        int lastReturned = -1;
        int expectedModCount = modificationCount;


        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            checkForModCount();
            if (cursor >= size) {
                throw new NoSuchElementException();
            }
            if (cursor >= MyArrayList.this.arr.length) {
                throw new ConcurrentModificationException();
            }
            lastReturned = cursor;
            cursor++;
            return (E) MyArrayList.this.arr[lastReturned];
        }

        @Override
        public void remove() {
            if (lastReturned < 0) {
                throw new IllegalStateException();
            }
            checkForModCount();

            try {
                MyArrayList.this.remove(lastReturned);
                cursor = lastReturned;
                lastReturned = -1;
                expectedModCount = modificationCount;
            } catch (IndexOutOfBoundsException e) {
                throw new ConcurrentModificationException();
            }
        }

        void checkForModCount() {
            if (modificationCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }
    }

    private class MyListIterator extends MyIterator implements ListIterator<E> {

        MyListIterator() {
        }

        MyListIterator(int index) {
            checkIndex(index);
            cursor = index;
        }

        @Override
        public boolean hasPrevious() {
            return cursor != 0;
        }

        @Override
        public E previous() {
            checkForModCount();
            if (cursor - 1 < 0) {
                throw new NoSuchElementException();
            }
            if (cursor - 1 >= MyArrayList.this.arr.length) {
                throw new ConcurrentModificationException();
            }
            cursor--;
            lastReturned = cursor;
            return (E) MyArrayList.this.arr[lastReturned];
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
        public void set(E e) {
            if (lastReturned < 0) {
                throw new IllegalStateException();
            }
            checkForModCount();

            try {
                MyArrayList.this.set(lastReturned, e);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public void add(E e) {
            checkForModCount();

            try {
                MyArrayList.this.add(cursor, e);
                cursor++;
                lastReturned = -1;
                expectedModCount = modificationCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }
    }
}
