package lab1.multmatrix;

import io.FileManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class MatrixTest {
    @Before
    public void setUp() throws Exception {
        final var manager = new FileManager("matrix.txt");
        manager.write("3\t4\t8\n2.4\t-1\t11\n7\t-3.2\t0");
    }

    @After
    public void tearDown() {
        final var file = new File("matrix.txt");
        file.delete();
    }

    @Test
    public void testToMatrixWorks() throws IOException {
        final var manager = new FileManager("matrix.txt");
        var matrix = Matrix.toMatrix(manager.getFileInstance(), 3);
        float[][] rightMatrix = {
            {3, 4, 8},
            {(float) 2.4, -1, 11},
            {7, (float) -3.2, 0}
        };
        Assert.assertArrayEquals(matrix, rightMatrix);
    }
}
