package math.tricks.Game;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import math.tricks.Board.Board;
import math.tricks.Board.IsValidFor;
import math.tricks.Board.Sign;
import math.tricks.Bot.Bot;

import java.util.Arrays;
import java.util.Scanner;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class Game {
    Bot bot;
    Board board;

    private float[] playersScore;

    public void start() {
        System.out.println("|  Let the game begin  |");
        this.playersScore = new float[2];
        this.round(IsValidFor.P1);
    }

    public void round(IsValidFor activePlayer){
        System.out.println(String.format("It's player %s's turn!", activePlayer == IsValidFor.P1 ? "#1" : "#2"));

        Scanner sc= new Scanner(System.in); //System.in is a standard input stream

        System.out.print("Please choose target position in format - XxY: ");
        String rawPosition = sc.nextLine();

        Integer[] position = new Integer[2];
        try {
            position = this.getConvertedPosition(rawPosition);
            if (position[0] > this.board.getGameboardSize()[0] || position[1] > this.board.getGameboardSize()[1]) {
                System.out.println("Please enter valid input!");
                this.round(activePlayer);
            }
        } catch (Exception e) {
            System.out.println("Please enter valid input!");
            this.round(activePlayer);
        }

        try {
            this.board.changeOwnerability(position, activePlayer);
        } catch (Exception e) {
            System.out.println("Please select a valid position on the board!");
            System.out.println("For position to be valid it should be at most one position distance from plate owned by you!");
            this.round(activePlayer);
        }
        this.board.showBoard();

        if (activePlayer == IsValidFor.P1) {
            if (this.board.gameBoard.board[position[1]][position[0]].sign == Sign.ADD) playersScore[0] += this.board.gameBoard.board[position[1]][position[0]].nmb;
            if (this.board.gameBoard.board[position[1]][position[0]].sign == Sign.MULTIPLY) playersScore[0] *= this.board.gameBoard.board[position[1]][position[0]].nmb;
            if (this.board.gameBoard.board[position[1]][position[0]].sign == Sign.SUBTRACT) playersScore[0] -= this.board.gameBoard.board[position[1]][position[0]].nmb;
            if (this.board.gameBoard.board[position[1]][position[0]].sign == Sign.DIVIDE) playersScore[0] /= this.board.gameBoard.board[position[1]][position[0]].nmb;
        } else {
            if (this.board.gameBoard.board[position[1]][position[0]].sign == Sign.ADD) playersScore[1] += this.board.gameBoard.board[position[1]][position[0]].nmb;
            if (this.board.gameBoard.board[position[1]][position[0]].sign == Sign.MULTIPLY) playersScore[1] *= this.board.gameBoard.board[position[1]][position[0]].nmb;
            if (this.board.gameBoard.board[position[1]][position[0]].sign == Sign.SUBTRACT) playersScore[1] -= this.board.gameBoard.board[position[1]][position[0]].nmb;
            if (this.board.gameBoard.board[position[1]][position[0]].sign == Sign.DIVIDE) playersScore[1] /= this.board.gameBoard.board[position[1]][position[0]].nmb;
        }

        System.out.println("============================");
        System.out.println("========SCOREBOARD:========");
        System.out.println("Player1: " + ((int)playersScore[0]));
        System.out.println("Player2: " + ((int)playersScore[1]));
        System.out.println("============================");

        boolean[] hasPlaceToGo = new boolean[]{false, false};
        for (Integer i = 0; i < this.board.getGameboardSize()[1]; i++) {
            for (Integer n = 0; n < this.board.getGameboardSize()[0]; n++) {
                if (this.board.gameBoard.board[i][n].canBeReachedFrom == IsValidFor.P1) hasPlaceToGo[0] = true;
                if (this.board.gameBoard.board[i][n].canBeReachedFrom == IsValidFor.P2) hasPlaceToGo[1] = true;
            }
        }

        if (!hasPlaceToGo[0] || !hasPlaceToGo[1]) {
            System.out.println("============================");
            System.out.println("======WE HAVE A WINNER======");
            System.out.println("THE WINNER IS: " + (playersScore[0] >= playersScore[1] ? "Player1" : "Player2"));
            System.out.println("========SCOREBOARD:========");
            System.out.println("Player1: " + playersScore[0]);
            System.out.println("Player2: " + playersScore[1]);
            System.out.println("============================");
            while (true) { }
        }

        this.round(activePlayer == IsValidFor.P1 ? IsValidFor.P2 : IsValidFor.P1);
    }

    private Integer[] getConvertedPosition(String rawPosition) throws Exception {
        return Arrays.stream(rawPosition.split("x")).map((String raw) -> {
            Integer asInt = Integer.parseInt(raw);
            return asInt-1;
        }).toArray(Integer[]::new);
    }
}
