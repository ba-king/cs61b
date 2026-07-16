package deque;

public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    private void resize(int capacity) {
        /* 按照第二种形式resize */
        T[] a = (T[]) new Object[capacity];


        int oldFirst = (nextFirst + 1) % items.length;

        for (int i = 0; i < size; i ++) {
            int oldIndex = (oldFirst + i) % items.length;
            a[i] = items[oldIndex];
        }

        items = a;

        nextFirst = capacity - 1;
        nextLast = size;
    }

    public void addFirst(T item){
        if (size == items.length) {
            resize(size * 2);
        }

        items[nextFirst] = item;
        size += 1;

        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst -= 1;
        }
    }

    public void addLast(T item){
        if (size == items.length) {
            /* 可以按照要求来 */
            resize(size * 2);
        }

        items[nextLast] = item;
        size += 1;

        if (nextLast == items.length - 1) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }
    }

    public boolean isEmpty(){
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        int index = (nextFirst + 1) % items.length;

        for (int i = 0; i < size; i++) {
            System.out.print(items[index] + " ");
            index = (index + 1) % items.length;
        }

        System.out.println();
    }

    public T removeFirst(){
        if (size == 0) {
            return null;
        }

        if (items.length >= 16
                && size - 1 < 0.25 * items.length) {
            resize(items.length / 2);
        }

        T returnValue;

        if (nextFirst == items.length - 1) {
            returnValue = items[0];
            items[0] = null;
            nextFirst = 0;
        } else {
            returnValue = items[nextFirst + 1];
            items[nextFirst + 1] = null;
            nextFirst += 1;
        }

        size -= 1;

        return returnValue;
    }

    public T removeLast(){
        if (size == 0) {
            return null;
        }

        if (items.length >= 16
                && size - 1 < 0.25 * items.length) {
            resize(items.length / 2);
        }

        T returnValue;

        if (nextLast == 0) {
            returnValue = items[items.length - 1];
            items[items.length - 1] = null;
            nextLast = items.length - 1;
        } else {
            returnValue = items[nextLast - 1];
            items[nextLast - 1] = null;
            nextLast -= 1;
        }

        size -= 1;

        return returnValue;
    }


    public T get(int index){
        if (index < 0 || index >= size) {
            return null;
        }

        int actualIndex = (nextFirst + 1 + index) % items.length;
        return items[actualIndex];
    }

//    public Iterator<T> iterator(){
//
//    }

//    public boolean equals(Object o){
//
//    }
}
