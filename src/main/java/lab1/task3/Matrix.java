package lab1.task3;

import org.apache.commons.lang3.math.NumberUtils;

import java.io.*;

class Matrix {
    private Matrix() {
    }

    static float[][] toMatrix(File input1, int SIZE) throws IOException {
        InputStream input = new FileInputStream(input1);
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String line;
        String[] lineArr;
        float[][] matrix = new float[SIZE][SIZE];
        int i = 0;
        int j = 0;
        while ((line = br.readLine()) != null) {
            lineArr = line.split(" ");
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
        return matrix;
    }
}
