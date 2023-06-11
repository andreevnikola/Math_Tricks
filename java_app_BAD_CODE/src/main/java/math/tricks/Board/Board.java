package math.tricks.Board;

import lombok.Getter;

import java.util.Arrays;
import java.util.Scanner;

@Getter
public class Board {

    private Integer[] gameboardSize;
    public GameBoard gameBoard;

    public Board() {
        this.ask();
        this.showBoard();
    }

    private void ask(){
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream

        System.out.print("Enter the board size (XxY): ");
        String rawGamboardSize = sc.nextLine();
        try {
            this.gameboardSize = this.getConvertedBoardSize(rawGamboardSize);
        } catch (Exception e) {
            System.out.println("The input should be in format XxY!");
            this.ask();
        }
        this.gameBoard = new GameBoard(this.gameboardSize);
    }

    private Integer[] getConvertedBoardSize(String rawSize) throws Exception {
        return Arrays.stream(rawSize.split("x")).map(Integer::parseInt).toArray(Integer[]::new);
    }

    public void showBoard() {
        System.out.print("  + ");
        for (Integer n = 0; n < this.gameboardSize[0]; n++) {
            System.out.print(" --#" + (n + 1) + "-- ");
        }
        System.out.println(" +");
        for (Integer i = 0; i < this.gameboardSize[1]; i++) {
            System.out.print((i + 1) + " | ");
            for (Integer n = 0; n < this.gameboardSize[0]; n++) {
                System.out.print(String.format(" %s>%s<%s ",
                        this.gameBoard.board[i][n].isValid == IsValidFor.P1 ? "1" : this.gameBoard.board[i][n].isValid == IsValidFor.P2 ? "2" : "N",
                        String.format("%S%s", this.gameBoard.board[i][n].stringedSign, this.gameBoard.board[i][n].nmb),
                        this.gameBoard.board[i][n].isValid == IsValidFor.P1 ? "1" : this.gameBoard.board[i][n].isValid == IsValidFor.P2 ? "2" : "N"));
            }
            System.out.println(" | " + (i + 1));
        }
        System.out.print("  + ");
        for (Integer n = 0; n < this.gameboardSize[0]; n++) {
            System.out.print(" --#" + (n + 1) + "-- ");
        }
        System.out.println(" +");
    }

    public void changeOwnerability(Integer[] position, IsValidFor owner) throws Exception {
        if (this.gameBoard.board[position[1]][position[0]].canBeReachedFrom != owner) {
            throw new Exception();
        }
        this.gameBoard.board[position[1]][position[0]].isValid = owner;
        try {this.gameBoard.board[position[1]][position[0]].canBeReachedFrom = IsValidFor.UNREACHABLE;} catch (Exception ex) {};
        try {this.gameBoard.board[position[1]+1][position[0]].canBeReachedFrom = this.gameBoard.board[position[1]+1][position[0]].canBeReachedFrom == IsValidFor.UNREACHABLE ? IsValidFor.UNREACHABLE : owner;} catch (Exception ex) {};
        try {this.gameBoard.board[position[1]+1][position[0]+1].canBeReachedFrom = this.gameBoard.board[position[1]+1][position[0]+1].canBeReachedFrom == IsValidFor.UNREACHABLE ? IsValidFor.UNREACHABLE : owner;} catch (Exception ex) {};
        try {this.gameBoard.board[position[1]-1][position[0]].canBeReachedFrom = this.gameBoard.board[position[1]-1][position[0]].canBeReachedFrom == IsValidFor.UNREACHABLE ? IsValidFor.UNREACHABLE : owner;} catch (Exception ex) {};
        try {this.gameBoard.board[position[1]-1][position[0]-1].canBeReachedFrom = this.gameBoard.board[position[1]-1][position[0]-1].canBeReachedFrom == IsValidFor.UNREACHABLE ? IsValidFor.UNREACHABLE : owner;} catch (Exception ex) {};
        try {this.gameBoard.board[position[1]][position[0]+1].canBeReachedFrom = this.gameBoard.board[position[1]][position[0]+1].canBeReachedFrom == IsValidFor.UNREACHABLE ? IsValidFor.UNREACHABLE : owner;} catch (Exception ex) {};
        try {this.gameBoard.board[position[1]][position[0]-1].canBeReachedFrom = this.gameBoard.board[position[1]][position[0]-1].canBeReachedFrom == IsValidFor.UNREACHABLE ? IsValidFor.UNREACHABLE : owner;} catch (Exception ex) {};
    }

}
