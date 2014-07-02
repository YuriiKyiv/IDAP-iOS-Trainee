package Model;

import Controller.Main;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PreLoader {

    private static String path = Main.getPath();

    private static List<Level> levels = new CopyOnWriteArrayList<Level>();

    public static void load(Level level) throws IOException, InterruptedException {
        if (!levels.isEmpty()){
            levels.clear();
        }
        for (Answer answer : level.getAnswers()) {
            if (!(answer.getLink() < 0)) {
                PreLoader.levels.add(Parser.parse(answer.getLink(), Main.getPath()));
            }
        }

    }

    public static List<Level> getLevels() {
        return levels;
    }
}
