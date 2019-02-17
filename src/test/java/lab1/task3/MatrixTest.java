package lab1.task3;

import io.FileManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class MatrixTest {

    @Before
    public void setUp() throws Exception {
        final var manager = new FileManager("matrix.txt");
        manager.write("1\t2\t3\n4\t5\t6\n7\t8\t9");
    }

    @After
    public void tearDown() {
        final var file = new File("matrix.txt");
        file.delete();
    }

    @Test
    public void toMatrix() {
    }
}
