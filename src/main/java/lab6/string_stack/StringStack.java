package lab6.string_stack;

public class StringStack {
    private int size;
    private Node top;
    private Node first;

    public StringStack() {
        size = 0;
        top = null;
        first = null;
    }

    private boolean isEmpty() {
        return size == 0 && top == null && first == null;
    }

    public StringStack copy(StringStack stack) {
        if (stack.isEmpty()) {
            return new StringStack();
        }
        this.first = stack.first;
        Node node = first;
        while (node != stack.top) {
            node = node.next;
        }
        top = stack.top;
        return this;
    }

    public StringStack move(StringStack stack) {
        if (stack.isEmpty()) {
            return new StringStack();
        }
        StringStack outStack;
        outStack = stack;
        return outStack;
    }

    public void assignmentCopy(StringStack stack) {
        if (this == stack) {
            return;
        }
        this.first = stack.first;
        Node node = first;
        while (node != stack.top) {
            node = node.next;
        }
        top = stack.top;
    }

    public void assignmentMove(StringStack stack) {
        if (this == stack) {
            return;
        }
        first = stack.first;
        size = stack.size;
        top = stack.top;
    }

    public int getSize() {
        return size;
    }

    public void push(String data) {
        if (size == 0 && top == null && first == null) {
            Node newNode = new Node(data, null);
            top = newNode;
            first = newNode;
        } else {
            Node newNode = new Node(data, top);
            top = newNode;
        }
        size++;
    }

    public String pop() {
        if (size == 0 && top == null) {
            throw new NullPointerException("Stack is empty");
        } else {
            Node out = top;
            top = top.next;
            return out.item;
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
