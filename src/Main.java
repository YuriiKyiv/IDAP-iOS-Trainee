import Controller.Controller;
import Model.*;
import View.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        View.starMenu();
        Indexation.indexation();
        Level level =  Parser.parse(1);
        View.showLevel(level);
        Scanner in = new Scanner(System.in);
        while (!Game.isEnd()) {
            int input = in.nextInt();
            if (input <= level.getAnswers().size() && input > -2 ){

            } else {
                View.noCorrectAnswer();
            }
        }
    }
}
