package lab1.task1;

import java.io.*;

public class Main {
    private static final int BUFFER_SIZE = 1024;
    private static final String INPUT = "input.txt";
    private static final String OUTPUT = "output.txt";

    public static void main(String[] args) {
        File input = new File(INPUT);
        File output = new File(OUTPUT);
        if (!input.exists()) {
            try {
                boolean isCreated = input.createNewFile();
                if (!isCreated) {
                    throw new IOException("Cannot create input file!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!output.exists()) {
            try {
                boolean isCreated = output.createNewFile();
                if (!isCreated) {
                    throw new IOException("Cannot created output file!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            copyfile(input, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyfile(File input, File output) throws IOException {
        InputStream inputFile = null;
        OutputStream outputFile = null;
        try {
            inputFile = new FileInputStream(input);
            outputFile = new FileOutputStream(output);
            byte[] buffer = new byte[BUFFER_SIZE];
            int len;
            while ((len = inputFile.read(buffer)) > 0) {
                outputFile.write(buffer, 0, len);
            }
        } finally {
            if (inputFile != null) {
                inputFile.close();
            }
            if (outputFile != null) {
                outputFile.close();
            }
        }
    }
}
