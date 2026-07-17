package deque;

public class LinkedListDeque<T> {
    private class Node {
        public T item;
        public Node prev;
        public Node next;

        public Node(T i , Node p, Node n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new Node(null, null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public T getRecurHelper(Node curr, int count, int index) {
        if (count == index) {
            return curr.item;
        }
        return getRecurHelper(curr.next, count + 1, index);
    }

    public T getRecursive(int index){
        if (index < 0 || index >= size) {
            return null;
        }

        int count = 0;
        return getRecurHelper(sentinel.next, count, index);
    }

    public void addFirst(T item){
        /* Create new node, finishing : sentinel <- newNode-> remaining */
        Node newNode = new Node(item, sentinel, sentinel.next);
        /*  two links of orinial still need to change */
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size += 1;
    }

    public void addLast(T item){
        Node newNode = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size += 1;

    }

    public boolean isEmpty(){
        if (sentinel.next == sentinel) {
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        Node tmp = sentinel.next;

        while (tmp != sentinel) {
            System.out.print(tmp.item + " ");
            tmp = tmp.next;
        }

        System.out.println();
    }

    public T removeFirst(){
        if (sentinel.next == sentinel) {
            return null;
        } else {
            T returnValue = sentinel.next.item;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;

            size -= 1;
            return returnValue;
        }
    }

    public T removeLast(){
        if (sentinel.prev == sentinel) {
            return null;
        } else {
            T returnValue = sentinel.prev.item;
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;

            size -= 1;
            return returnValue;
        }
    }


    public T get(int index){
        int count = 0;
        Node tmp = sentinel.next;

        while (count != index) {
            tmp = tmp.next;
            count += 1;
        }
        return tmp.item;
    }

//    public Iterator<T> iterator(){
//
//    }

//    public boolean equals(Object o){
//
//    }

}

