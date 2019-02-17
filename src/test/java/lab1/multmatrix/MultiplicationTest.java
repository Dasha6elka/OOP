package lab1.multmatrix;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;
import org.junit.Test;

public class MultiplicationTest {
    @Test
    public void testZeroMatrixMultiplication() {
        float[][] matrix1 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        float[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        float[][] rightMatrix = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        Pair<float[][], float[][]> matrix = new ImmutablePair<>(matrix1, matrix2);
        float[][] finalMatrix = Multiplication.matrixMultiplication(matrix, 3);
        Assert.assertArrayEquals(finalMatrix, rightMatrix);
    }

    @Test
    public void testDiagonalUnitMatrixMultiplication() {
        float[][] matrix1 = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        float[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        float[][] rightMatrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Pair<float[][], float[][]> matrix = new ImmutablePair<>(matrix1, matrix2);
        float[][] finalMatrix = Multiplication.matrixMultiplication(matrix, 3);
        Assert.assertArrayEquals(finalMatrix, rightMatrix);
    }

    @Test
    public void testMatrixMultiplication() {
        float[][] matrix1 = {{3, 4, 8}, {2.4f, -1, 11}, {7, -3.2f, 0}};
        float[][] matrix2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        float[][] rightMatrix = {{75, 90, 105}, {75.4f, 87.8f, 100.2f}, {-5.8f, -2, 1.7999992f}};
        Pair<float[][], float[][]> matrices = new ImmutablePair<>(matrix1, matrix2);
        float[][] finalMatrix = Multiplication.matrixMultiplication(matrices, 3);
        Assert.assertArrayEquals(finalMatrix, rightMatrix);
    }
}
