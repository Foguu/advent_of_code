package year2016.day3;

import bufferedReader.Reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main_ex2 {


    private static int howManyValidTriangle(List<Triangle> input) {
        int compteur = 0;

        for (Triangle triangle : input) {

            if (triangle.isValid()) {
                compteur += 1;
            }
        }

        return compteur;
    }

    public static List<Triangle> cleanInput(List<String> input, String type) {

        List<Triangle> triangleList = new ArrayList<Triangle>();

        if (type.equals("horizontal")) {
            for (int i = 0; i < input.size(); i++) {

                String[] tab = input.get(i).trim().split(" +");

                Triangle triangle_horizontal = new Triangle(Integer.parseInt(tab[0]), Integer.parseInt(tab[1]), Integer.parseInt(tab[2]));

                triangleList.add(triangle_horizontal);
            }
        } else if (type.equals("vertical")) {
            for (int i = 0; i < input.size() - 2; i += 3) {

                String[] tab1 = input.get(i).trim().split(" +");
                String[] tab2 = input.get(i + 1).trim().split(" +");
                String[] tab3 = input.get(i + 2).trim().split(" +");

                Triangle triangle_vertical1 = new Triangle(Integer.parseInt(tab1[0]), Integer.parseInt(tab2[0]), Integer.parseInt(tab3[0]));
                Triangle triangle_vertical2 = new Triangle(Integer.parseInt(tab1[1]), Integer.parseInt(tab2[1]), Integer.parseInt(tab3[1]));
                Triangle triangle_vertical3 = new Triangle(Integer.parseInt(tab1[2]), Integer.parseInt(tab2[2]), Integer.parseInt(tab3[2]));

                triangleList.add(triangle_vertical1);
                triangleList.add(triangle_vertical2);
                triangleList.add(triangle_vertical3);
            }
        }
        return triangleList;
    }

    public static void main(String[] args) throws IOException {

        String path = "C:\\BM\\projets\\advent_of_code\\src\\main\\java\\year2016\\day3\\inputs\\input2.txt";

        String h = "horizontal";
        String v = "vertical";

        Reader reader = new Reader();

        List<String> input = reader.readFile(path);

        System.out.println("Il y a " + howManyValidTriangle(cleanInput(input, h)) + " triangles horizontaux valides.");

        System.out.println("Il y a " + howManyValidTriangle(cleanInput(input, v)) + " triangles verticaux valides.");

    }
}
