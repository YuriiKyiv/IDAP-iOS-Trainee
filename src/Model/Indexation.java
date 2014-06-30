package Model;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class Indexation {

    private static ConcurrentMap<Integer, Long> mainTable = new ConcurrentSkipListMap<Integer, Long>();

    public static ConcurrentMap<Integer, Long> getMainTable() {
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
