package Controller;

import Model.Answer;
import Model.Indexation;
import Model.Level;
import Model.Parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Alternative {

    public static void main(String[] args) {
        System.out.println("Fine");
        try {
            Indexation.indexation(Main.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Level firstLevel = new Level();
        try {
            firstLevel = Parser.parse(1,Main.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (Answer answer : firstLevel.getAnswers()) {
            try {
                firstLevel.getNextLevels().add(Parser.parse(answer.getLink(), Main.getPath()));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        };

    }
}
