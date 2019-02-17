package lab1.multmatrix;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            final int SIZE_MATRIX = 3;
            if (args.length == 0) {
                throw new IllegalArgumentException("No arguments!");
            }
            if (args.length != 2) {
                throw new IllegalArgumentException("The number of arguments does not match!");
            }
            Pair<float[][], float[][]> sourceMatrix = new ImmutablePair<>(
                Matrix.toMatrix(new File(args[0]), SIZE_MATRIX),
                Matrix.toMatrix(new File(args[1]), SIZE_MATRIX)
            );
            float[][] finalMatrix;
            finalMatrix = Multiplication.matrixMultiplication(sourceMatrix, SIZE_MATRIX);
            for (int i = 0; i < SIZE_MATRIX; i++) {
                for (int j = 0; j < SIZE_MATRIX; j++) {
                    System.out.printf("%.3f ", finalMatrix[i][j]);
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
