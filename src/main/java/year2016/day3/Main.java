package year2016.day3;

import bufferedReader.Reader;

import java.io.*;
import java.util.List;

public class Main {

    private static boolean isTriangleValid(int x, int y, int z){
        return (x + y) > z & (x + z) > y & (y + z) > x;
    }

    private static int howManyValidTriangle(List<String> input){
        int compteur = 0;

        for(int i = 0; i < input.size(); i++){

            int x = Integer.parseInt(input.get(i));
            int y = Integer.parseInt(input.get(i + 1));
            int z = Integer.parseInt(input.get(i + 2));

            if(isTriangleValid(x,y,z)){
                compteur +=1;
            }

            i += 2;
        }

        return compteur;
    }
    public static void main(String[] args) throws IOException {

        String path = "C:\\BM\\projets\\advent_of_code\\src\\main\\java\\year2016\\day3\\inputs\\input.txt";

        Reader reader = new Reader();

        List<String> input = reader.readFile(path);

        System.out.println(input);

        //on trim + split pour avoir le bon format et on envoie dans la fonction howManyTriangleValid et hop lé

    }
}
