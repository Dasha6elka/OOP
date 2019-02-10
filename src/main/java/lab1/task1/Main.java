package lab1.task1;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        final Application application = new Application();
        FileManager input = new FileManager(args[0]);
        FileManager output = new FileManager(args[1]);
        try {
            application.copyfile(input.create(), output.create());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
