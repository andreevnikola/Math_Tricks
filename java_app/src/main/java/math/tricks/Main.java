package math.tricks;

import math.tricks.Game.Game;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        UserInput userInput = new UserInput();
        Game game = userInput.ask();
        game.start();
    }
}