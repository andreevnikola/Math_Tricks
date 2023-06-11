package math.tricks.Board;

import java.util.Random;

public class GameBoard {

    public Field[][] board;

    public GameBoard(Integer[] size) {
        this.board = new Field[size[1]][size[0]];
        final Random rnd = new Random();
        for (Integer i = 0; i < size[1]; i++) {
            for (Integer n = 0; n < size[0]; n++) {
                this.board[i][n] = new Field(Sign.values()[rnd.nextInt(Sign.values().length)], rnd.nextInt(6), IsValidFor.NOONE);
            }
        }
        this.board[0][0].isValid = IsValidFor.P1;
        this.board[0][0].nmb = 0;
        this.board[0][0].sign = Sign.ADD;
        this.board[0][0].stringedSign = "+";
        this.board[0][0].canBeReachedFrom = IsValidFor.UNREACHABLE;
        this.board[1][0].canBeReachedFrom = IsValidFor.P1;
        this.board[1][1].canBeReachedFrom = IsValidFor.P1;
        this.board[0][1].canBeReachedFrom = IsValidFor.P1;
        this.board[size[1]-1][size[0]-1].isValid = IsValidFor.P2;
        this.board[size[1]-1][size[0]-1].nmb = 0;
        this.board[size[1]-1][size[0]-1].sign = Sign.ADD;
        this.board[size[1]-1][size[0]-1].stringedSign = "+";
        this.board[size[1]-2][size[0]-1].canBeReachedFrom = IsValidFor.P2;
        this.board[size[1]-2][size[0]-1].canBeReachedFrom = IsValidFor.UNREACHABLE;
        this.board[size[1]-2][size[0]-2].canBeReachedFrom = IsValidFor.P2;
        this.board[size[1]-1][size[0]-2].canBeReachedFrom = IsValidFor.P2;
    }
}
