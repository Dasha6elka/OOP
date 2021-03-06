package lab1.copyfile;

import io.FileManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileManagerTest {
    @Before
    public void setUp() {
        final File file = new File("test.txt");
        file.delete();
    }

    @Test
    public void testFileCreates() throws IOException {
        final File file = new File("test.txt");
        Assert.assertFalse(file.exists());
        FileManager manager = new FileManager("test.txt");
        Assert.assertFalse(file.exists());
        manager.getFileInstance();
        Assert.assertTrue(file.exists());
    }

    @Test
    public void testWriteReadWorks() throws IOException {
        FileManager manager = new FileManager("test.txt");
        manager.getFileInstance();
        manager.write("Hello, World!");
        String actual = manager.read();
        Assert.assertEquals("Hello, World!", actual.strip());
    }
}
