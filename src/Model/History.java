package Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class History {

    private static List<Level> historyLevels = new ArrayList<Level>();

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
