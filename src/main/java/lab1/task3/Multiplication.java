package lab1.task3;

import org.apache.commons.lang3.tuple.Pair;

class Multiplication {
    private Multiplication() {
    }

    static float[][] matrixMultiplication(final Pair<float[][], float[][]> matrices, final int size) {
        float[][] matrix = new float[size][size];
        float sum = 0;
        for (int c = 0; c < size; c++) {
            for (int d = 0; d < size; d++) {
                for (int k = 0; k < size; k++) {
                    sum = (sum + matrices.getLeft()[c][k] * matrices.getRight()[k][d]);
                }
                matrix[c][d] = sum;
                sum = 0;
            }
        }
        return matrix;
    }
}
