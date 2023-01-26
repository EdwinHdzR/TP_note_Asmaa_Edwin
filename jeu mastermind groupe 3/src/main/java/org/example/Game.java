package org.example;
import java.util.Scanner;


/**

 La classe Game est utilisée pour jouer au jeu Mastermind. Elle contient des méthodes pour jouer le tour de l'opérateur Codebreaker et de l'opérateur CodeMaker. Elle contient également des variables statiques pour définir le nombre maximal de tours, les couleurs disponibles pour le jeu et le nombre de pions utilisés dans le jeu.

 @author asmaa et edwin
 */
public class Game {
    private static final int MAX_TURNS = 12; // Nombre maximal de tours dans une partie
    private static final String[] COLORS = {"yellow", "blue", "red", "green", "white", "black"}; // Couleurs disponibles pour le jeu
    private static final int NUM_PEGS = 4; // Nombre de pions utilisés dans le jeu
    private int turns; // Nombre de tours joués actuellement
    private String[] secretCode; // Code secret de l'opérateur CodeMaker
    private int[] score; // Score de l'opérateur Codebreaker et de l'opérateur CodeMaker
    private boolean isCodebreaker; // Booléen indiquant si c'est le tour de l'opérateur Codebreaker
    private boolean gameOver; // Booléen indiquant si la partie est terminée

    public String[] getSecretCode() {
        return secretCode;
    }

    public int[] getScore() {
        return score;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    /**

     Le constructeur de la classe Game prend en entrée un booléen qui indique si l'opérateur jouant est l'opérateur Codebreaker ou CodeMaker.
     Il initialise également le score à 0 pour les deux joueurs.
     @param isCodebreaker Booléen indiquant si c'est le tour de l'opérateur Codebreaker ou CodeMaker
     */
    public Game(boolean isCodebreaker) {
        this.isCodebreaker = isCodebreaker;
        this.score = new int[]{0, 0};
    }
    /**

     La méthode play() est utilisée pour lancer une partie de Mastermind. Elle utilise les méthodes codebreakerTurn() et codemakerTurn() pour jouer les tours des joueurs.
     */
    public void play() {
        if (isCodebreaker) {
            codebreakerTurn();
        } else {
            codemakerTurn();
        }
    }
/**

 La méthode codemakerTurn() est utilisée pour jouer le tour de l'opérateur CodeMaker
 Tour pour le Codemaker. Il définit le code secret à deviner.
 */

 void codemakerTurn() {
        Scanner input = new Scanner(System.in);
        System.out.println("Entrez le code secret svp (choose from: " + String.join(", ", COLORS) + "): ");
        System.out.println("Separated by a comma and a space ");


        secretCode = new String[NUM_PEGS];
        for (int i = 0; i < NUM_PEGS; i++) {
            secretCode[i] = input.next();
        }

        System.out.println("The secret code has been set. The codebreaker will now try to guess it.");
    }
    /**

     La méthode codebreakerTurn() est utilisée pour jouer le tour de l'opérateur Codebreaker
     Tour pour le Codebreaker. Il devine le code secret
     */
    boolean codebreakerTurn() {
        Scanner input = new Scanner(System.in);
        String[] guess = new String[NUM_PEGS];
        int blackPegs = 0;
        int whitePegs = 0;

        System.out.println("Enter your guess (choose from: " + String.join(", ", COLORS) + "): ");
        System.out.println("Separated by a comma and a space ");
        for (int i = 0; i < NUM_PEGS; i++) {
            guess[i] = input.next();
        }

        for (int i = 0; i < NUM_PEGS; i++) {
            if (guess[i].equals(secretCode[i])) {
                blackPegs++; // le nombre d'élèments dans la mauvaise position
            } else {
                for (int j = 0; j < NUM_PEGS; j++) {
                    if (guess[i].equals(secretCode[j])) {
                        whitePegs++;
                        break;
                    }
                }
            }
        }
        System.out.println("Black pegs: " + blackPegs + ", White pegs: " + whitePegs);
        if (blackPegs == NUM_PEGS) {
            System.out.println("Congratulations, you've cracked the code!");
            score[0]++;
            gameOver = true;
        } else if (turns == MAX_TURNS) {
            System.out.println("Sorry, you've run out of turns. The secret code was: " + String.join(" ", secretCode));
            score[1]++;
            gameOver = true;
        }
        return false;
    }
}