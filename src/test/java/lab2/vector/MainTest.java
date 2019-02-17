package lab2.vector;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;

public class MainTest {

    @Test
    public void testReadWorks() throws IOException {
        Scanner numbers = new Scanner("1 2 4.5 -100");
        String arr = numbers.nextLine();
        String[] rightArray = arr.split(" ");
        String[] array = Main.read(numbers);
        Assert.assertArrayEquals(rightArray, array);
    }

    @Test
    public void testProcessingWorks() {
    }

    @Test
    public void testOutputOfTheResultWorks() {
    }
}
