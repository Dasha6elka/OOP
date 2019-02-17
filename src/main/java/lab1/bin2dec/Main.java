package lab1.bin2dec;

import java.io.IOException;

class Main {
    public static void main(String[] args) {
        try {
            if (args.length == 0) {
                throw new IllegalArgumentException("No number in arguments");
            }
            if (!Binary.verify(args[0])) {
                throw new IOException("Number not binary!");
            }
            var decimal = Binary.bin2dec(args[0]);
            System.out.println(decimal);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
