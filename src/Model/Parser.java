package Model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class Parser {

    private static HashMap<Integer, Long> mainTable = new HashMap<Integer, Long>();

    public static void parser(int lvl) throws IOException {
        long address = mainTable.get(lvl);
        String path = "D:\\Work\\IDAP-iOS-Trainee\\input.txt";

        RandomAccessFile file;
        file = new RandomAccessFile(path,"r");
        file.seek(address);

        String line;
        List<Answer> answers = new ArrayList<Answer>();
        Level level = new Level();
        level.setDescription(file.readLine());
        Answer answer = new Answer();
        while (!(line = file.readLine()).equals("</level>")){
            if (line.equals("<ans>")){
                answer.setDescription(file.readLine());
                answer.setLink(Integer.parseInt(file.readLine()));
            }
        }
        level.setAnswers(answers);

    }

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
                //System.out.println(key);
                value = file.getFilePointer();
                //System.out.println(value);
                mainTable.put(key, value);
            }
            //System.out.println(line);
        }
        file.close();

    }

}
