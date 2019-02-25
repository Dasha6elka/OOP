package lab2.mini_dictionary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Main {
    private static File createFile(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            boolean isCreate =  file.createNewFile();
            if (!isCreate) {
                System.out.println("Файл не создан");
            }
        }
        return file;
    }
    
    private static Map<String, List<String>> initializationDict(File file) {
        Map<String, List<String>> dictionary = new LinkedHashMap<>();
        try (Scanner s = new Scanner(file)) {
            while (s.hasNext()) {
                String key = s.next();
                if (!dictionary.containsKey(key))
                    dictionary.put(key, new LinkedList<>());
                dictionary.get(key).add(s.next());
            }
            return dictionary;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return dictionary;
    }

    private static void unknownWord(String in, Map<String, List<String>> dictionary) {
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

    private static void saveDict(File file, Map<String, List<String>> dictionary) {
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
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Изменения сохранены. До свидания.");
    }

    private static void dialogueWithUser(File file, Map<String, List<String>> dictionary, int sizeStartingDict) {
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
                        Main.saveDict(file, dictionary);
                    }
                } else {
                    System.out.println("В словарь не было ничего добавлено нового");
                }
            } else if (dictionary.keySet().contains(in)) {
                System.out.println(dictionary.get(in));
            } else {
                Main.unknownWord(in, dictionary);
            }
        }
    }

    public static void main(String[] args) {
        try {
            File file = Main.createFile(args[0]);
            Map<String, List<String>> dictionary = Main.initializationDict(file);
            int sizeStartingDict = dictionary.size();
            Main.dialogueWithUser(file, dictionary, sizeStartingDict);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
