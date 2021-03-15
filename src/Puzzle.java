// import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class Puzzle
{
    private String word;
    private int[] guessed;
    private char[] wordChars;
    private boolean[] guessedChars;


    Puzzle() {
        word = pickWord();
        guessed = new int[26];
        wordChars = word.toCharArray();
        guessedChars = new boolean[word.length()];
    }

    private String pickWord() {
        ArrayList<String> words = new ArrayList<>();
        try {
            File file = new File("words.txt");
            Scanner scn = new Scanner(file);

            while (scn.hasNext()) {
                String temp = scn.next().toLowerCase();
                words.add(temp);
            }
            scn.close();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
        int i = (int)(Math.random() * words.size());
        return words.get(i);
    }

    boolean isUnsolved() {
        for (boolean solved : guessedChars) {
            if (!solved) return true;
        }
        return false;
    }

    void show() {
        System.out.print("Puzzle: ");
        for (int i = 0; i < wordChars.length; i++) {
            if (guessedChars[i]) {
                System.out.print(wordChars[i]+" ");
            }
            else {
                System.out.print("__ ");
            }
        }
        System.out.println();
        System.out.print("Guesses: ");
        for (int i = 0; i < guessed.length; i++) {
            if (guessed[i] > 0) {
                System.out.print((char)(i+'a')+", ");
            }
        }
    }

    boolean makeGuess(String s) {
        if (s.equals(word)) {
            Arrays.fill(guessedChars, true);
            return true;
        }
        if (s.length() > 1) {
            return false;
        }
        s = s.toLowerCase();
        int c = s.charAt(0);
        boolean found = false;
        for (int i = 0; i < wordChars.length; i++) {
            if (wordChars[i] == c) {
                guessedChars[i] = true;
                found = true;
            }
        }
        if (!found) {
            c -= 'a';
            guessed[c]++;
        }
        return found;
    }

    String getWord() {
       return word;
    }
}
