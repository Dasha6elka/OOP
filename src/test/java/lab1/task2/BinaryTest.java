package lab1.task2;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class BinaryTest {
    private String from;
    private int expected;

    public BinaryTest(String from, int expected) {
        this.from = from;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
            {"110010000", 400},
            {"100", 4},
            {"11110000", 240},
            {"00111011", 59},
            {"1111111111111111111111111111111", 2147483647}
        });
    }

    @Test
    public void testBinToDecWorks() {
        var actual = Binary.bin2dec(from);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testVerifyWorks() {
        Assert.assertFalse(Binary.verify("5046"));
        Assert.assertFalse(Binary.verify("110200101"));
    }
}
