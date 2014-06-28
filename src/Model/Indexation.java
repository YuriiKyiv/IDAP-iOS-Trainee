package Model;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;

public class Indexation {

    private static HashMap<Integer, Long> mainTable = new HashMap<Integer, Long>();

    public static HashMap<Integer, Long> getMainTable() {
        return mainTable;
    }

    public static void indexation(String path) throws IOException {
        RandomAccessFile file;
        file = new RandomAccessFile(path,"r");
        String line;
        int key;
        long value;
        while ((line = file.readLine()) != null) {
            if (line.equals("<level>")){
                key = Integer.parseInt(file.readLine());
                value = file.getFilePointer();
                mainTable.put(key, value);
            }
        }
        file.close();
    }

}
