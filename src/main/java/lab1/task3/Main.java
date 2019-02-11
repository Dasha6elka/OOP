package lab1.task3;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int SIZE = 3;
        Pair<float[][], float[][]> matrices = new ImmutablePair<>(
            Matrix.toMatrix(new File(args[0]), SIZE),
            Matrix.toMatrix(new File(args[1]), SIZE)
        );
        float[][] matrix;
        matrix = Multiplication.matrixMultiplication(matrices.getLeft(), matrices.getRight(), SIZE);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
