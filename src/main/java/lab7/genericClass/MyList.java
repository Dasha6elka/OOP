package lab7.genericClass;

class MyList<T> {
    Node first;
    Node last;

    MyList() {
        first = null;
        last = null;
    }

    MyList(MyList<T> list) {
        first = null;
        last = null;
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
    }

    int getSize() {
        Node node = first;
        int count = 1;
        while (node != last) {
            node = first.next;
            first = node;
            count++;
        }
        return count;
    }

    void add(Node prev, T value) {
        Node currLNext = prev.next;
        final Node newNode = new Node(prev, currLNext, value);
        prev.next = newNode;
        if (currLNext == null) {
            currLNext = newNode;
            last = currLNext;
            last.next = null;
            return;
        } else {
            currLNext.prev = newNode;
        }
        newNode.next = currLNext;
        newNode.prev = prev;
    }

    void delete(Node deleted) {
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
