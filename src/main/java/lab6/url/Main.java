package lab6.url;

import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] argc) {
        try {
            String line;
            FileReader input = new FileReader("inputUrl.txt");
            Scanner scanner = new Scanner(input);
            while (scanner.hasNextLine()) {
                try {
                    line = scanner.nextLine();
                    HttpUrl.httpUrl(line);
                    if (HttpUrl.protocol != null && !HttpUrl.domain.equals("")) {
                        System.out.println("URL: " + HttpUrl.getUrl());
                        System.out.println("Protocol: " + HttpUrl.getProtocol());
                        System.out.println("Domain: " + HttpUrl.getDomain());
                    }
                    if (HttpUrl.port != -1 && HttpUrl.port != 0) {
                        System.out.println("Port: " + HttpUrl.getPort());
                    }
                    if (HttpUrl.document != null && !HttpUrl.document.equals("")) {
                        System.out.println("Document: " + HttpUrl.getDocument());
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println();
                }
                System.out.println();
                HttpUrl.protocol = null;
                HttpUrl.domain = null;
                HttpUrl.port = 0;
                HttpUrl.document = null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
    }
}

