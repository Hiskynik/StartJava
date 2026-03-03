package com.startjava.lesson_2_3_4.array;

public class TypewriterEffect {
    public static void main(String[] args) {
        String inputText1 = "Java - это C++, из которого убрали все пистолеты, ножи и дубинки. " +
                "- James Gosling";
        String[] words1 = findShortestLongestWords(inputText1);
        if (words1 != null) {
            String result1 = convertRangeToUpperCase(inputText1, words1[0], words1[1]);
            printWithDelay(result1);
        } else {
            printWithDelay("Входной текст отсутствует или пуст");
        }

        String inputText2 = "Чтобы написать чистый код, мы сначала пишем грязный код, затем рефакторим его." +
                " - Robert Martin";
        String[] words2 = findShortestLongestWords(inputText2);
        if (words2 != null) {
            String result2 = convertRangeToUpperCase(inputText2, words2[0], words2[1]);
            printWithDelay(result2);
        } else {
            printWithDelay("Входной текст отсутствует или пуст");
        }

        String inputText3 = null;
        String[] words3 = findShortestLongestWords(inputText3);
        if (words3 != null) {
            String result3 = convertRangeToUpperCase(inputText3, words3[0], words3[1]);
            printWithDelay(result3);
        } else {
            printWithDelay("Входной текст отсутствует");
        }

        String inputText4 = "";
        String[] words4 = findShortestLongestWords(inputText4);
        if (words4 != null) {
            String result4 = convertRangeToUpperCase(inputText4, words4[0], words4[1]);
            printWithDelay(result4);
        } else {
            printWithDelay("Входной текст пуст");
        }
    }

    public static String[] findShortestLongestWords(String inputText) {
        if (inputText == null || inputText.isBlank()) {
            return null;
        }

        String[] words = extractWords(inputText);

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

        return new String[]{shortest, longest};
    }

    private static String[] extractWords(String inputText) {
        if (inputText == null || inputText.isBlank()) {
            return new String[0];
        }

        String cleaned = inputText.replaceAll("[.,!?:;\"'()\\[\\]{}<>-]", " ");
        return cleaned.split("\\s+");
    }

    public static String convertRangeToUpperCase(String inputText, String shortest, String longest) {
        if (inputText == null || inputText.isBlank() || shortest == null || longest == null) {
            return "";
        }

        String[] allWords = extractWords(inputText);
        int[] bounds = findWordIndices(allWords, shortest, longest);
        int start = bounds[0];
        int end = bounds[1];

        StringBuilder result = new StringBuilder();
        StringBuilder currentWord = new StringBuilder();
        int wordIndex = 0;

        for (int i = 0; i < inputText.length(); i++) {
            char c = inputText.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                currentWord.append(c);
            } else {
                if (!currentWord.isEmpty()) {
                    if (wordIndex >= start && wordIndex <= end) {
                        result.append(currentWord.toString().toUpperCase());
                    } else {
                        result.append(currentWord);
                    }
                    currentWord = new StringBuilder();
                    wordIndex++;
                }
                result.append(c);
            }
        }

        if (!currentWord.isEmpty()) {
            if (wordIndex >= start && wordIndex <= end) {
                result.append(currentWord.toString().toUpperCase());
            } else {
                result.append(currentWord);
            }
        }

        return result.toString();
    }

    private static int[] findWordIndices(String[] words, String shortest, String longest) {
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

    private static void printWithDelay(String inputText) {
        if (inputText == null || inputText.isBlank()) {
            return;
        }

        for (char c : inputText.toCharArray()) {
            printCharWithDelay(c);
        }
        System.out.println("\n");
    }

    private static void printCharWithDelay(char c) {
        System.out.print(c);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}