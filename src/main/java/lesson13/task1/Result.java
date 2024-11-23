package lesson13.task1;

import java.util.*;

public class Result {

    public static void main(String[] args) {
        String[] words = {"Максим", "Влад", "Анна", "Лидия", "Максим", "Лидия", "Влад", "Антон", "Паша"};

        System.out.println("\nПервоначальный массив: " + Arrays.toString(words));

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        System.out.println("\nУникальные слова:");
        for (String word : uniqueWords) {
            System.out.println(word);
        }

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : uniqueWords) {
            int count = 0;
            for (String w : words) {
                if (word.equals(w)) {
                    count++;
                }
            }
            wordCount.put(word, count);
        }

        System.out.println("\nКоличество повторений:");
        for (Map.Entry<String, Integer> wordEntry : wordCount.entrySet()) {
            String key = wordEntry.getKey();
            int value = wordEntry.getValue();
            System.out.printf("%s : %d\n", key, value);
        }
    }
}