package Model;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;


public  class Parser {

    public static Level parse(int lvl) throws IOException {

        long address = Indexation.getMainTable().get(lvl);
        String path = "D:\\Work\\IDAP-iOS-Trainee\\input.txt";

        RandomAccessFile file;
        file = new RandomAccessFile(path,"r");
        file.seek(address);

        String line;
        Level level = new Level();
        level.setDescription(file.readLine());
        Answer answer = new Answer();
        List<Answer> answers = new ArrayList<Answer>();

        while (!(line = file.readLine()).equals("</level>")){
            if (line.equals("<ans>")){
                answer.setDescription(file.readLine());
                answer.setLink(Integer.parseInt(file.readLine()));
                answers.add(answer);
            }
        }

        level.setAnswers(answers);
        return level;
    }
}
