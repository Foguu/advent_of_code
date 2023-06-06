package year2021.day3;

import bufferedReader.Reader;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        String path = "src/main/java/year2021/day3/inputs/input.txt";
        Reader reader = new Reader();

        List<String> input = reader.readFile(path);

        //PARTIE 1:

        int powerConsumption = howMuchPower(input);

        System.out.println("power consumption is : " + powerConsumption);

        //PARTIE 2:

        int co2 = 0;
        int oxygen = 1;

        int lifeSupportRate = lifeSupportRating(input);
    }

    private static int howMuchPower(List<String> input) {
        int binaryTest = 0;
        String result = "";
        for (int i = 0; i < input.get(0).length(); i++) {
            result += mostCommonBinaryValue(input, i);
        }

        String reversedResult = reverseString(result);

        int intValueOfResult = Integer.parseInt(result, 2);
        int intValueOfReversedResult = Integer.parseInt(reversedResult, 2);

        int powerConsumption = intValueOfResult * intValueOfReversedResult;

        return powerConsumption;
    }

    private static String reverseString(String result) {
        String reversedResult = "";
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) == '1') {
                reversedResult += '0';
            } else {
                reversedResult += '1';
            }
        }
        return reversedResult;
    }

    private static int lifeSupportRating(List<String> input) {
        int lifeSupportRate = 0;

        List<String> oxygenGeneratorRating = input;
        List<String> co2ScrubberRating = input;

        for (int i = 0; i < input.get(0).length(); i++) {

            String mostCommonBinaryValue = mostCommonBinaryValue(input, i);

            for (int j = 0; j < input.size(); j++) {
                if (String.valueOf(input.get(j).charAt(i)) == mostCommonBinaryValue){

                }
            }
        }
        return lifeSupportRate;
    }

    private static String mostCommonBinaryValue(List<String> input, int index){
        int binaryTest = 0;
        for (int i = 0; i < input.size(); i++) {
            if(input.get(i).charAt(index) == '0'){
                binaryTest--;
            }else{
                binaryTest++;
            }
        }

        if(binaryTest < 0 ){
            return "0";
        }else {
            return "1";
        }
    }
}
