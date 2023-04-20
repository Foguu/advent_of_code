package year2018.day3;

import bufferedReader.Reader;
import year2015.day3.Position;

import java.io.IOException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {

        String path = "C:\\BM\\projets\\advent_of_code\\src\\main\\java\\year2018\\day3\\inputs\\input.txt";
        Reader reader = new Reader();
        List<String> input = reader.readFile(path);

        List<Zone> cleanedInput = cleanInput(input);

        int numberOfMatchingPositions = howManyMatchingPos(cleanedInput);

        System.out.println("Il y a " + numberOfMatchingPositions + " zone(s) qui sont superposées.");


    }

    private static int howManyMatchingPos(List<Zone> cleanedInput) {
        int compteur = 0;
        Map<Position,Boolean> map = new HashMap<>();

        for (int i = 0; i < cleanedInput.size(); i++) {
            List<Position> coveredPositions = cleanedInput.get(i).coveredPositions();

            for (int j = 0; j < coveredPositions.size(); j++) {
                Position key = coveredPositions.get(j);
                if(map.containsKey(key)){
                    map.put(key,true);
                }else {
                    map.put(key, false);
                }
            }
        }

        for (Map.Entry<Position,Boolean> entry : map.entrySet())
        {
            if (entry.getValue()){
                compteur += 1;
            }
        }

        return compteur;
    }

    private static List<Zone> cleanInput(List<String> input){
        List<Zone> cleanedInput = new ArrayList<>();
        int id = 0;
        int length= 0;
        int width= 0;

        for (int i = 0; i < input.size(); i++) {
            int[] sortedInput = sortInput(input.get(i)); // tableau de type [ID, X, Y, LONGUEUR, LARGEUR]

            id = sortedInput[0];
            Position position = new Position(
                    sortedInput[1],
                    sortedInput[2]
            );
            length = sortedInput[3];
            width = sortedInput[4];

            Zone zone = new Zone(id,position,length,width);
            cleanedInput.add(zone);

        }

        return cleanedInput;
    }

    private static int[] sortInput(String s) {

        s = replaceCharInInput(s);

        String[] sortedInput = s.split(" ");
        int[] finalSortedlist = new int[sortedInput.length];

        for (int i = 0; i < sortedInput.length; i++) {
            finalSortedlist[i] = Integer.valueOf(sortedInput[i]);
        }
        return finalSortedlist;
    }

    private static String replaceCharInInput(String s) {
        s = s.replaceAll("#","");
        s = s.replaceAll("@","");
        s = s.replaceAll(":","");
        s = s.replaceAll(","," ");
        s = s.replaceAll("x"," ");
        s = s.replaceAll("  "," ");
        return s;
    }


}
