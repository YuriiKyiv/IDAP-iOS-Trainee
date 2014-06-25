package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static String[] read() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("D:\\Work\\IDAP-iOS-Trainee\\input.txt"));
        String line;
        List<String> lines = new ArrayList<String>();
        while ((line = reader.readLine()) != null){
            lines.add(line);
        }
        String[] linesAsArray = lines.toArray(new String[lines.size()]);
        for (int i = 0; i < linesAsArray.length; i++){
            System.out.println(linesAsArray[i]);
        }
        return linesAsArray;
    }

}
