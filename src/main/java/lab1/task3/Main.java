package lab1.task3;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        final int SIZE_MATRIX = 3;
        if (args.length == 0) {
            throw new IOException("No arguments!");
        }
        Pair<float[][], float[][]> sourseMatrix = new ImmutablePair<>(
            Matrix.toMatrix(new File(args[0]), SIZE_MATRIX),
            Matrix.toMatrix(new File(args[1]), SIZE_MATRIX)
        );
        float[][] finalMatrix;
        finalMatrix = Multiplication.matrixMultiplication(sourseMatrix, SIZE_MATRIX);
        for (int i = 0; i < SIZE_MATRIX; i++) {
            for (int j = 0; j < SIZE_MATRIX; j++) {
                System.out.printf("%.3f ", finalMatrix[i][j]);
            }
            System.out.println();
        }    }
}
