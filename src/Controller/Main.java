package Controller;

import Model.*;
import View.View;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static final int SIZE_OF_HISTORY = 1;

    public static final int LOSER = -2;

    public static final int WINNER = -3;

    public static final int EXIT = -1;

    public static final int FIRST_LEVEL = 1;

    private static String path = "D:\\Work\\IDAP-iOS-Trainee\\input.txt";

    public static Level loadLevel;

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

        for (Level level : PreLoader.getLevels()){
            if (level.getNumber() == lvl)
                return level;
        }

        Level level = Parser.parse(lvl, Main.getPath());
        if (History.getHistoryLevels().size() > SIZE_OF_HISTORY) {
            History.deleteLevel();
        }
        History.addLevel(level);
        return level;

    }

    public static void viewDead(){
        new Thread("ViewDead"){
            @Override
            public void run(){
                View.playerIsDead();
            }
        }.run();
    }

    public static void viewWinner(){
        new Thread("ViewWinner"){
            @Override
            public void run(){
                View.playerIsWinner();
            }
        }.run();
    }


    public static void main(String[] args) throws IOException, InterruptedException {

        if (args.length > 0){
            Main.setPath(args[0]);
        }

        View.starMenu();

        Thread thread = new Thread("Indexation"){
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
            loadLevel =  Main.findLevel(lvl);
            new Thread(){
                @Override
                public void run(){
                    try {
                        PreLoader.load(loadLevel);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.run();
            View.showLevel(loadLevel);
            int input = in.nextInt();
            if (input <= loadLevel.getAnswers().size() && input > LOSER ){
                if (input == EXIT) {
                    Game.setStatus(true);
                } else {
                    switch (loadLevel.getAnswers().get(input-1).getLink()) {
                        case LOSER :
                            Game.setStatus(true);
                            Main.viewDead();
                            break;
                        case WINNER :
                            Game.setStatus(true);
                            Main.viewWinner();
                            break;
                        default:
                            lvl = loadLevel.getAnswers().get(input-1).getLink();
                            break;
                    }
                }

            } else {
                View.noCorrectAnswer();
            }
        }
        View.printPreLoader();
        View.printHistory();
    }
}
