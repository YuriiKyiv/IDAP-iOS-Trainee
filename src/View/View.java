package View;

import Model.Answer;
import Model.History;
import Model.Level;

import java.util.LinkedList;
import java.util.List;

public class View {

    public static final int LINE_LENGTH = 50;

    public static void showBoldLine(int l){
        for (int i = 0; i < l; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    public static void showLine(int l){
        for (int i = 0; i < l; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void  showLevelNumber(Level level){
        System.out.println("Level: " + level.getNumber());
    }

    public static void showLevelDescription(Level level){
        System.out.println(level.getDescription());
    }

    public static void showLevelAnswers(Level level){
        int i = 0;
        List<Answer> answers = level.getAnswers();
        for (Answer ans : answers){
            i++;
            System.out.println(i + ". - " + ans.getDescription());
        }
    }

    public static void showExit(){
        System.out.println("-1. - Exit");
    }

    public static void showLevel(Level level){
        View.showBoldLine(LINE_LENGTH);
        View.showLevelNumber(level);
        View.showLine(LINE_LENGTH);
        View.showLevelDescription(level);
        View.showLine(LINE_LENGTH);
        View.showLevelAnswers(level);
        View.showBoldLine(LINE_LENGTH);
        View.showExit();
        View.showBoldLine(LINE_LENGTH);
    }

    public static void  printHistory(){
        List<Level> levels = new LinkedList<Level>();
        levels = History.getHistoryLevels();
        for (Level level : levels) {
            System.out.println(level.getDescription());
        }
    }

    public static void starMenu(){
        System.out.println("Welcome to the game");
        System.out.println("Press any key to continue");
    }

    public static void noCorrectAnswer(){
        System.out.println(" Please, enter the correct answer");
    }

    public static void playerIsDead(){
        System.out.println("YOU ARE DEAD");
    }

    public static void playerIsWinner(){
        System.out.println("YOU ARE WINNER");
    }

}
