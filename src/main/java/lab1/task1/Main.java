package lab1.task1;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IOException("No arguments!");
        }
        if (args.length != 2) {
            throw new IOException("Wrong number of arguments!");
        }
        FileManager input = new FileManager(args[0]);
        FileManager output = new FileManager(args[1]);
        final Application application = new Application();
        try {
            application.copyfile(input.create(), output.create());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
