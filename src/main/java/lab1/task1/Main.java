package lab1.task1;

import io.FileManager;

class Main {
    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                throw new IllegalArgumentException("No arguments!");
            }
            if (args.length != 2) {
                throw new IllegalArgumentException("Wrong number of arguments!");
            }
            FileManager input = new FileManager(args[0]);
            FileManager output = new FileManager(args[1]);
            final Application application = new Application();
            application.copyfile(input.getFileInstance(), output.getFileInstance());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
