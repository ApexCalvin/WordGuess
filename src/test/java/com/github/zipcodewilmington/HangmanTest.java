package com.github.zipcodewilmington;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class HangmanTest {

    @Test
    public void isInWordTest() {
        char[] word = {'c', 'a', 't'} ;
        char letter = 'a';
        Assert.assertTrue(Hangman.isInWord(word, letter));
    }

    @Test
    public void isInWordTest2() {
        char[] word = {'c', 'a', 't'} ;
        char letter = 's';
        Assert.assertFalse(Hangman.isInWord(word, letter));
    }

    @Test
    public void wordCompleteTest() {
        char[] word = {'_', 'a', 't'} ;
        Assert.assertFalse(Hangman.wordComplete(word));
    }

    @Test
    public void wordCompleteTest2() {
        char[] word = {'c', 'a', 't'} ;
        Assert.assertTrue(Hangman.wordComplete(word));
    }

//      starts the game
//      a random word is chosen from a list
//      the number of tries allowed is set to the length of the word
//      setup the two (the solution and the player's guesses) character arrays
//      WHILE the numbers of tries is less than tries allowed AND
//      the player has not guessed the word
//      print the current state of the player's guesses
//      ask the player for a letter (a character)
//      if the letter is a minus "-", quit the game
//      else process the letter
//      if the letter makes the work complete,
//      the player wins
//      after the while loop
//      if the word is not guessed, player loses
//      Now, another twist to the game is to add an "outer loop" which asks the player if they would like to play again. This outer loop would surround the logic in the outline above.
//
//      But for v1, just create the game to play a single word each time it is run. Once you have that running, add the outer loop. Call it v2.


}
