import Model.*;
import View.View;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        View.starMenu();
        Indexation.indexation();
        Scanner in = new Scanner(System.in);
        in.next();
        int lvl = 1;
        while (!Game.isEnd()) {
            Level level =  Parser.parse(lvl);
            View.showLevel(level);
            int input = in.nextInt();
            if (input <= level.getAnswers().size() && input > -2 ){
                if (input == -1){
                    Game.setStatus(true);
                } else {
                    if (input <= level.getAnswers().size() && input > 1) {
                        lvl = level.getAnswers().get(input - 1).getLink();
                    } else {
                        if (level.getAnswers().get(input - 1).getLink() == -2){
                            Game.setStatus(true);
                            View.playerIsDead();
                        } else {
                            if (level.getAnswers().get(input - 1).getLink() == -2) {
                                Game.setStatus(true);
                                View.playerIsWinner();
                            }

                        }
                    }
                }

            } else {
                View.noCorrectAnswer();
            }
        }
    }
}
