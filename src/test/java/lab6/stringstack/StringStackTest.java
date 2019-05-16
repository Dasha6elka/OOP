package lab6.stringstack;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringStackTest {

    @Test
    public void constructorCopy() {
        StringStack stack = new StringStack();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        StringStack newStack = new StringStack(stack);
        assertEquals("A", newStack.first.item);
        assertEquals("C", newStack.top.item);
    }

    @Test
    public void constructorCopyEmptyStack() {
        StringStack stack = new StringStack();
        StringStack newStack = new StringStack(stack);
        assertNull(newStack.first);
        assertNull(newStack.top);
    }

    @Test
    public void assigmentMove() {
        StringStack stack = new StringStack();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        StringStack newStack = stack;
        assertEquals("A", newStack.first.item);
        assertEquals("C", newStack.top.item);
    }

    @Test
    public void assigmentMoveEmptyStack() {
        StringStack stack = new StringStack();
        StringStack newStack = stack;
        assertNull(newStack.first);
        assertNull(newStack.top);
    }

    @Test
    public void assignmentCopy() {
        StringStack stack = new StringStack();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        StringStack newStack = new StringStack();
        newStack.assignmentCopy(stack);
        assertEquals("A", newStack.first.item);
        assertEquals("C", newStack.top.item);
    }

    @Test
    public void assignmentCopyEmptyStack() {
        StringStack stack = new StringStack();
        StringStack newStack = new StringStack();
        newStack.assignmentCopy(stack);
        assertNull(newStack.first);
        assertNull(newStack.top);
    }

    @Test
    public void getSize() {
        StringStack stack = new StringStack();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals(3, stack.getSize());
    }

    @Test
    public void push() {
        StringStack stack = new StringStack();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        assertEquals("A", stack.first.item);
        assertEquals("C", stack.top.item);
        assertEquals("B", stack.top.next.item);
    }

    @Test
    public void pop() {
        StringStack stack = new StringStack();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.pop();
        assertEquals("B", stack.top.item);
    }

    @Test
    public void errorInPop() {
        StringStack stack = new StringStack();
        Throwable throwable = assertThrows(NullPointerException.class, stack::pop);
        assertNotNull(throwable.getMessage());
    }
}
