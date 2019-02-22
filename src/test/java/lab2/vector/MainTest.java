package lab2.vector;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public void testProcessingWorks() throws IOException {
        Scanner input = new Scanner("-5 2 3.5 10");
        String[] inputString = Main.read(input);
        List<Float> vector = Main.processing(inputString);
        Scanner inputRight = new Scanner("10 -4 -7 -20");
        String[] inputStringRignt = Main.read(inputRight);
        List<Float> rightVector = new ArrayList<>();
        for (String st : inputStringRignt) {
            rightVector.add(Float.valueOf(st));
        }
        Assert.assertEquals(vector, rightVector);
    }

    @Test
    public void testOutputOfTheResultWorks() throws IOException {
        Scanner input = new Scanner("-5 2 3.5 10");
        String[] inputString = Main.read(input);
        List<Float> vector = Main.processing(inputString);
        ArrayList<String> vectorInFormat = Main.outputOfTheResult(vector);
        ArrayList<String> rightVector = new ArrayList<>();
        rightVector.add("10");
        rightVector.add("-4");
        rightVector.add("-7");
        rightVector.add("-20");
        Assert.assertEquals(vectorInFormat, rightVector);

    }
}
