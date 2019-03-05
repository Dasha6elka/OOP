package lab2.mini_dictionary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static File createFile(String path) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            boolean isCreate = file.createNewFile();
            if (!isCreate) {
                System.out.println("Файл не создан");
            }
        }
        return file;
    }

    public static Map<String, List<String>> initializationDict(File file) {
        Map<String, List<String>> dictionary = new LinkedHashMap<>();
        try (Scanner s = new Scanner(file)) {
            while (s.hasNext()) {
                String key = s.next();
                String item = s.next();
                if (!dictionary.containsKey(key))
                    dictionary.put(key, new LinkedList<>());
                dictionary.get(key).add(item);
            }
            return dictionary;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return dictionary;
    }

    public static Map<String, List<String>> initializedDdict(Map<String, List<String>> dictionary, Map<String, List<String>> ddictionary) {
        dictionary.forEach((key, items) -> {
            for (String item : items) {
                if (!ddictionary.containsKey(key))
                    ddictionary.put(key, new LinkedList<>());
                if (!ddictionary.containsKey(item))
                    ddictionary.put(item, new LinkedList<>());
                ddictionary.get(key).add(item);
                ddictionary.get(item).add(key);
            }
        });
        return ddictionary;
    }

    public static Map<String, List<String>> unknownWord(String in, Map<String, List<String>> dictionary, Map<String, List<String>> ddictionary, String newWord) {
        if (!newWord.isEmpty()) {
            if (!dictionary.containsKey(in))
                dictionary.put(in, new LinkedList<>());
            dictionary.get(in).add(newWord);
            if (!ddictionary.containsKey(in))
                ddictionary.put(in, new LinkedList<>());
            ddictionary.get(in).add(newWord);
            if (!ddictionary.containsKey(newWord))
                ddictionary.put(newWord, new LinkedList<>());
            ddictionary.get(newWord).add(in);
            System.out.println("Слово \"" + in + "\" сохранено в словаре как \"" + newWord + "\".");
        } else {
            System.out.println("Слово \"" + in + "\" проигнорировано.");
        }
        return dictionary;
    }

    public static void saveDict(File file, Map<String, List<String>> dictionary) {
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

    private static void dialogueWithUser(File file, Map<String, List<String>> dictionary, Map<String, List<String>> ddictionary, int sizeStartingDict) {
        boolean exit = false;
        while (!exit) {
            Scanner input = new Scanner(System.in);
            String in = input.nextLine().toLowerCase();
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
            } else {
                var ref = new Object() {
                    boolean isNew = false;
                };
                ddictionary.forEach((key, items) -> {
                    if (key.toLowerCase().equals(in)) {
                        var values = ddictionary.get(key);
                        int size = values.size();
                        for (int i = 0; i < size; i++) {
                            System.out.print(values.get(i));
                            if (i < size - 1) {
                                System.out.print(", ");
                            }
                        }
                        System.out.println();
                        ref.isNew = true;
                    }
                });
                if (!ref.isNew) {
                    System.out.println("Неизвестое слово \"" + in + "\". Введите перевод или пустую строку для отказа.");
                    Scanner inputNewWord = new Scanner(System.in);
                    String newWord = inputNewWord.nextLine();
                    Main.unknownWord(in, dictionary, ddictionary, newWord);
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            File file = Main.createFile(args[0]);
            Map<String, List<String>> dictionary = Main.initializationDict(file);
            Map<String, List<String>> ddictionary = new HashMap<>();
            Main.initializedDdict(dictionary, ddictionary);
            int sizeStartingDict = dictionary.size();
            Main.dialogueWithUser(file, dictionary, ddictionary, sizeStartingDict);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
