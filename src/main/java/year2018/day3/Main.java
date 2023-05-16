package year2018.day3;

import bufferedReader.Reader;
import year2015.day3.Position;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {

        String path = "src/main/java/year2018/day3/inputs/input.txt";
        Reader reader = new Reader();

        List<Zone> cleanedInput = reader.readFile(path).stream()
                .map(line->cleanInput(List.of(line)))
                .map(zones -> zones.get(0))
                .collect(Collectors.toList());

        int numberOfMatchingPositions = howManyMatchingPos(cleanedInput);

        System.out.println("Il y a " + numberOfMatchingPositions + " zone(s) qui sont superposées.");
    }

    private static int howManyMatchingPos(List<Zone> cleanedInput) {
        int compteur = 0;
        Map<Position, Boolean> map = new HashMap<>();

        for (Zone zone : cleanedInput) {
            List<Position> coveredPositions = zone.coveredPositions();

            for (Position key : coveredPositions) {
                map.put(key, map.containsKey(key));
            }
        }

        whichClaimIsIntact(cleanedInput, map); // PARTIE 2

        for (Map.Entry<Position, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                compteur += 1;
            }
        }

        return compteur;
    }

    private static void whichClaimIsIntact(List<Zone> cleanedInput, Map<Position, Boolean> map) { // PARTIE 2
        for (Zone zone : cleanedInput) {
            List<Position> coveredPositions = zone.coveredPositions();
            boolean isClaimIntact = true;

            for (Position key : coveredPositions) {
                if (map.get(key)) {
                    isClaimIntact = false;
                    break;
                }
            }
            if (isClaimIntact) {
                System.out.println(zone.getId());
            }
        }
    }

    private static List<Zone> cleanInput(List<String> input) {
        List<Zone> cleanedInput = new ArrayList<>();
        int id;
        int length;
        int width;

        for (String s : input) {
            int[] sortedInput = sortInput(s); // tableau de type [ID, X, Y, LONGUEUR, LARGEUR]

            id = sortedInput[0];
            Position position = new Position(
                    sortedInput[1],
                    sortedInput[2]
            );
            length = sortedInput[3];
            width = sortedInput[4];

            Zone zone = new Zone(id, position, length, width);
            cleanedInput.add(zone);

        }

        return cleanedInput;
    }

    private static int[] sortInput(String s) {

        s = replaceCharInInput(s);

        String[] sortedInput = s.split(" ");

        return Arrays.stream(sortedInput)
                .mapToInt(Integer::parseInt)
                .toArray();
//        int[] finalSortedlist = new int[sortedInput.length];
//
//        for (int i = 0; i < sortedInput.length; i++) {
//            finalSortedlist[i] = Integer.parseInt(sortedInput[i]);
//        }
//        return finalSortedlist;
    }

    private static String replaceCharInInput(String s) {
        s = s.replaceAll("#", "");
        s = s.replaceAll("@", "");
        s = s.replaceAll(":", "");
        s = s.replaceAll(",", " ");
        s = s.replaceAll("x", " ");
        s = s.replaceAll(" +", " ");
        return s;
    }


}
