package Model;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;


public class Parser {

    private static HashMap<Integer, Long> mainTable = new HashMap<Integer, Long>();

    public static void indexation() throws IOException {
        String path = "D:\\Work\\IDAP-iOS-Trainee\\input.txt";

        RandomAccessFile file;
        file = new RandomAccessFile(path,"r");
        String line;
        int key;
        long value;
        while ((line = file.readLine()) != null) {
            if (line.equals("<level>")){
                key = Integer.parseInt(file.readLine());
                System.out.println(key);
                value = file.getFilePointer();
                System.out.println(value);
                mainTable.put(key, value);
            }
            //System.out.println(line);
        }
        file.close();

    }

}
