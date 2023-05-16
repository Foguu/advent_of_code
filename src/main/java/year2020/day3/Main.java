package year2020.day3;

import bufferedReader.Reader;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        String path = "src/main/java/year2020/day3/inputs/input.txt";
        Reader reader = new Reader();

        List<String> input = reader.readFile(path);

        // PARTIE 1 :
        int numberOfEncounteredTree = howManyEncounteredTree(input);

        System.out.println("On rencontre " + numberOfEncounteredTree + " arbres.");

        //PARTIE 2 :
        long askedValue = howManyEncounteredTreeBySlope(input, 1, 1); // long pcq int ca overflow et ca passe dans en négatif
        askedValue = askedValue * howManyEncounteredTreeBySlope(input, 3, 1);
        askedValue = askedValue * howManyEncounteredTreeBySlope(input, 5, 1);
        askedValue = askedValue * howManyEncounteredTreeBySlope(input, 7, 1);
        askedValue = askedValue * howManyEncounteredTreeBySlope(input, 1, 2);

        System.out.println("Le produit des nombres d'arbres " +
                "+rencontrés en fonction des différents types de pentes est: " + askedValue);
    }

    private static int howManyEncounteredTree(List<String> input) {
        int horizontalPosition = 0;
        int count = 0;

        for (int i = 1; i < input.size(); i++) {
            horizontalPosition = (3 * i) % input.get(i).length();

            if (input.get(i).charAt(horizontalPosition) == '#') {
                count += 1;
            }
        }
        return count;
    }

    private static int howManyEncounteredTreeBySlope(List<String> input, int horizontalMovementValue, int verticalMovementValue) {
        int horizontalPosition = 0;
        int count = 0;

        for (int i = 0; i < input.size(); i++){
            if (i % verticalMovementValue == 0) { // pour ne pas prendre en compte les lignes intermediaires dans le cas ou le mouvement vertical est != 1
                horizontalPosition = ((horizontalMovementValue * i) / verticalMovementValue) % input.get(i).length();
                count += checkPresenceOfTree(input, i, horizontalPosition);
            }
        }
        return count;
    }

    private static int checkPresenceOfTree(List<String> input, int i, int horizontalPosition) {
        if (input.get(i).charAt(horizontalPosition) == '#') {
            return 1;
        } else {
            return 0;
        }
    }
}
