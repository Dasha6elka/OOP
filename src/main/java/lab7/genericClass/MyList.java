package lab7.genericClass;

public class MyList<T> {
    private Node first;
    private Node last;

    public MyList() {
        first = null;
        last = null;
    }

    public MyList(MyList list) {
        first = null;
        last = null;
        Node temp = list.first;
        while (temp != null) {
            pushBack(temp.value);
            temp = temp.next;
        }
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

    public Node begin() {
        return first;
    }

    public Node end() {
        return last;
    }

    public Node rbegin() {
        return last;
    }

    public Node rend() {
        return first;
    }

    public int getSize() {
        Node node = first;
        int count = 0;
        while (node != last) {
            node = first.next;
            first = node;
            count++;
        }
        return count;
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
        if (currPrev != null) {
            currPrev.next = deleted.next;
        }
        if (currNext != null) {
            currNext.prev = deleted.prev;
        }
    }

    public MyList<T> assignment(MyList list) {
        if (this == list) {
            return this;
        }
        Node temp = list.first;
        while (temp != null) {
            pushBack(temp.value);
            temp = temp.next;
        }
        return this;
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
