package lab2.mini_dictionary;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testCreateFileWorks() throws IOException {
        File file = Main.createFile("test.txt");
        Assert.assertTrue(file.exists());
    }

    @Test
    public void testInitializationDictWorks() throws IOException {
        File file = Main.createFile("input1.txt");
        Map<String, List<String>> dict = Main.initializationDict(file);
        Map<String, List<String>> rightDict = new LinkedHashMap<>();
        if (!rightDict.containsKey("cat"))
            rightDict.put("cat", new LinkedList<>());
        rightDict.get("cat").add("кот");
        Assert.assertEquals(dict, rightDict);
    }

    @Test
    public void testUnknownWordWorks() throws IOException {
        File file = Main.createFile("input2.txt");
        Map<String, List<String>> dict = Main.initializationDict(file);
        Map<String, List<String>> dictionary = Main.unknownWord("room", dict, "комната");
        Main.unknownWord("cat", dictionary, "кошка");

        Map<String, List<String>> rightDict = new LinkedHashMap<>();
        if (!rightDict.containsKey("room"))
            rightDict.put("room", new LinkedList<>());
        rightDict.get("room").add("комната");
        if (!rightDict.containsKey("cat"))
            rightDict.put("cat", new LinkedList<>());
        rightDict.get("cat").add("кошка");

        Assert.assertEquals(dictionary, rightDict);
    }

    @Test
    public void testSaveDictWorks() throws IOException {
        File file = Main.createFile("input3.txt");
        Map<String, List<String>> dict = Main.initializationDict(file);
        Map<String, List<String>> dictionary = Main.unknownWord("room", dict, "комната");
        Main.unknownWord("cat", dictionary, "кошка");
        Main.saveDict(file, dictionary);

        Scanner scanner = new Scanner(file);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        Assert.assertEquals(s1, "room\tкомната");
        Assert.assertEquals(s2, "cat\tкошка");
    }
}
