package year2017.day3;

public class Main {

    private static final int INPUT = 265149;

    public static void main(String[] args) {

        int curseur = 1;
        int distanceMinimum = 0;
        int tailleCouronne = 1;
        int modulo = 0;

        while (curseur < INPUT) {
            curseur = (int) Math.pow(Math.sqrt(curseur) + 2, 2);
            distanceMinimum += 1;
            tailleCouronne = 8 * distanceMinimum; //Math.sqrt(cursor) - 1) * 4 =:= 8 * distanceMinimum
            modulo = tailleCouronne / 4;
        }

        int longueurChemin = Math.abs((distanceMinimum + 1) - INPUT % modulo) + distanceMinimum;
        System.out.println(longueurChemin);
    }
}
