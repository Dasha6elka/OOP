package lab1.task3;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        final int size = 3;
        Pair<float[][], float[][]> matrices = new ImmutablePair<>(
            Matrix.toMatrix(new File(args[0]), size),
            Matrix.toMatrix(new File(args[1]), size)
        );
        float[][] matrix;
        matrix = Multiplication.matrixMultiplication(matrices, size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.printf("%.3f ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
