package lab1.task3;

import org.apache.commons.lang3.tuple.Pair;

class Multiplication {
    private Multiplication() {
    }

    static float[][] matrixMultiplication(final Pair<float[][], float[][]> sourceMatrix, final int SIZE_MATRIX) {
        float[][] finalMatrix = new float[SIZE_MATRIX][SIZE_MATRIX];
        float sum = 0;
        for (int c = 0; c < SIZE_MATRIX; c++) {
            for (int d = 0; d < SIZE_MATRIX; d++) {
                for (int k = 0; k < SIZE_MATRIX; k++) {
                    sum = (sum + sourceMatrix.getLeft()[c][k] * sourceMatrix.getRight()[k][d]);
                }
                finalMatrix[c][d] = sum;
                sum = 0;
            }
        }
        return finalMatrix;
    }
}
