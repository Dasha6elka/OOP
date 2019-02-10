package lab1.task1;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class ApplicationTest {

    @Before
    public void setUp() {
        final File input = new File("input.txt");
        final File output = new File("output.txt");
        input.delete();
        output.delete();
    }

    @After
    public void tearDown() {
        final File input = new File("input.txt");
        final File output = new File("output.txt");
        input.delete();
        output.delete();
    }

    @Test
    public void testThrowErrorIfFilesNotExist() {
        final File input = new File("input.txt");
        final File output = new File("output.txt");
        Assert.assertFalse(input.exists());
        Assert.assertFalse(output.exists());
        final Application application = new Application();
        Assert.assertThrows(IOException.class, () -> application.copyfile(input, output));
    }

    @Test
    public void testFilesContentEqual() throws IOException {
        final Application application = new Application();
        FileManager input = new FileManager("input.txt");
        FileManager output = new FileManager("output.txt");
        input.write("Hello, World!");
        application.copyfile(input.create(), output.create());
        Assert.assertEquals(output.read().strip(), "Hello, World!");
    }
}
