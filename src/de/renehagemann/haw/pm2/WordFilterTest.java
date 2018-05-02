package de.renehagemann.haw.pm2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import static org.junit.jupiter.api.Assertions.*;

class WordFilterTest {

    @Test
    void filter() {
        Predicate<String> firstLetter = w -> (w.charAt(0) == 't' && w.charAt(1) == 'h' && w.charAt(2) == 'e');
        List<String> words = new WordFilter().filter("sgb-words.txt", firstLetter);
        List<String> filtered = Arrays.asList("there", "their", "these", "theme", "theft", "theta", "thews", "thees", "therm", "thens");

        assertEquals(filtered, words);
    }

    @Test
    void palidrome() {
        List<String> words = new WordFilter().palidrome("scrabble.txt");

        System.out.println("Palindromes:");
        for (String word:words
                ) {
            System.out.println("   " + word);
        }
    }

    @Test
    void letterPosition() {
        List<String> words = new WordFilter().letterPosition("scrabble.txt");

        System.out.println("Words with letter e in certain positions:");
        for (String word:words
                ) {
            System.out.println("   " + word);
        }
    }

    @Test
    void vocalePair() {
        List<String> words = new WordFilter().vocalePair("scrabble.txt");

        System.out.println("Words with vocale pairs:");
        for (String word:words
                ) {
            System.out.println("   " + word);
        }
    }

    @Test
    void duplicates() {
        List<String> words = new WordFilter().duplicates("sgb-words.txt", "scrabble.txt");

        System.out.println("Words in both files:");
        for (String word:words
                ) {
            System.out.println("   " + word);
        }
    }
}