package lab1.task3;

import org.apache.commons.lang3.math.NumberUtils;

import java.io.*;

class Matrix {
    private Matrix() {
    }

    static float[][] toMatrix(final File file, final int SIZE_MATRIX) throws IOException {
        InputStream input = new FileInputStream(file);
        float[][] matrix;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(input))) {
            String line;
            String[] lineArr;
            matrix = new float[SIZE_MATRIX][SIZE_MATRIX];
            int i = 0;
            int j = 0;
            while ((line = br.readLine()) != null) {
                lineArr = line.split("\t");
                for (String num : lineArr) {
                    if (!NumberUtils.isCreatable(num)) {
                        break;
                    }
                    matrix[i][j] = Float.parseFloat(num);
                    j++;
                }
                i++;
                j = 0;
            }
        }
        return matrix;
    }
}
