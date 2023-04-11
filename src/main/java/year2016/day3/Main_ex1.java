package year2016.day3;

import bufferedReader.Reader;

import java.io.*;
import java.util.List;

public class Main_ex1 {

    private static boolean isTriangleValid(int x, int y, int z){
        return (x + y) > z & (x + z) > y & (y + z) > x;
    }

    private static int howManyValidTriangle(List<String> input){
        int compteur = 0;

        for(int i = 0; i < input.size(); i++){

            String[] str = input.get(i).split(" ");

            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int z = Integer.parseInt(str[2]);

            if(isTriangleValid(x,y,z)){
                compteur +=1;
            }
        }

        return compteur;
    }

    public static List<String> cleanInput(List<String> input){

        for (int i = 0; i < input.size(); i++) {

            String[] tab = input.get(i).trim().split(" +");
            String cleanedString = tab[0] + " " + tab[1] + " " + tab[2];
            input.set(i,cleanedString);
        }
        return input;
    }
    public static void main(String[] args) throws IOException {

        String path = "C:\\BM\\projets\\advent_of_code\\src\\main\\java\\year2016\\day3\\inputs\\input.txt";

        Reader reader = new Reader();

        List<String> input = reader.readFile(path);

        System.out.println(howManyValidTriangle(cleanInput(input)));

    }
}
