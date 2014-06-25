import Controller.Controller;
import Model.*;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Indexation.indexation();
        Level level =  Parser.parse(1);
    }
}
