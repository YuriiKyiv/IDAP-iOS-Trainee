package View;

import Model.Answer;
import Model.Level;
import Model.Parser;

import java.io.IOException;
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
    }

    public static void starMenu(){
        System.out.println("Welcome to the game");
        System.out.println("Press any key to continue");
    }


}
