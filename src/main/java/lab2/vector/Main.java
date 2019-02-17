package lab2.vector;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static String[] read(Scanner in) throws IOException {
        // TODO: если одна строка, то не вылетает в ошибку сразу
        String input = in.nextLine();
        if (input == null) {
            throw new IOException("Nothing was entered into the console.");
        }
        String[] arrayOfNumber = input.split(" ");
        return arrayOfNumber;
    }

    public static List<Float> processing(String[] arrayOfNumber) {
        List<Float> vector = new ArrayList<>();
        for (String st : arrayOfNumber) {
            vector.add(Float.valueOf(st));
        }

        float max = vector.get(0);
        float min = vector.get(0);

        for (int i = 0; i < vector.size(); i++) {
            if (vector.get(i) > max) {
                max = vector.get(i);
            }
            if (vector.get(i) < min) {
                min = vector.get(i);
            }
        }

        float multiplier = max / min;

        for (int i = 0; i < vector.size(); i++) {
            float x = vector.get(i);
            float y = x * multiplier;
            vector.set(i, y);
        }
        return vector;
    }

    public static void outputOfTheResult(List<Float> vector) {
        DecimalFormat df = new DecimalFormat("#.###");

        for (int i = 0; i < vector.size(); i++) {
            float vec = vector.get(i);
            if (vec == -0) {
                vec = 0;
            }
            System.out.print(df.format(vec));
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter an array of floating-point numbers, separated by spaces:");
            String[] arrayOfNumber = Main.read(in);
            List<Float> vector = Main.processing(arrayOfNumber);
            Main.outputOfTheResult(vector);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
