import java.util.Arrays;
import java.util.Scanner;

public class HangmanGame {
    public static final char PLACEHOLDER = '_';
    public static final int MAX_TRIES = 6;
    String word;
    Integer triesLeft;
    char [] guessedLetters;

    public HangmanGame(String word) {
        this.word = word;
        this.triesLeft = MAX_TRIES;
        guessedLetters = new char[word.length()];
        Arrays.fill(guessedLetters, PLACEHOLDER);
    }

    public void play() {
        while (triesLeft > 0){
            showGuessedLetters();
            String letter = insertLetter();
            if(!verifyLetter(letter)){
                triesLeft--;
                showTriesLeft();
            } else {
                if(guessedAllLetters()) {
                    System.out.println("Ai castigat!");
                    return;
                }
            }
        }
        System.out.println("Ai pierdut!");
    }

    private Boolean guessedAllLetters() {
      return new String(guessedLetters).indexOf(PLACEHOLDER) < 0;
    }

    private String insertLetter() {
        System.out.println("Introdu o litera: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();


    }

    private Boolean verifyLetter(String letter) {
        Integer index = word.indexOf(letter);
        if (index >= 0){
            do {
               guessedLetters[index] = letter.charAt(0);
               index = word.indexOf(letter, index + 1);
            } while (index > 0);
            return true;
        }

            return false;
        }


    private void showGuessedLetters() {
    for (int i=0; i<word.length(); i++) {
        System.out.print(guessedLetters[i] + " ");
    }
        System.out.println();

        }
        private void showTriesLeft() {
            System.out.println("Mai ai " + triesLeft + " incercari ");
        }
    }
