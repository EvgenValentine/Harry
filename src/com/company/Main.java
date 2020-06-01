package com.company;

import  java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static String getLongestWord(String text){
        String[] wordArray = text.split(" ");
        String mostLongestWord = "";
        int maxLength = 0;
        for(int i = 0; i < wordArray.length; i++){
            wordArray[i] = wordArray[i]
                    .replaceAll("\\s\\W+","")
                    .replaceAll("\\W+\\s", "")
                    .toLowerCase();
            if (wordArray[i].length()> maxLength){
                mostLongestWord = wordArray[i];
                maxLength = wordArray[i].length();
            }
        }
        return mostLongestWord;
    }

    public static int numberOfEntriesInLines(String text, String word) {
        String[] stringArray = text.split("\\n");
        int numberStrings = 0;
        for(int i = 0; i < stringArray.length; i++){
            String[] wordArray = stringArray[i].split(" ");
            for (int j = 0; j < wordArray.length; j++) {
                wordArray[j] = wordArray[j]
                        .replaceAll("\\s\\W+","")
                        .replaceAll("\\W+\\s", "")
                        .toLowerCase();
                if (wordArray[j].equals(word)){
                    numberStrings++;
                    break;
                }
            }

        }
        return numberStrings;
    }

    public static String removeReiterations(String text){
        String[] wordArray = text.split(" ");
        String[] distWords = new String[wordArray.length];
        String stringWithDistWords  = " ";
        for(int i = 0; i < wordArray.length; i++){
            wordArray[i] = wordArray[i]
                    .replaceAll("\\s\\W+","")
                    .replaceAll("\\W+\\s", "")
                    .toLowerCase();

            if (!stringWithDistWords.contains(wordArray[i])){
                stringWithDistWords += wordArray[i] + " ";
            }
        }
        return stringWithDistWords;
    }

    public static int numberOfEntriesInText(String text, String word) {
        String[] wordArray = text.split(" ");
        int numberStrings = 0;
        for(int i = 0; i < wordArray.length; i++){
            wordArray[i] = wordArray[i]
                    .replaceAll("\\s\\W+","")
                    .replaceAll("\\W+\\s", "")
                    .toLowerCase();
            if (wordArray[i].equals(word)){
                numberStrings++;
            }
        }
        return numberStrings;
    }

    public static void main(String[] args)  throws IOException{
        String text = new String(Files.readAllBytes(Paths.
                get("F:\\Harry\\src\\com\\company\\harry.txt")));

        //First task
        System.out.println
                ("The longest word is " + getLongestWord(text));

        //Second task
        System.out.println
                (numberOfEntriesInLines(text, "harry"));

        //Third task
        String distWordsString = removeReiterations(text);
        String[] distWordsArray = distWordsString.split(" ");
        Integer[] hashArray = new Integer[distWordsArray.length];
        for (int i = 0; i < distWordsArray.length; i++) {
            hashArray[i] = distWordsArray[i].hashCode();
            System.out.println(distWordsArray[i] + " - " +hashArray[i]);
        }

        //Fourth task. We will use string with distinct words
        //from previous task
        for (int i = 0; i < distWordsArray.length; i++) {
            int numberOfEntries = numberOfEntriesInText(text, distWordsArray[i]);
            System.out.println
                    ("Word "+distWordsArray[i]+" entries "+numberOfEntries);
        }

    }
}
