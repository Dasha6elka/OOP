package lab7.genericClass;

public class MyList<T> {
    private Node first;
    private Node last;

    public MyList() {
        first = null;
        last = null;
    }

    public void pushForward(T value) {
        final Node currFirst = first;
        final Node newNode = new Node(currFirst, null, value);
        first = newNode;
        if (currFirst == null) {
            last = newNode;
        } else {
            currFirst.prev = newNode;
        }
    }

    public void pushBack(T value) {
        final Node currLast = last;
        final Node newNode = new Node(null, currLast, value);
        last = newNode;
        if (currLast == null) {
            first = newNode;
        } else {
            currLast.next = newNode;
        }
    }

    public Node add(Node prev, T value) {
        final Node currPrev = prev;
        final Node currLNext = prev.next;
        final Node newNode = new Node(currPrev, currLNext, value);
        currPrev.next = newNode;
        currLNext.prev = newNode;
        newNode.next = currLNext;
        newNode.prev = currPrev;
        if (currLNext == null) {
            currLNext.prev = newNode;
        }
        return newNode;
    }

    public void delete(Node deleted) {
        final Node currPrev = deleted.prev;
        final Node currNext = deleted.next;
    }

    private class Node {
        Node next, prev;
        T value;

        public Node(Node next, Node prev, T value) {
            this.next = next;
            this.prev = prev;
            this.value = value;
        }
    }
}
