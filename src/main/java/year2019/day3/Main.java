package year2019.day3;

import bufferedReader.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        String path = "src/main/java/year2019/day3/inputs/input.txt";
        Reader reader = new Reader();

        List<String> input =  reader.readFile(path);
        List<String> cleanedInput = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            cleanedInput.add(Arrays.toString(input.get(i).split(",")));
        }
    }
}
