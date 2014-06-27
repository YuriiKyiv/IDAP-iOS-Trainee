package Model;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;


public  class Parser {

    public static Level parse(int lvl, String path) throws IOException, InterruptedException {
        Thread thread = Thread.currentThread();
        while (Indexation.getMainTable().isEmpty()){
            thread.sleep(1000);
        }
        while (Indexation.getMainTable().get(lvl) == null){
            thread.sleep(1000);
        }
        long address = Indexation.getMainTable().get(lvl);

        RandomAccessFile file;
        file = new RandomAccessFile(path,"r");
        file.seek(address);

        String line;
        Level level = new Level();
        level.setNumber(lvl);
        level.setDescription(file.readLine());
        List<Answer> answers = new ArrayList<Answer>();

        while (!(line = file.readLine()).equals("</level>")){
            if (line.equals("<ans>")){
                Answer answer = new Answer();
                answer.setDescription(file.readLine());
                answer.setLink(Integer.parseInt(file.readLine()));
                answers.add(answer);
            }
        }

        level.setAnswers(answers);
        file.close();
        return level;
    }
}
