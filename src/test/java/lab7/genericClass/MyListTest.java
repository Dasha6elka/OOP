package lab7.genericClass;

import org.junit.Test;

import java.util.ArrayList;

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
    public void pushForwardInIntegerListSome() {
        MyList<Integer> list = new MyList<>();
        list.pushForward(2);
        list.pushForward((int) 4.98);
        list.pushForward(0);
        MyList.Node node = list.last;
        assertEquals(4, node.prev.value);
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
    public void pushForwardOneValue() {
        MyList<Integer> list = new MyList<>();
        list.pushForward(45);
        assertEquals(45, (int) list.first.value);
        assertEquals(45, (int) list.last.value);
        assertEquals(1, list.size);
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
    public void pushBackOneValue() {
        MyList<Integer> list = new MyList<>();
        list.pushBack(45);
        assertEquals(45, (int) list.first.value);
        assertEquals(45, (int) list.last.value);
        assertEquals(1, list.size);
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
        list.add(2, 20);
        MyList.Node node = list.last;
        assertEquals(20, node.prev.value);
    }

    @Test
    public void addInIntegerListBigIndex() {
        MyList<Integer> list = new MyList<>();
        list.pushBack(8);
        list.pushBack(5);
        list.pushBack(18);
        Throwable throwable = assertThrows(IllegalArgumentException.class, () -> list.add(5, 20));
        assertNotNull(throwable.getMessage());
    }

    @Test
    public void addInIntegerListInEnd() {
        MyList<Integer> list = new MyList<>();
        list.pushBack(8);
        list.pushBack(5);
        list.pushBack(18);
        list.add(3, 20);
        MyList.Node node = list.last;
        assertEquals(20, node.value);
    }

    @Test
    public void addInIntegerListInStart() {
        MyList<Integer> list = new MyList<>();
        list.pushBack(8);
        list.pushBack(5);
        list.pushBack(18);
        list.add(0, 20);
        MyList.Node node = list.first;
        assertEquals(20, node.value);
    }

    @Test
    public void addInStringList() {
        MyList<String> list = new MyList<>();
        list.pushBack("Hello");
        list.pushBack("World");
        list.pushBack("!");
        list.add(1, "dear");
        MyList.Node node = list.first;
        assertEquals("dear", node.next.value);
    }

    @Test
    public void deleteFromIntegerListFromEnd() {
        MyList<Integer> list = new MyList<>();
        list.pushBack(8);
        list.pushBack(5);
        list.pushBack(18);
        list.delete(2);
        MyList.Node node = list.last;
        assertEquals(5, node.value);
    }

    @Test
    public void deleteFromIntegerListBigIndex() {
        MyList<Integer> list = new MyList<>();
        list.pushBack(8);
        list.pushBack(5);
        list.pushBack(18);
        Throwable throwable = assertThrows(IllegalArgumentException.class, () -> list.delete(5));
        assertNotNull(throwable.getMessage());
    }

    @Test
    public void deleteFromIntegerListFromMiddle() {
        MyList<Integer> list = new MyList<>();
        list.pushBack(8);
        list.pushBack(5);
        list.pushBack(18);
        list.delete(1);
        MyList.Node node = list.first;
        assertEquals(18, node.next.value);
    }

    @Test
    public void deleteFromStringListFromStart() {
        MyList<String> list = new MyList<>();
        list.pushBack("one");
        list.pushBack("two");
        list.pushBack("three");
        list.delete(0);
        MyList.Node node = list.first;
        assertEquals("two", node.value);
    }

    @Test
    public void assignmentIntegerList() {
        MyList<Integer> list = new MyList();
        MyList<Integer> finalList = new MyList();
        list.pushBack(3);
        list.pushBack(5);
        list.pushBack(7);
        finalList.assignment(list);
        assertEquals(3, (int) finalList.first.value);
        assertEquals(7, (int) finalList.last.value);
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
        assertEquals("My", finalList.first.value);
        assertEquals("Dasha", finalList.last.value);
    }

    @Test
    public void constructorCopyIntegerList() {
        MyList<Integer> list = new MyList<>();
        list.pushBack(4);
        list.pushBack(6);
        list.pushBack(8);
        MyList<Integer> copyList = new MyList<>(list);
        assertEquals(list.size, copyList.size);
        assertEquals(4, (int) copyList.first.value);
        assertEquals(8, (int) copyList.last.value);
    }

    @Test
    public void constructorCopyStringList() {
        MyList<String> list = new MyList<>();
        list.pushBack("water");
        list.pushBack("sun");
        list.pushBack("land");
        MyList<String> copyList = new MyList<>(list);
        assertEquals(list.size, copyList.size);
        assertEquals("water", copyList.first.value);
        assertEquals("land", copyList.last.value);
    }

    @Test
    public void integerListIteration() {
        MyList<Integer> list = new MyList<>();
        list.pushBack(10);
        list.pushBack(75);
        list.pushBack(48953);
        var copyList = new ArrayList<Integer>();
        while (list.hasNext()) {
            copyList.add(list.next());
        }
        assertEquals(10, (int) copyList.get(0));
        assertEquals(75, (int) copyList.get(1));
        assertEquals(48953, (int) copyList.get(2));
    }

    @Test
    public void stringListIteration() {
        MyList<String> list = new MyList<>();
        list.pushBack("Dasha");
        list.pushBack("Masha");
        list.pushBack("Pasha");
        var copyList = new ArrayList<String>();
        while (list.hasNext()) {
            copyList.add(list.next());
        }
        assertEquals("Dasha", copyList.get(0));
        assertEquals("Masha", copyList.get(1));
        assertEquals("Pasha", copyList.get(2));
    }

    @Test
    public void integerListBackIteration() {
        MyList<Integer> list = new MyList<>();
        list.pushBack(10);
        list.pushBack(75);
        list.pushBack(48953);
        var copyList = new ArrayList<Integer>();
        while (list.hasPrevious()) {
            copyList.add(list.previous());
        }
        assertEquals(48953, (int) copyList.get(0));
        assertEquals(75, (int) copyList.get(1));
        assertEquals(10, (int) copyList.get(2));
    }
}
