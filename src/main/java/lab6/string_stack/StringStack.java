package lab6.string_stack;

class StringStack {
    private int size;
    Node top;
    Node first;

    StringStack() {
        size = 0;
        top = null;
        first = null;
    }

    private boolean isEmpty() {
        return size == 0 && top == null && first == null;
    }

    StringStack copy(StringStack stack) {
        if (stack.isEmpty()) {
            return new StringStack();
        }
        this.top = stack.top;
        Node node = top;
        while (node != stack.first) {
            node = node.next;
        }
        first = stack.first;
        return this;
    }

    StringStack move(StringStack stack) {
        if (stack.isEmpty()) {
            return new StringStack();
        }
        StringStack outStack;
        outStack = stack;
        return outStack;
    }

    void assignmentCopy(StringStack stack) {
        if (this == stack) {
            return;
        }
        this.top = stack.top;
        Node node = top;
        while (node != stack.first) {
            node = node.next;
        }
        first = stack.first;
    }

    void assignmentMove(StringStack stack) {
        if (this == stack) {
            return;
        }
        first = stack.first;
        size = stack.size;
        top = stack.top;
    }

    int getSize() {
        return size;
    }

    void push(String data) {
        if (size == 0 && top == null && first == null) {
            Node newNode = new Node(data, null);
            top = newNode;
            first = newNode;
        } else {
            top = new Node(data, top);
        }
        size++;
    }

    void pop() {
        if (size == 0 && top == null) {
            throw new NullPointerException("Stack is empty");
        } else {
            top = top.next;
        }
    }

    class Node{
        String item;
        Node next;

        Node(String item, Node next) {
            this.item = item;
            this.next = next;
        }
    }
}
