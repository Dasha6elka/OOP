package lab2.decode;

import org.junit.Assert;
import org.junit.Test;

public class MainTest {

    @Test
    public void testHtlmDecodeWorks() {
        String rightOut = "Cat <says> 'Meow'. M&M's";
        String input = "Cat &lt;says&gt; &quot;Meow&quot;. M&amp;M&apos;s";
        String out = Main.HtmlDecode(input);
        Assert.assertEquals(rightOut, out);
    }
}
