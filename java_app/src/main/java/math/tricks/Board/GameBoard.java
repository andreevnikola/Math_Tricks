package math.tricks.Board;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class Field {
    public String sign;
    public Integer nmb;
    public boolean isValid;
}

public class GameBoard {

    Field[][] board;

    public void generate(Integer[] size) {
        this.board = new Field[size[0]][size[1]];
        for (Integer i = 0; i < size[0]; i++) {
            for (Integer n = 0; n < size[1]; n++) {
                this.board[i][n] = new Field();
            }
        }
    }
}
