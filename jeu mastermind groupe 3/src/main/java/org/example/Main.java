package org.example;

public class Main {
    public static void main(String[] args) {
        Game game = new Game(true); // true pour que le joueur soit le codebreaker
        game.codemakerTurn();
        game.codebreakerTurn();
        //game.play();
    }

}
