package math.tricks.Board;

import lombok.Getter;

import java.util.Arrays;
import java.util.Scanner;

@Getter
public class Board {

    private Integer[] gameboardSize;
    private GameBoard gameBoard;

    public Board() {
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream

        System.out.print("Enter the board size (XxY): ");
        String rawGamboardSize = sc.nextLine();
        this.gameboardSize = this.getConvertedBoardSize(rawGamboardSize);
        this.gameBoard = new GameBoard(this.gameboardSize);

        this.showBoard();
    }

    private Integer[] getConvertedBoardSize(String rawSize) {
        return Arrays.stream(rawSize.split("x")).map(Integer::parseInt).toArray(Integer[]::new);
    }

    public void showBoard() {
        System.out.print("+ ");
        for (Integer n = 0; n < this.gameboardSize[1]; n++) {
            System.out.print(" ----- ");
        }
        System.out.println(" +");
        for (Integer i = 0; i < this.gameboardSize[0]; i++) {
            System.out.print("| ");
            for (Integer n = 0; n < this.gameboardSize[1]; n++) {
                System.out.print(String.format(" %s>%s<%s ",
                        this.gameBoard.board[i][n].isValid == IsValidFor.P1 ? "1" : this.gameBoard.board[i][n].isValid == IsValidFor.P2 ? "2" : "N",
                        this.gameBoard.board[i][n].nmb,
                        this.gameBoard.board[i][n].isValid == IsValidFor.P1 ? "1" : this.gameBoard.board[i][n].isValid == IsValidFor.P2 ? "2" : "N"));
            }
            System.out.println(" |");
        }
        System.out.print("+ ");
        for (Integer n = 0; n < this.gameboardSize[1]; n++) {
            System.out.print(" ----- ");
        }
        System.out.println(" +");
    }

}
