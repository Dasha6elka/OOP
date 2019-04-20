package lab7.genericClass;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

class MyList<T> implements Iterable<T>{
    Node first;
    Node last;
    int size;

    MyList() {
        first = null;
        last = null;
        size = 0;
    }

    MyList(MyList<T> list) {
        first = null;
        last = null;
        size = 0;
        Node temp = list.first;
        while (temp != null) {
            pushBack(temp.value);
            temp = temp.next;
        }
    }

    void pushForward(T value) {
        final Node currFirst = first;
        final Node newNode = new Node(currFirst, null, value);
        first = newNode;
        if (currFirst == null) {
            last = newNode;
        } else {
            currFirst.prev = newNode;
        }
        size++;
    }

    void pushBack(T value) {
        final Node currLast = last;
        final Node newNode = new Node(null, currLast, value);
        last = newNode;
        if (currLast == null) {
            first = newNode;
        } else {
            currLast.next = newNode;
        }
        size++;
    }

    int getSize() {
        return size;
    }

    void add(int index, T value) {
        if (index > size) {
            return;
        }
        int i = 0;
        Node current = first;
        while (i != index) {
            current = current.next;
            i++;
        }
        Node currPrev;
        if (current == null) {
            currPrev = last;
        } else {
            currPrev = current.prev;
        }
        Node newNode = new Node(current, currPrev, value);
        if (currPrev == null) {
            currPrev = newNode;
            first = currPrev;
            return;
        } else {
            currPrev.next = newNode;
        }
        if (current != null) {
            current.prev = newNode;
        } else {
            last = newNode;
        }
        newNode.next = current;
        newNode.prev = currPrev;
        size++;
    }

    void delete(int index) {
        if (index > size) {
            return;
        }
        int i = 0;
        Node deleted = first;
        while (i != index) {
            deleted = deleted.next;
            i++;
        }
        final Node currPrev = deleted.prev;
        final Node currNext = deleted.next;
        if (currPrev != null) {
            currPrev.next = deleted.next;
        } else {
            if (deleted.next != null) {
                first = deleted.next;
            }
        }
        if (currNext != null) {
            currNext.prev = deleted.prev;
        } else {
            if (deleted.prev != null) {
                last = deleted.prev;
            }
        }
        size--;
    }

    void assignment(MyList list) {
        if (this == list) {
            return;
        }
        Node temp = list.first;
        while (temp != null) {
            pushBack(temp.value);
            temp = temp.next;
        }
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new MyListIterator(first);
    }

    class MyListIterator implements Iterator<T> {

        private Node current;

        MyListIterator(Node current) {
            this.current = current;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            Node node = current;
            current = current.next;
            return node.value;
        }
    }

    class Node {
        Node next;
        Node prev;
        T value;

        Node(Node next, Node prev, T value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }
}
