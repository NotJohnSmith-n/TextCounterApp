package com.example.textcounterapp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextAnalyzer {

    public static int countSentences(String text) {
        if (text == null || text.trim().isEmpty()) return 0;

        String regex = "\\.+";

        String[] sentences = text.trim().split(regex);

        int count = 0;
        for (String sentence : sentences) {
            if (!sentence.trim().isEmpty()) {
                count++;
            }
        }
        return count;
    }

    public static int countNumbers(String text) {
        if (text == null || text.trim().isEmpty()) return 0;
        int count = 0;
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public static int countWords(String text) {
        if (text == null || text.trim().isEmpty()) return 0;

        String[] words = text.trim().split(" ");
        int count = 0;

        for (String word : words) {
            if (!word.isEmpty()) {
                count++;
            }
        }
        return count;
    }

    public static int countPunctuation(String text) {
        if (text == null) return 0;
        int count = 0;

        for (char symbol : text.toCharArray()) {
            if (symbol == '.' || symbol == ',' || symbol == ' ') {
                count++;
            }
        }
        return count;
    }
}