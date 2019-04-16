package lab7;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    static <T extends Comparable> T FindMax(List<T> arr) {
        Collections.sort(arr);
        return arr.get(arr.size() - 1);
    }

    public static void main(String[] argv) {
        {
            var ints = Arrays.asList(1, 2, 3, 5);
            var max = FindMax(ints);
            System.out.println(max);
        }
        {
            var strings = Arrays.asList("a", "aa", "abc");
            var max = FindMax(strings);
            System.out.println(max);
        }
        {
            var doubles = Arrays.asList(34.9685, 59.123593, 120.987, 120.988);
            var max = FindMax(doubles);
            System.out.println(max);
        }
    }
}
