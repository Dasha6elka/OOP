package lab7.genericClass;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class MyListTest {

    @Test
    public void pushForwardInIntegerList() {
        MyList<Integer> list = new MyList<>();
        list.pushForward(2);
        list.pushForward(1);
        list.pushForward(0);
        MyList.Node node = list.first;
        assertEquals(0, node.value);
    }

    @Test
    public void pushForwardInStringList() {
        MyList<String> list = new MyList<>();
        list.pushForward("!");
        list.pushForward("World");
        list.pushForward("Hello");
        MyList.Node node = list.first;
        assertEquals("Hello", node.value);
    }

    @Test
    public void pushBackInIntegerList() {
        MyList<Integer> list = new MyList<>();
        list.pushBack(2);
        list.pushBack(1);
        list.pushBack(0);
        MyList.Node node = list.last;
        assertEquals(0, node.value);
    }

    @Test
    public void pushBackInStringList() {
        MyList<String> list = new MyList<>();
        list.pushBack("Hello");
        list.pushBack("World");
        list.pushBack("!");
        MyList.Node node = list.last;
        assertEquals("!", node.value);
    }

    @Test
    public void getSizeInIntegerList() {
        MyList<Integer> list = new MyList<>();
        list.pushBack(5);
        list.pushBack(12);
        list.pushBack(19);
        list.pushBack(98);
        assertEquals(4, list.getSize());
    }

    @Test
    public void getSizeInStringList() {
        MyList<String> list = new MyList<>();
        list.pushBack("Hello");
        list.pushBack("World");
        list.pushBack("!");
        assertEquals(3, list.getSize());
    }

    @Test
    public void addInIntegerList() {
        MyList<Integer> list = new MyList<>();
        list.pushBack(8);
        list.pushBack(5);
        list.pushBack(18);
        list.add(list.last.prev, 20);
        MyList.Node node = list.last;
        assertEquals(20, node.prev.value);
    }

    @Test
    public void addInIntegerListInEnd() {
        MyList<Integer> list = new MyList<>();
        list.pushBack(8);
        list.pushBack(5);
        list.pushBack(18);
        list.add(list.last, 20);
        MyList.Node node = list.last;
        assertEquals(20, node.value);
    }

    @Test
    public void addInStringList() {
        MyList<String> list = new MyList<>();
        list.pushBack("Hello");
        list.pushBack("World");
        list.pushBack("!");
        list.add(list.first, "dear");
        MyList.Node node = list.first;
        assertEquals("dear", node.next.value);
    }

    @Test
    public void deleteInIntegerListFromEnd() {
        MyList<Integer> list = new MyList<>();
        list.pushBack(8);
        list.pushBack(5);
        list.pushBack(18);
        list.delete(list.last);
        MyList.Node node = list.last;
        assertEquals(5, node.value);
    }

    @Test
    public void deleteInStringListFromStart() {
        MyList<Integer> list = new MyList<>();
        list.pushBack(8);
        list.pushBack(5);
        list.pushBack(18);
        list.delete(list.first);
        MyList.Node node = list.first;
        assertEquals(5, node.value);
    }

    @Test
    public void assignmentIntegerList() {
        MyList<Integer> list = new MyList();
        MyList<Integer> finalList = new MyList();
        list.pushBack(3);
        list.pushBack(5);
        list.pushBack(7);
        finalList.assignment(list);
        assertEquals(Optional.of(3), Optional.of(finalList.first.value));
        assertEquals(Optional.of(7), Optional.of(finalList.last.value));
    }

    @Test
    public void assignmentStringList() {
        MyList<String> list = new MyList();
        MyList<String> finalList = new MyList();
        list.pushBack("My");
        list.pushBack("name");
        list.pushBack("is");
        list.pushBack("Dasha");
        finalList.assignment(list);
        assertEquals(Optional.of("My"), Optional.of(finalList.first.value));
        assertEquals(Optional.of("Dasha"), Optional.of(finalList.last.value));
    }

    @Test
    public void constructorCopyIntegerList() {
        MyList<Integer> list = new MyList<>();
        list.pushBack(4);
        list.pushBack(6);
        list.pushBack(8);
        MyList<Integer> copyList = new MyList<>(list);
        assertEquals(Optional.of(4), Optional.of(copyList.first.value));
        assertEquals(Optional.of(8), Optional.of(copyList.last.value));
    }

    @Test
    public void constructorCopyStringList() {
        MyList<String> list = new MyList<>();
        list.pushBack("water");
        list.pushBack("sun");
        list.pushBack("land");
        MyList<String> copyList = new MyList<>(list);
        assertEquals(Optional.of("water"), Optional.of(copyList.first.value));
        assertEquals(Optional.of("land"), Optional.of(copyList.last.value));
    }
}
