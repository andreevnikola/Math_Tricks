package math.tricks.Board;

import lombok.Getter;

import java.util.Arrays;
import java.util.Scanner;

@Getter
public class Board {

    private Integer[] gameboardSize;
    private GameBoard gameBoard;

    public Board generate() {
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream

        System.out.print("Enter the board size (XxY): ");
        String rawGamboardSize = sc.nextLine();
        this.gameboardSize = this.getConvertedBoardSize(rawGamboardSize);
        this.gameBoard = new GameBoard();
        return this;
    }

    private Integer[] getConvertedBoardSize(String rawSize) {
        return Arrays.stream(rawSize.split("x")).map(Integer::parseInt).toArray(Integer[]::new);
    }

    public void showBoard() {
        System.out.println();
    }

}
