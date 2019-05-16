package lab6.stringstack;

class StringStack {
    private int size;
    Node top;
    Node first;

    StringStack() {
        size = 0;
        top = null;
        first = null;
    }

    StringStack(StringStack stack) {
        try {
            if (this == stack) {
            return;
            }
            if (stack.size == 0) {
                size = 0;
                top = null;
                first = null;
                return;
            }
            Node node = new Node(stack.top.item, stack.top.next);
            Node newNode = new Node(node.next.item, node.next);
            top = node;
            top.next = newNode;
            int length = stack.size;
            while (length > 0) {
                node = newNode;
                newNode = new Node(node.next.item, node.next);
                length--;
            }
            size = stack.size;
            first = new Node(stack.first.item, stack.first.next);
        } catch (OutOfMemoryError e) {
            System.out.println(e.getMessage());
        }
    }

    void assignmentCopy(StringStack stack) {
        try {
            if (stack.size == 0) {
                size = 0;
                top = null;
                first = null;
                return;
            }
            if (this == stack) {
                return;
            }
            size = stack.size;
            int length = stack.size;
            Node node = new Node(stack.top.item, stack.top.next);
            top = node;
            Node newNode = new Node(node.next.item, node.next);
            top.next = newNode;
            while (length > 0) {
                node = newNode;
                newNode = new Node(node.next.item, node.next);
                length--;
            }
            first = new Node(stack.first.item, stack.first.next);
        } catch (OutOfMemoryError e) {
            System.out.println(e.getMessage());
        }
    }

    int getSize() {
        return size;
    }

    void push(String data) {
        try {
            if (size == 0 && top == null && first == null) {
                Node newNode = new Node(data, null);
                top = newNode;
                first = newNode;
            } else {
                top = new Node(data, top);
            }
            size++;
        } catch (OutOfMemoryError e) {
            System.out.println(e.getMessage());
        }
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
