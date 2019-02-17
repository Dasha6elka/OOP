package io;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class FileManager {
    private final File file;

    public FileManager(String pathToFile) {
        this.file = new File(pathToFile);
    }

    public File getFileInstance() throws IOException {
        if (!file.exists()) {
            boolean isCreated = file.createNewFile();
            if (!isCreated) {
                throw new IOException("Cannot getFileInstance input file!");
            }
        }
        return file;
    }

    public void write(String string) throws IOException {
        List<String> lines = Collections.singletonList(string);
        Path path = Path.of(file.getAbsolutePath());
        Files.write(path, lines, Charset.forName("UTF-8"));
    }

    public String read() throws IOException {
        Path path = Path.of(file.getAbsolutePath());
        return Files.readString(path);
    }
}
