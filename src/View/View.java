package View;

import Model.Answer;
import Model.History;
import Model.Level;
import Model.Parser;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;

public class View {

    public static void showLevel(Level level){
        System.out.println(level.getDescription());
        System.out.println("------------------------");

        List<Answer> answers = level.getAnswers();
        int i = 0;
        for (Answer ans : answers){
            i++;
            System.out.println(i + ". - " + ans.getDescription());
        }
        System.out.println("-1. - Exit");
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
