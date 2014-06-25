import Controller.Controller;
import Model.*;
import View.View;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        View.starMenu();
        Indexation.indexation();
        Level level =  Parser.parse(1);
        View.showLevel(level);
    }
}
