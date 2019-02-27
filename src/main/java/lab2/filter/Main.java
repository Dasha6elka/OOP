package lab2.filter;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static Set<String> readUncensored(Scanner input) {
        String s;
        Set<String> uncensored = new HashSet<>();
        while (input.hasNext()) {
            s = input.next();
            uncensored.add(s);
        }
        return uncensored;
    }

    public static Set<String> readConsole(Scanner console) {
        Set<String> mesageWords = new HashSet<>();
        String current;
        console.useDelimiter("\n\t\\s,.?!;:+-=*/%");
        console.useDelimiter("()");
        console.useDelimiter("^");
        while (console.hasNextLine()) {
            current = console.nextLine();
            mesageWords.add(current);
        }
        return mesageWords;
    }

    public static Set<String> deleteUncensoredWords(Set<String> uncensored, Set<String> console) {
        for (String con: console) {
            for (String un: uncensored) {
                if (con.equals(un)) {
                    console.remove(con);
                }
            }
        }
        return console;
    }

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new File(args[0]));
            Set<String> uncensored = Main.readUncensored(input);
            System.out.println("Введите сообщение:");
            Scanner message = new Scanner(System.in);
            Set<String> console = Main.readConsole(message);
            Set<String> filteredMessage = Main.deleteUncensoredWords(uncensored, console);
            for (String mes: filteredMessage) {
                System.out.print(mes);
                System.out.print(" ");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
