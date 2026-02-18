package com.startjava.lesson_2_3_4.array;

public class TypewriterEffect {
    public static String[] findMinMaxWord(String text) {
        if (text == null || text.trim().isEmpty()) {
            return new String[]{"", ""};
        }

        String[] words = extractWords(text);

        if (words.length == 0) {
            return new String[]{"", ""};
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

        return new String[]{shortest, longest};
    }

    private static int[] findHighlightBounds(String[] words, String shortest, String longest) {
        int shortIdx = -1;
        int longIdx = -1;

        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase(shortest)) {
                shortIdx = i;
                break;
            }
        }

        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase(longest)) {
                longIdx = i;
                break;
            }
        }

        int start = Math.min(shortIdx, longIdx);
        int end = Math.max(shortIdx, longIdx);

        return new int[]{start, end};
    }

    private static void printCharWithDelay(char c) throws InterruptedException {
        System.out.print(c);
        Thread.sleep(50);
    }

    private static void printStringWithDelay(String str) throws InterruptedException {
        for (char ch : str.toCharArray()) {
            printCharWithDelay(ch);
        }
    }

    // Метод для преобразования слова в верхний регистр (демонстрационный)
    public static String toUpperCase(String word) {
        return word != null ? word.toUpperCase() : "";
    }

    private static void printTypewriterWithHighlight(String text) throws InterruptedException {
        if (text == null) {
            printStringWithDelay("null");
            return;
        }
        if (text.trim().isEmpty()) {
            return;
        }

        String[] words = extractWords(text);
        String[] minMax = findMinMaxWord(text);

        int[] bounds = findHighlightBounds(words, minMax[0], minMax[1]);
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
                    String currentWordStr = currentWord.toString();
                    if (wordIndex >= start && wordIndex <= end) {
                        // Явно используем метод toUpperCase для выделения
                        printStringWithDelay(toUpperCase(currentWordStr));
                    } else {
                        printStringWithDelay(currentWordStr);
                    }
                    currentWord = new StringBuilder();
                    wordIndex++;
                }
                printCharWithDelay(c);
            }
        }

        if (!currentWord.isEmpty()) {
            String currentWordStr = currentWord.toString();
            if (wordIndex >= start && wordIndex <= end) {
                printStringWithDelay(toUpperCase(currentWordStr));
            } else {
                printStringWithDelay(currentWordStr);
            }
        }
    }

    private static String[] extractWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return new String[0];
        }

        String cleaned = text.replaceAll("[.,!?:;\"'()\\[\\]{}<>-]", " ");
        String[] parts = cleaned.split("\\s+");

        int wordCount = 0;
        for (String part : parts) {
            if (!part.isEmpty()) {
                wordCount++;
            }
        }

        String[] words = new String[wordCount];
        int index = 0;
        for (String part : parts) {
            if (!part.isEmpty()) {
                words[index++] = part;
            }
        }

        return words;
    }

    public static void main(String[] args) throws InterruptedException {
        String text1 = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки.";
        String text2 = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его.";
        String text3 = null;
        String text4 = "";

        findMinMaxWord(text1);
        printTypewriterWithHighlight(text1);
        System.out.println("\n");

        findMinMaxWord(text2);
        printTypewriterWithHighlight(text2);
        System.out.println("\n");

        findMinMaxWord(text3);
        printTypewriterWithHighlight(text3);
        System.out.println("\n");

        findMinMaxWord(text4);
        printTypewriterWithHighlight(text4);
        System.out.println();
    }
    }