package year2022.day3;

import bufferedReader.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "src/main/java/year2022/day3/inputs/input.txt";
        Reader reader = new Reader();

        List<String> input = reader.readFile(path);

        //PART 1

        List<Character> items = findDuplicates(input);
        int sumOfAllPriorities = sumOfAllChar(items);

        System.out.println("The sum of all priorities is : " + sumOfAllPriorities);

        //PART 2

        int sizeOfElvesGroup = 3;
        List<Character> badges = findNeededBadges(input, sizeOfElvesGroup);

        int sumOfAllPrioritiesWithBadges = sumOfAllChar(badges);

        System.out.println("The sum of all badge's priorities is : " + sumOfAllPrioritiesWithBadges);
    }

    private static List<Character> findNeededBadges(List<String> input, int sizeOfElvesGroups) {
        List<Character> neededBadges = new ArrayList<Character>();

        //TODO finir

        return neededBadges;
    }

    private static int sumOfAllChar(List<Character> items) {
        int sum = 0;

        for (int i = 0; i < items.size(); i++) {
            char character = items.get(i);

            if (Character.isLowerCase(character)) {
                sum += (Integer.valueOf(character) - 96);

            } else if (Character.isUpperCase(character)) {
                sum += (Integer.valueOf(character) - 64 + 26);

            }
        }

        return sum;
    }

    private static List<Character> findDuplicates(List<String> input) {
        List<Character> duplicates = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            List<Character> itemsInBag = new ArrayList<>();
            for (int j = 0; j < input.get(i).length(); j++) {
                char item = input.get(i).charAt(j);
                if (j < input.get(i).length() / 2) {
                    itemsInBag.add(item);
                } else {
                    if (itemsInBag.contains(item)) {
                        duplicates.add(item);
                        break;
                    }
                }
            }
        }
        return duplicates;
    }


}
