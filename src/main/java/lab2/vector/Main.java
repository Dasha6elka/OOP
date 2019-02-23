package lab2.vector;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static String[] read(Scanner in) throws IOException {
        String input = in.nextLine();
        if (input == null) {
            throw new IOException("Nothing was entered into the console.");
        }
        return input.split(" ");
    }

    static List<Float> processing(String[] arrayOfNumber) {
        List<Float> vector = new ArrayList<>();
        for (String st : arrayOfNumber) {
            vector.add(Float.valueOf(st));
        }

        float max = vector.get(0);
        float min = vector.get(0);

        for (Float aFloat : vector) {
            if (aFloat > max) {
                max = aFloat;
            }
            if (aFloat < min) {
                min = aFloat;
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

    static ArrayList<String> outputOfTheResult(List<Float> vector) {
        DecimalFormat df = new DecimalFormat("#.###");
        ArrayList<String> out = new ArrayList<>();

        for (float vec : vector) {
            if (vec == -0) {
                vec = 0;
            }
            String inFormat = df.format(vec);
            out.add(inFormat);
        }
        return out;
    }

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter an array of floating-point numbers, separated by spaces:");
            String[] arrayOfNumber = Main.read(in);
            List<Float> vector = Main.processing(arrayOfNumber);
            Collections.sort(vector);
            List<String> vectorInFormat = Main.outputOfTheResult(vector);
            for (var vec : vectorInFormat) {
                System.out.print(vec);
                System.out.print(" ");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
