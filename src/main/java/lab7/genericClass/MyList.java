package lab7.genericClass;

import java.util.ListIterator;

class MyList<T> implements ListIterator<T> {
    Node first;
    Node last;
    private Node forwardCurrent;
    private Node backCurrent;
    int size;

    MyList() {
        first = null;
        last = null;
        Node forwardCurrent = null;
        Node backCurrent = null;
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
        forwardCurrent = first;
        backCurrent = last;
    }

    void pushForward(T value) {
        try {
            final Node currFirst = first;
            final Node newNode = new Node(currFirst, null, value);
            first = newNode;
            if (currFirst == null) {
                last = newNode;
            } else {
                currFirst.prev = newNode;
            }
            forwardCurrent = first;
            backCurrent = last;
            size++;
        } catch (OutOfMemoryError e) {
            System.out.println(e.getMessage());
        }
    }

    void pushBack(T value) {
        try {
            final Node currLast = last;
            final Node newNode = new Node(null, currLast, value);
            last = newNode;
            if (currLast == null) {
                first = newNode;
            } else {
                currLast.next = newNode;
            }
            forwardCurrent = first;
            backCurrent = last;
            size++;
        } catch (OutOfMemoryError e) {
            System.out.println(e.getMessage());
        }
    }

    int getSize() {
        return size;
    }

    void add(int index, T value) {
        try {
            if (index > size) {
                throw new IllegalArgumentException("Index is big");
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
            forwardCurrent = first;
            backCurrent = last;
            size++;
        } catch (OutOfMemoryError e) {
            System.out.println(e.getMessage());
        }
    }

    void delete(int index) {
        if (index > size) {
            throw new IllegalArgumentException("Index is big");
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
        forwardCurrent = first;
        backCurrent = last;
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

    @Override
    public boolean hasNext() {
        return forwardCurrent != null;
    }

    @Override
    public T next() {
        Node node = forwardCurrent;
        forwardCurrent = forwardCurrent.next;
        return node.value;
    }

    @Override
    public boolean hasPrevious() {
        return backCurrent != null;
    }

    @Override
    public T previous() {
        Node node = backCurrent;
        backCurrent = backCurrent.prev;
        return node.value;
    }

    @Override
    public int nextIndex() {
        return 0;
    }

    @Override
    public int previousIndex() {
        return 0;
    }

    @Override
    public void remove() {
    }

    @Override
    public void set(T t) {
    }

    @Override
    public void add(T t) {
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
