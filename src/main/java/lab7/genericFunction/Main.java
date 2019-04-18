package lab7.genericFunction;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static <T extends Comparable> T findMax(List<T> arr) {
        if (arr.isEmpty()) {
            throw new IllegalArgumentException("Array is empty");
        }
        Collections.sort(arr);
        return arr.get(arr.size() - 1);
    }

    public static void main(String[] argv) {
        try {
            {
                try {
                    var ints = Collections.singletonList(1);
                    ints.clear();
                    var max = findMax(ints);
                    System.out.println(max);
                } catch (Exception e) {
                    System.out.println("Array is empty");
                }
            }
            {
                var ints = Arrays.asList(1, 2, 3, 5);
                var max = findMax(ints);
                System.out.println(max);
            }
            {
                var strings = Arrays.asList("a", "aa", "abc");
                var max = findMax(strings);
                System.out.println(max);
            }
            {
                var doubles = Arrays.asList(34.9685, 59.123593, 120.987, 120.988);
                var max = findMax(doubles);
                System.out.println(max);
            }
            {
                var arr = Arrays.asList(45, "car", 89.98);
                var max = findMax(arr);
                System.out.println(max);
            }
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
