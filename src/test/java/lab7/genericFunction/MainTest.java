package lab7;

import lab7.genericFunction.Main;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void findMaxInArrayIntegers() {
        var arr = Arrays.asList(2, 6, 120, 566);
        assertEquals(Optional.of(566), Optional.of(Main.findMax(arr)));
    }

    @Test
    public void findMaxInArrayDoubles() {
        var arr = Arrays.asList(2.768, 6.27398, 120.845, 120.846);
        assertEquals(Optional.of(120.846), Optional.of(Main.findMax(arr)));
    }

    @Test
    public void findMaxInArrayStrings() {
        var arr = Arrays.asList("a", "abs", "z");
        assertEquals(Optional.of("z"), Optional.of(Main.findMax(arr)));
    }

    @Test
    public void badArrayError() {
        var arr = Arrays.asList(45, "car", 89.98);
        Throwable thrown = assertThrows(ClassCastException.class, () -> Main.findMax(arr));
        assertNotNull(thrown.getMessage());
    }

    @Test
    public void initUrlWithDocument2Error() {
        Throwable thrown = assertThrows(IllegalArgumentException.class, () -> Main.findMax(Collections.emptyList()));
        assertNotNull(thrown.getMessage());
    }
}
