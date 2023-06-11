package math.tricks;

import lombok.Getter;
import math.tricks.Board.Board;
import math.tricks.Bot.Bot;
import math.tricks.Game.Game;

import java.util.Arrays;
import java.util.Scanner;

@Getter
public class UserInput {
    public Game ask() {
        Scanner sc= new Scanner(System.in); //System.in is a standard input stream

        Board board = new Board();

        System.out.print("Select the type of the game - with friend (1v1) or with bot (BOT): ");
        String playingType = sc.nextLine();

        Bot bot = new Bot();
        if (playingType.equals("BOT") || playingType.equals("bot") || playingType.equals("Bot")) {
            bot = bot.generate();
        }

        return Game.builder()
                .bot(bot)
                .board(board)
                .build();
    }
}
