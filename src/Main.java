import Model.*;
import View.View;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static final int SIZE_OF_HISTORY = 1;

    public static final int LOSER = -2;

    public static final int WINNER = -3;

    public static final int EXIT = -1;

    public static final int FIRST_LEVEL = 1;

    private static String path = "D:\\Work\\IDAP-iOS-Trainee\\input.txt";

    public static String getPath() {
        return path;
    }

    public static void setPath(String path) {
        Main.path = path;
    }

    public static Level findLevel(int lvl) throws IOException, InterruptedException {

        for (Level level : History.getHistoryLevels()) {
            if (level.getNumber() == lvl){
                return level;
            }
        }

        Level level = Parser.parse(lvl, Main.getPath());
        if (History.getHistoryLevels().size() > SIZE_OF_HISTORY) {
            History.deleteLevel();
        }
        History.addLevel(level);
        return level;

    }


    public static void main(String[] args) throws IOException, InterruptedException {

        if (args.length > 0){
            Main.setPath(args[0]);
        }

        View.starMenu();
        Thread thread = new Thread("file"){
            @Override
            public void run(){
                try {
                    Indexation.indexation(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

        Scanner in = new Scanner(System.in);
        in.next();
        int lvl = FIRST_LEVEL;
        while (!Game.isEnd()) {
            Level level =  Main.findLevel(lvl);
            View.showLevel(level);
            int input = in.nextInt();
            if (input <= level.getAnswers().size() && input > LOSER ){
                if (input == EXIT) {
                    Game.setStatus(true);
                } else {
                    switch (level.getAnswers().get(input-1).getLink()) {
                        case LOSER :
                            Game.setStatus(true);
                            View.playerIsDead();
                            break;
                        case WINNER :
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
