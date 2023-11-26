package com.proftelran.org.homework_10;

import java.util.Map;

public class CharacterCount {

    public static void main(String[] args) {

        String text = "Hello, World! Hallo, Leute!";
        Map<Character, Integer> charCountMap = countCharacters(text);
        displayCharacterCount(charCountMap);
        System.out.println(text);
    }

    public static Map<Character, Integer> countCharacters(String text) {
        // Создаем пустую карту для подсчета символов
        Map<Character, Integer> charCountMap = new java.util.HashMap<>();

        // Проходим по каждому символу в строке
        for (char c : text.toCharArray()) {
            // Обновляем счетчик в карте
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        return charCountMap;
    }

    public static void displayCharacterCount(Map<Character, Integer> charCountMap) {
        // Выводим результат в виде таблицы
        System.out.println("Character\tCount");
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + "\t\t" + entry.getValue());
        }
    }
}