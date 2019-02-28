package lab2.vector;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Vector;

public class MainTest {
    @Test
    public void testReadWorks() throws IOException {
        String inputString = "1 4.5674 -1745.7";
        Scanner numbers = new Scanner(inputString);
        Scanner arrIn = new Scanner(inputString);
        String arr = arrIn.nextLine();
        String[] rightArray = arr.split(" ");
        String[] array = Main.read(numbers);
        Assert.assertArrayEquals(rightArray, array);
    }

    @Test
    public void testFormatConversion() throws IOException {
        Scanner input = new Scanner("-5 2 3.5 10");
        String[] inputString = Main.read(input);
        Vector<Float> vector = Main.processing(inputString);
        Scanner inputRight = new Scanner("10 -4 -7 -20");
        String[] inputStringRignt = Main.read(inputRight);
        Vector<Float> rightVector = new Vector<>();
        for (String st : inputStringRignt) {
            rightVector.add(Float.valueOf(st));
        }
        Assert.assertEquals(vector, rightVector);
    }

    @Test
    public void testFormatConversionWorks() throws IOException {
        Scanner input = new Scanner("-5 2 3.5555555 10");
        String[] inputString = Main.read(input);
        Vector<Float> vector = Main.processing(inputString);
        Vector<String> vectorInFormat = Main.formatConversion(vector);
        Vector<String> rightVector = new Vector<>();
        rightVector.add("10");
        rightVector.add("-4");
        rightVector.add("-7,111");
        rightVector.add("-20");
        Assert.assertEquals(vectorInFormat, rightVector);
    }

    private final ByteArrayOutputStream myOut = new ByteArrayOutputStream();
    @Test
    public void testOutputOfTheResultWorks() throws IOException {
        System.setOut(new PrintStream(myOut));
        Scanner input = new Scanner("1 2 3");
        String[] inputString = Main.read(input);
        Vector<Float> inputList = Main.processing(inputString);
        Vector<String> inputArray = Main.formatConversion(inputList);
        Main.outputOfTheResult(inputArray);
        Assert.assertEquals("3 6 9", myOut.toString());
    }
}
