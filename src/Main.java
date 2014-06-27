import Model.*;
import View.View;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static String path = "D:\\Work\\IDAP-iOS-Trainee\\input.txt";

    public static String getPath() {
        return path;
    }

    public static void setPath(String path) {
        Main.path = path;
    }

    public static Level findLevel(int lvl) throws IOException {
        Level level = Parser.parse(lvl, path);
        if (History.getHistoryLevels().size() > 1) {
            History.deleteLevel();
        }
        History.addLevel(level);
        return level;

    }


    public static void main(String[] args) throws IOException {

        if (args.length > 0){
            Main.setPath(args[0]);
        }
        View.starMenu();
        Indexation.indexation(path);
        Scanner in = new Scanner(System.in);
        in.next();
        int lvl = 1;
        while (!Game.isEnd()) {
            Level level =  Main.findLevel(lvl);
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

        View.printHistory();
    }
}
