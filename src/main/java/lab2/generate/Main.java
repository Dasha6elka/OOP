package lab2.generate;

import java.io.IOException;
import java.util.*;

public class Main {
    static final int MAX_NUMBER = 100000000;

    public static Set<Integer> GeneratePrimeNumbersSet(int upperBound) {
        boolean[] primes;
        Set<Integer> nums = new HashSet<>();
        primes = new boolean[upperBound + 1];
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i < primes.length; ++i) {
            if (primes[i]) {
                for (int j = 2; i * j < primes.length; ++j) {
                    primes[i * j] = false;
                }
            }
        }
        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                nums.add(i);
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            if (!scanner.hasNextInt()) {
                throw new IOException("The value entered is not a number");
            }
            int upperBound = scanner.nextInt();
            if (upperBound > MAX_NUMBER) {
                System.err.println("Number exceeds ");
                System.err.println(MAX_NUMBER);
            }
            Set<Integer> numbers = Main.GeneratePrimeNumbersSet(upperBound);
            TreeSet tree = new TreeSet(numbers);
            for (var num: tree) {
                System.out.print(num);
                System.out.print(" ");
            }
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
