package Model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PreLoader {

    private static String path = "D:\\Work\\IDAP-iOS-Trainee\\input.txt";

    public static List<Level> levels = new ArrayList<Level>();

    public static List<Level> getLevels() {
        return levels;
    }

    public static void preload(final Level level){
        if (!PreLoader.getLevels().isEmpty()){
            PreLoader.getLevels().clear();
        }
        for ( final Answer answer : level.getAnswers()) {
            Thread thread = new Thread(answer.getDescription()){
                @Override
                public void run() {
                    try {
                        levels.add(Parser.parse(answer.getLink(), path));
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.run();
        }
    }
}
