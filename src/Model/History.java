package Model;

import java.util.LinkedList;
import java.util.List;

public class History {

    private static List<Level> historyLevels = new LinkedList<Level>();

    public static List<Level> getHistoryLevels() {
        return historyLevels;
    }

    public static void  addLevel(Level level){
        historyLevels.add(level);
    }

    public static void deleteLevel(){
        historyLevels.remove(0);
    }
}
