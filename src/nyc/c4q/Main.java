package nyc.c4q;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        do {
            gameHangman();
        }while (playAgain());
    }
    public static void gameHangman() {
        Hangman hangman = new Hangman();
        while (hangman.getMisses() < 5) {
            hangman.printCurrentWord();
            hangman.promptPlayer("Enter a letter: ");
            hangman.readLetter();
            hangman.checkLetter();
            if (hangman.guessedSuccessfully()) {
                break;
            }
            System.out.println(Drawing.get(hangman.getMisses()));
            System.out.println("Misses -> " + hangman.getMisses());
        }
        if (hangman.guessedSuccessfully()) {
            System.out.println("Success");
        } else {
            System.out.println("The answer was " + hangman.getSecretWord());
        }
    }


    private static boolean playAgain() {
        System.out.println("Would you like to play again?  Y(yes) or N(no). ");
        Scanner scan = new Scanner(System.in);
        String answer = scan.next();
        String lowanswer = answer.toLowerCase();
        boolean play = false;
        if((lowanswer.equals("yes")) || (lowanswer.equals("y"))){
            play = true;
        }else if((lowanswer.equals("no")) || (lowanswer.equals("n"))){
            play = false;
        }else{
            playAgain();
        }
        return play;
    }
}
