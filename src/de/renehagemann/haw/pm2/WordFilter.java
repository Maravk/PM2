package de.renehagemann.haw.pm2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class WordFilter {
    /**
     * Reads a file as a stream and filters it based on the given predicate
     * @param filename The file to use
     * @param predicate The predicate to filter with
     * @return  A list of the filtered lines from the file
     */
    public List<String> filter(String filename, Predicate<? super String> predicate){
        List<String> filtered = new ArrayList<>();
        try (Stream<String> words = Files.lines(Paths.get(filename))){
            words.filter(predicate).forEach(filtered::add);
        }catch (IOException e){
            e.printStackTrace();
        }
        return filtered;
    }

    /**
     * Checks the file content for palindromes
     * @param filename The file to check
     * @return A list of palindromes found in the file
     */
    public List<String> palidrome (String filename){
        Predicate<String> length = w -> (w.length() == 6);
        Predicate<String> palin = w -> (w.equals(new StringBuilder(w).reverse().toString()));

        return filter(filename, length.and(palin));
    }

    /**
     * Checks the file for words with an e at the second fourth and sixth position
     * @param filename The file to check
     * @return A list of all words which fulfil the condition of the e's
     */
    public List<String> letterPosition (String filename){
        Predicate<String> length = w -> (w.length() >= 6);
        Predicate<String> position2 = w -> (w.charAt(1) == 'e');
        Predicate<String> position4 = w -> (w.charAt(3) == 'e');
        Predicate<String> position6 = w -> (w.charAt(5) == 'e');

        return filter(filename, length.and(position2).and(position4).and(position6));
    }

    /**
     * Checks the file for words with double vocales
     * @param filename The file to check
     * @return A list of all words with double vocales in them
     */
    public List<String> vocalePair (String filename){
        Predicate<String> aa = w -> (w.contains("aa"));
        Predicate<String> ee = w -> (w.contains("ee"));
        Predicate<String> ii = w -> (w.contains("ii"));
        Predicate<String> oo = w -> (w.contains("oo"));
        Predicate<String> uu = w -> (w.contains("uu"));

        return filter(filename, aa.or(ee).or(ii).or(oo).or(uu));
    }

    /**
     * Checks if a word is in two files
     * @param filename1 The first file
     * @param filename2 The second file
     * @return A list of all words which are in both files
     */
    public List<String> duplicates (String filename1, String filename2){
        List<String> words1 = filter(filename1, w -> true);
        return filter(filename2, words1::contains);
    }
}
