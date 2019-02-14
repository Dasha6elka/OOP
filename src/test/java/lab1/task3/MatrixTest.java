package lab1.task3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MatrixTest {
    private float[][] inputMatrix;
    private float[][] outputMatrix;

    public  MatrixTest(float[][] inputMatrix, float[][] outputMatrix) {
        this.inputMatrix = inputMatrix;
        this.outputMatrix = outputMatrix;
    }

//    @Parameterized.Parameters
//    public static Collection<Object[]> data() {
//        return Arrays.asList(new Object[][][][][][][][][]{
//            {"1 1 1", "1 1 1", "1 1 1", "2 3 4", "5 6 7", "8 9 10", "2 3 4", "5 6 7", "8 9 10"}
//        });
//    }

    @Test
    public void toMatrix() {
    }
}
