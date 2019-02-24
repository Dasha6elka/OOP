package lab2.map;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("dictionary.txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            Map<String, List<String>> dictionary;
            try (Scanner s = new Scanner(file)) {
                dictionary = new LinkedHashMap<>();
                while (s.hasNext()) {
                    String key = s.next();
                    if (!dictionary.containsKey(key))
                        dictionary.put(key, new LinkedList<>());
                    dictionary.get(key).add(s.next());
                }
            }
            int sizeStartingDict = dictionary.size();
            boolean exit = false;
            while (!exit) {
                Scanner input = new Scanner(System.in);
                String in = input.nextLine();
                if (in.isEmpty()) {
                    System.out.println("Пусто. введите заново.");
                } else if (Objects.equals(in, "...")) {
                    exit = true;
                    int sizeEndingDict = dictionary.size();
                    if (sizeEndingDict > sizeStartingDict) {
                        System.out.println("В словарь были внесены изменения. Введите Y или y для сохранения перед выходом.");
                        Scanner inputY = new Scanner(System.in);
                        String inY = inputY.nextLine();
                        if (Objects.equals(inY, "Y") || Objects.equals(inY, "y")) {
                            file.delete();
                            try (FileWriter writer = new FileWriter(file)) {
                                dictionary.forEach((key, strings) -> {
                                    try {
                                        for (String string : strings) {
                                            writer.write(key);
                                            writer.write("\t");
                                            writer.write(string);
                                            writer.write("\n");
                                        }
                                    } catch (IOException e) {
                                        System.err.println(e.getMessage());
                                    }
                                });
                                writer.flush();
                            }
                            System.out.println("Изменения сохранены. До свидания.");
                        }
                    } else {
                        System.out.println("В словарь не было ничего добавлено нового");
                    }
                } else if (dictionary.keySet().contains(in)) {
                    System.out.println(dictionary.get(in));
                } else {
                    System.out.println("Неизвестое слово \"" + in + "\". Введите перевод или пустую строку для отказа.");
                    Scanner inputNewWord = new Scanner(System.in);
                    String newWord = inputNewWord.nextLine();
                    if (!newWord.isEmpty()) {
                        dictionary.containsKey(in);
                        dictionary.put(in, new LinkedList<>());
                        dictionary.get(in).add(newWord);
                        System.out.println("Слово \""+ in + "\" сохранено в словаре как \"" + newWord + "\".");
                    } else {
                        System.out.println("Слово \"" + in + "\" проигнорировано.");
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
