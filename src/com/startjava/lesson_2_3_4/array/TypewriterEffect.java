package com.startjava.lesson_2_3_4.array;

public class TypewriterEffect {
    public static void main(String[] args) {
        String text1 = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки. " +
                "- James Gosling";
        String[] words1 = findShortestLongestWords(text1);

        if (words1 != null) {
            toUpperCase(words1[1]);
            toUpperCase(words1[2]);
        }

        printTypewriterWithHighlight(text1, words1);

        String text2 = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его. " +
                "- Robert Martin";
        String[] words2 = findShortestLongestWords(text2);

        if (words2 != null) {
            toUpperCase(words2[1]);
            toUpperCase(words2[2]);
        }

        printTypewriterWithHighlight(text2, words2);

        String[] words3 = findShortestLongestWords(null);
        if (words3 != null) {
            toUpperCase(words3[1]);
            toUpperCase(words3[2]);
        }
        printTypewriterWithHighlight(null, words3);

        String[] words4 = findShortestLongestWords("");
        if (words4 != null) {
            toUpperCase(words4[1]);
            toUpperCase(words4[2]);
        }
        printTypewriterWithHighlight("", words4);
    }

    public static String[] findShortestLongestWords(String text) {
        if (text == null || text.isBlank()) {
            return null;
        }

        String[] words = extractWords(text);

        if (words.length == 0) {
            return null;
        }

        String shortest = words[0];
        String longest = words[0];

        for (int i = 1; i < words.length; i++) {
            if (words[i].length() < shortest.length()) {
                shortest = words[i];
            }
            if (words[i].length() > longest.length()) {
                longest = words[i];
            }
        }

        return new String[]{String.join(" ", words), shortest, longest};
    }

    public static String toUpperCase(String word) {
        if (word == null || word.isEmpty()) {
            return "";
        }

        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (c >= 'a' && c <= 'z') {
                chars[i] = (char) (c - 32);
            } else if (c >= 'а' && c <= 'я') {
                chars[i] = (char) (c - 32);
            } else if (c == 'ё') {
                chars[i] = 'Ё';
            }
        }
        return new String(chars);
    }

    private static String[] extractWords(String text) {
        if (text == null || text.isBlank()) {
            return new String[0];
        }

        String cleaned = text.replaceAll("[.,!?:;\"'()\\[\\]{}<>-]", " ");
        return cleaned.split("\\s+");
    }

    private static void printTypewriterWithHighlight(String text, String[] words) {
        if (text == null || text.isBlank() || words == null) {
            return;
        }

        String[] allWords = extractWords(text);
        int[] bounds = findHighlightBounds(allWords, words[1], words[2]);
        int start = bounds[0];
        int end = bounds[1];

        StringBuilder currentWord = new StringBuilder();
        int wordIndex = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                currentWord.append(c);
            } else {
                if (!currentWord.isEmpty()) {
                    if (wordIndex >= start && wordIndex <= end) {
                        printStringWithDelay(toUpperCase(currentWord.toString()));
                    } else {
                        printStringWithDelay(currentWord.toString());
                    }
                    currentWord = new StringBuilder();
                    wordIndex++;
                }
                printCharWithDelay(c);
            }
        }

        if (!currentWord.isEmpty()) {
            if (wordIndex >= start && wordIndex <= end) {
                printStringWithDelay(toUpperCase(currentWord.toString()));
            } else {
                printStringWithDelay(currentWord.toString());
            }
        }
        System.out.println("\n");
    }

    private static int[] findHighlightBounds(String[] words, String shortest, String longest) {
        int shortestIdx = -1;
        int longestIdx = -1;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase(shortest) && shortestIdx == -1) {
                shortestIdx = i;
            }
            if (words[i].equalsIgnoreCase(longest) && longestIdx == -1) {
                longestIdx = i;
            }

            if (shortestIdx != -1 && longestIdx != -1) {
                break;
            }
        }

        int start = Math.min(shortestIdx, longestIdx);
        int end = Math.max(shortestIdx, longestIdx);

        return new int[]{start, end};
    }

    private static void printCharWithDelay(char c) {
        System.out.print(c);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private static void printStringWithDelay(String str) {
        if (str != null) {
            for (char ch : str.toCharArray()) {
                printCharWithDelay(ch);
            }
        }
    }
}