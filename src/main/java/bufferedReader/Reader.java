package bufferedReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {

    public List<String> readFile(String path) throws IOException {

        File file = new File(path);

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;

        List<String> input = new ArrayList<>();

        while ((st = br.readLine()) != null){
            input.add(st);
        }

        return input;
    }
}
