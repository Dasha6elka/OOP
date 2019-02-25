package lab2.decode;

import java.util.Scanner;

public class Main {
    public static String HtmlDecode(final String text) {
        return text.replaceAll("&amp;", "&")
            .replaceAll("&quot;", "\'")
            .replaceAll("&apos;", "\'")
            .replaceAll("&lt;", "<")
            .replaceAll("&gt;", ">");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input:");
        String htmlString = input.nextLine();
        String out = Main.HtmlDecode(htmlString);
        System.out.println(out);
    }
}
