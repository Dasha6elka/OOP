package lab1.task3;

class Multiplication {
    private Multiplication() {
    }

    static float[][] matrixMultiplication(float[][] matrix1, float[][] matrix2, int SIZE) {
        float[][] matrix = new float[SIZE][SIZE];
        float sum = 0;
        for (int c = 0; c < SIZE; c++) {
            for (int d = 0; d < SIZE; d++) {
                for (int k = 0; k < SIZE; k++) {
                    sum = (sum + matrix1[c][k] * matrix2[k][d]);
                }
                matrix[c][d] = sum;
                sum = 0;
            }
        }
        return matrix;
    }
}
