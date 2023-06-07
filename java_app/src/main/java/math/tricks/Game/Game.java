package math.tricks.Game;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import math.tricks.Board.Board;
import math.tricks.Bot.Bot;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class Game {
    Bot bot;
    Board board;

    public void start() {

    }
}
