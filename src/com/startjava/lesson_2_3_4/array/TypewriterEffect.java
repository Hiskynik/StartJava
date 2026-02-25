package com.startjava.lesson_2_3_4.array;

public class TypewriterEffect {
    public static void main(String[] args) {
        String text1 = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.";
        WordMetrics wordMetrics1 = findShortestLongestWords(text1);
        if (wordMetrics1 != null) {
            toUpperCase(wordMetrics1.shortest);
            toUpperCase(wordMetrics1.longest);
        }
        printQuoteWithAuthor(text1, wordMetrics1, "- James Gosling");

        String text2 = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.";
        WordMetrics wordMetrics2 = findShortestLongestWords(text2);
        if (wordMetrics2 != null) {
            toUpperCase(wordMetrics2.shortest);
            toUpperCase(wordMetrics2.longest);
        }
        printQuoteWithAuthor(text2, wordMetrics2, "- Robert Martin");

        WordMetrics wordMetrics3 = findShortestLongestWords(null);
        if (wordMetrics3 != null) {
            toUpperCase(wordMetrics3.shortest);
            toUpperCase(wordMetrics3.longest);
        }
        printQuoteWithAuthor(null, wordMetrics3, null);

        WordMetrics wordMetrics4 = findShortestLongestWords("");
        if (wordMetrics4 != null) {
            toUpperCase(wordMetrics4.shortest);
            toUpperCase(wordMetrics4.longest);
        }
        printQuoteWithAuthor("", wordMetrics4, null);
    }

    public static class WordMetrics {
        public String[] words;
        public String shortest;
        public String longest;

        public WordMetrics(String[] words, String shortest, String longest) {
            this.words = words;
            this.shortest = shortest;
            this.longest = longest;
        }
    }

    public static WordMetrics findShortestLongestWords(String text) {
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

        return new WordMetrics(words, shortest, longest);
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

    private static void printQuoteWithAuthor(String text, WordMetrics metrics, String author) {
        if (text == null || text.isBlank() || metrics == null) {
            return;
        }

        printTypewriterWithHighlight(text, metrics);
        if (author != null) {
            System.out.println();
            printStringWithDelay(author);
        }
        System.out.println("\n");
    }

    private static String[] extractWords(String text) {
        if (text == null || text.isBlank()) {
            return new String[0];
        }

        String cleaned = text.replaceAll("[.,!?:;\"'()\\[\\]{}<>-]", " ");
        return cleaned.split("\\s+");
    }

    // Метод для поиска границ выделения
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

    private static void printTypewriterWithHighlight(String text, WordMetrics metrics) {
        if (text == null || text.isBlank() || metrics == null || metrics.words.length == 0) {
            return;
        }

        int[] bounds = findHighlightBounds(metrics.words, metrics.shortest, metrics.longest);
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
                    printWordWithHighlight(currentWord.toString(), wordIndex, start, end);
                    currentWord = new StringBuilder();
                    wordIndex++;
                }
                printCharWithDelay(c);
            }
        }

        if (!currentWord.isEmpty()) {
            printWordWithHighlight(currentWord.toString(), wordIndex, start, end);
        }
    }

    private static void printWordWithHighlight(String word, int wordIndex, int start, int end) {
        if (wordIndex >= start && wordIndex <= end) {
            printStringWithDelay(toUpperCase(word));
        } else {
            printStringWithDelay(word);
        }
    }
}