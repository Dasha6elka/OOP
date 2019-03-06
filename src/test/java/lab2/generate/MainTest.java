package lab2.generate;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MainTest {
    private int from;
    private int expected;

    public MainTest(int from, int expected) {
        this.from = from;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {10, 4},
            {100, 25},
            {1000, 168},
            {100000000, 5761455}
        });
    }

    @Test
    public void testGeneratePrimeNumbersSetWorks() {
        Set<Integer> numbers = Main.GeneratePrimeNumbersSet(from);
        int actual = numbers.size();
        Assert.assertEquals(expected, actual);
    }
}
