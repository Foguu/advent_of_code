package year2017.day3;

public class Main {

    private static final int INPUT = 265149;

    public static void main(String[] args) {

        //Idée à chaud : On regarde la couronne concerné avec les carrés (dans le coin inférieur droit c'est touujours le carré de la taille de la couronne (1 ,9 ,25 ,etc...))
        //  comme ca on connait la distance minimale pour y aller et ensuite on a juste a faire des medianes en regardant si notre nombre est plus ou moins grand afin de trouver
        //  plus en plus précisement son emplacement et donc en rajoutant le nombre de case a parcourir "sur" la couronne


        int cursor = 1;
        int distanceMinCouronne = 0;
        int tailleCouronne = 1;
        int mod = 0;
        while (cursor < INPUT) {
            cursor = (int) Math.pow(Math.sqrt(cursor) + 2, 2);
            distanceMinCouronne += 1;
            tailleCouronne = 8 * distanceMinCouronne; //Math.sqrt(cursor) - 1) * 4 =:= 8 * distanceMinimum
            mod = tailleCouronne / 4;
        }

        int tailleChemin = Math.abs((distanceMinCouronne+1)-INPUT%mod) + distanceMinCouronne;
        System.out.println(tailleChemin);
    }
}
