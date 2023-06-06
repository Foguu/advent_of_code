package year2017.day4;

import bufferedReader.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "src/main/java/year2017/day4/inputs/input.txt";
        Reader reader = new Reader();

        List<String> input = reader.readFile(path);

        List<String[]> cleanedInput = cleanInput(input);

        //partie 1

        int numberOfValidPassphrase = howManyValidPassphrase(cleanedInput);
        System.out.println(numberOfValidPassphrase);

        //partie 2

        int numberOfSafePassphrase = howManySafePassphrase(cleanedInput);
        System.out.println(numberOfSafePassphrase);
    }

    private static int howManySafePassphrase(List<String[]> input) {
        int count = 0;
        for (int i = 0; i < input.size(); i++) {
            String[] sortedLine = alphabeticalSort(input.get(i));
            if (isThereDuplicatedWords(sortedLine) == false){
                count++;
            }
        }

        return count;
    }

    private static String[] alphabeticalSort(String[] input) {
        String[] sortedInput = new String[input.length];
        for (int i = 0; i < input.length; i++) {
            char[] chArray = input[i].toCharArray();
            Arrays.sort(chArray);
            sortedInput[i] = String.valueOf(chArray);
        }
        return sortedInput;
    }

    private static List<String[]> cleanInput(List<String> input) {
        List<String[]> cleanedInput = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            String[] cleanedLine = input.get(i).split(" ");
            cleanedInput.add(cleanedLine);
        }
        return cleanedInput;
    }

    private static int howManyValidPassphrase(List<String[]> input) {
        int count = 0;
        for (int i = 0; i < input.size(); i++) {
            if (isThereDuplicatedWords(input.get(i)) == false) { // mieux ca ou if (!isThereDuplicatedWords(input.get(i))) avec le "!" ?
                count++;
            }
        }
        return count;
    }

    private static boolean isThereDuplicatedWords(String[] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = i + 1; j < t.length; j++) {
                if (t[i].equals(t[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}
