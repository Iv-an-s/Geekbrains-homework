package part3.lesson3.history;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class HistoryService {

    public static void saveToHistory (String line){
        try (FileOutputStream fileOutputStream =
                 new FileOutputStream("C:\\Java\\GeekBrainsHomework\\src\\part3\\lesson3\\history\\ChatHistory.txt", true);
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream))
        ){
            bufferedWriter.write(line);
            bufferedWriter.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printLastNLines(int count){
        try (FileInputStream fileInputStream =
                new FileInputStream("C:\\Java\\GeekBrainsHomework\\src\\part3\\lesson3\\history\\ChatHistory.txt");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream))
        ){
            String line;
            List<String> lastLines = new ArrayList<>();
            while ((line = bufferedReader.readLine())!=null){
                lastLines.add(line);
            }
            int startLine = lastLines.size()-count;
            if (startLine < 0){
                startLine = 0;
            }
            for (int i = startLine; i < lastLines.size(); i++){
                System.out.println(lastLines.get(i));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
