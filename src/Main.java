import Model.*;
import View.View;

import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {
        String path = "D:\\Work\\IDAP-iOS-Trainee\\input.txt";

        if (args.length > 0){
            path = args[0];
        }
        View.starMenu();
        Indexation.indexation(path);
        Scanner in = new Scanner(System.in);
        in.next();
        int lvl = 1;
        while (!Game.isEnd()) {
            Level level =  Parser.parse(lvl, path);
            View.showLevel(level);
            int input = in.nextInt();
            if (input <= level.getAnswers().size() && input > -2 ){
                if (input == -1) {
                    Game.setStatus(true);
                } else {
                    switch (level.getAnswers().get(input-1).getLink()) {
                        case -2 :
                            Game.setStatus(true);
                            View.playerIsDead();
                            break;
                        case -3 :
                            Game.setStatus(true);
                            View.playerIsWinner();
                            break;
                        default:
                            lvl = level.getAnswers().get(input-1).getLink();
                            break;
                    }
                }

            } else {
                View.noCorrectAnswer();
            }
        }
    }
}
