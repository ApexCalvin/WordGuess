package com.github.zipcodewilmington;


import java.util.Random;
import java.util.Scanner;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class Hangman {

    static Scanner scanObj = new Scanner(System.in);

    static double rand = Math.random();

    public static void main(String[] args) {

        boolean stillplaying = true;

        while (stillplaying) {

            String word2guess = selectLevel(); //create word to guess

            char charsOfWord[] = word2guess.toUpperCase().toCharArray(); //convert word string to word array of char

            int guessCount = word2guess.length(); //set number of guesses

            char[] savedGuess = new char[charsOfWord.length];

            System.out.println("\nGuess a letter, any letter! \nNumber of incorrect attempts left: " + guessCount);

            for (int i = 0; i < savedGuess.length; i++) {
                savedGuess[i] = '_';
                System.out.print(savedGuess[i] + " ");
            }

            boolean playAgain = false;

            while (guessCount > 0) {
                char letter = getGuess(); //get the letter from user
                if (isInWord(charsOfWord, letter)) { //check if it's in the word string
                    //System.out.println("\nYour letter is in the word!");
                    saveChar(charsOfWord, savedGuess, letter);
                    if (wordComplete(savedGuess)) {
                        System.out.println("\nCorrect! Congratulations!");
                        break;
                    }
                } else {
                    guessCount--;
                    System.out.println("Incorrect! Attempts left:  " + guessCount);
                }
            }
            System.out.println("\n[GAME OVER]");
            System.out.println("\n1. Yes" +
                                "\n2. No" +
                                "\nPlay again?");
            int answer = scanObj.nextInt();

            if(answer == 2) {
                stillplaying = false;
            }
        }
    }

    public static String selectLevel() {
        String level = "";
        System.out.print("\n1. Easy\n2. Hard\nEnter number to select level: ");
        int select = scanObj.nextInt();;

        if(select == 1) {
            level = getEasyWord();
        } else if (select == 2) {
            level = getHardWord();
        } else {
            System.out.println("Incorrect entry.");
        }
        return level;
    }

    public static String getHardWord() {

        Random rand = new Random();
        int num = rand.nextInt((5)) + 1;

        String[] hardWords = {"salamander", "coliseum", "uncensored", "abruptly", "espionage"};
        System.out.println(hardWords[num]);
        return hardWords[num];
    }

    public static String getEasyWord() {
        Random rand = new Random();
        int num = rand.nextInt((5)) + 1;

        String[] easyWords = {"eraser", "pillow", "lunch", "statue", "purple"};
        System.out.println(easyWords[num]);
        return easyWords[num];
    }

    public static char getGuess() {
        Scanner scanObj = new Scanner(System.in);
        System.out.print("\nEnter a single character: ");
        String guess = scanObj.next();
        char charsOfGuess[] = guess.toUpperCase().toCharArray();
        char letter = charsOfGuess[0];
        //System.out.println("Letter guessed is: " + letter);
        return letter;
    }

    public static boolean isInWord(char[] charsOfWord, char letter) {
        for(int i = 0 ; i < charsOfWord.length ; i++) {
            if (letter == charsOfWord[i]) {
                return true;
            }
        }
        return false;
    }

    public static void saveChar(char[] charsOfWord, char[] savedGuess, char letter) {

        for(int i = 0 ; i < charsOfWord.length ; i++) {
            if (letter == charsOfWord[i]) {
                //System.out.println("Letter is: " + letter + ", Letter in String is: " + charsOfWord[i]);
                savedGuess[i] = charsOfWord[i];
                //System.out.println("character in saved string: " + savedGuess[i]);
            }
        }

        displaySaved(savedGuess);
    }

    public static void displaySaved(char[] savedGuess) {
        for(int i = 0 ; i < savedGuess.length ; i++) {
            System.out.print(savedGuess[i] + " ");
        }
    }

    public static boolean wordComplete(char[] savedGuess) {
        for(int i = 0 ; i < savedGuess.length ; i++) {
            if(Character.valueOf(savedGuess[i]) == '_') {
                return false;
            }
        }
        return true;
    }
}
