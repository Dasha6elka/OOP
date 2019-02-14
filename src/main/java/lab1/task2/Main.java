package lab1.task2;

import java.io.IOException;

public class Main {
    public static void main(String args[]){
        if (args.length == 0) {
            System.err.println("No number in arguments");
            return;
        }
        if (!Binary.verify(args[0])) {
            System.err.println("Number not binary!");
            return;
        }
        var decimal = Binary.bin2dec(args[0]);
        System.out.println( decimal);
    }
}
