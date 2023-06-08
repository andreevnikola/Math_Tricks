package math.tricks.Board;

import java.util.Random;

enum Sign {
    ADD, SUBTRACT, DIVIDE, MULTIPLY
}

class Field {
    public Sign sign;
    public Integer nmb;
    public IsValidFor isValid;
    public String stringedSign;

    public Field(Sign sign, Integer nmb, IsValidFor isValid) {
        this.stringedSign = sign == Sign.DIVIDE ? "/" : sign == Sign.SUBTRACT ? "-" : sign == Sign.MULTIPLY ? "*" : "";
        this.nmb = nmb;
        this.isValid = isValid;
        this.sign = sign;
    }
}

public class GameBoard {

    Field[][] board;

    public GameBoard(Integer[] size) {
        this.board = new Field[size[0]][size[1]];
        final Random rnd = new Random();
        for (Integer i = 0; i < size[0]; i++) {
            for (Integer n = 0; n < size[1]; n++) {
                this.board[i][n] = new Field(Sign.values()[rnd.nextInt(Sign.values().length)], rnd.nextInt(6), IsValidFor.NOONE);
            }
        }
        this.board[0][0].isValid = IsValidFor.P1;
        this.board[size[0]-1][size[0]-1].isValid = IsValidFor.P2;
    }
}
