package MatriisiKirjasto;

/**
 * Sisältää operaatioita 2d-listoille eli matriiseille.
 *
 * @author Bugi
 */
public class MatrixOperations {

    /**
     * Suorittaa matriisiyhteenlaskun annetuille matriiseille.
     *
     * @param matrix1 Ensimmäinen operoitava matriisi
     * @param matrix2 Toinen operoitava matriisi
     * @return Yhteenlaskun tulosmatriisi tai null, mikäli vastaan tulee null.
     * @throws MatrixDimensionException Mikäli dimensiot eivät täsmää (oltava
     * täsmälleen samat).
     */
    public static int[][] MAdd(int[][] matrix1, int[][] matrix2) throws MatrixDimensionException {
        try {
            if (matrix1.length != matrix2.length) {
                throw new MatrixDimensionException("Matrices need to have same dimensions in addition!");
            } else {
                int[][] result = matrix1.clone();  // Nopeutetaan laskemista ottamalla pohjaksi toinen matriiseista.
                for (int i = 0; i < matrix1.length; i++) {
                    for (int j = 0; j < matrix1[0].length; j++) {
                        result[i][j] += matrix2[i][j];  // matr1:n arvo on jo tulostaulussa,
                    }
                }
                return result;
            }
        }
        catch (NullPointerException e) {  // Jokin alilistoista tai matriisi itse voi olla null.
            return null;
        }
    }

    /**
     * Suorittaa matriisiyhteenlaskun annetuille matriiseille.
     *
     * @param matrix1 Ensimmäinen operoitava matriisi
     * @param matrix2 Toinen operoitava matriisi
     * @return Yhteenlaskun tulosmatriisi
     * @throws MatrixDimensionException Mikäli dimensiot eivät täsmää (oltava
     * täsmälleen samat).
     */
    public static double[][] MAdd(int[][] matrix1, double[][] matrix2) throws MatrixDimensionException {
        try {
            if (matrix1.length != matrix2.length) {
                throw new MatrixDimensionException("Matrices need to have same dimensions in addition!");
            }
            double[][] result = matrix2.clone();  // Nopeutetaan laskemista ottamalla pohjaksi toinen matriiseista.
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    result[i][j] += matrix1[i][j];  // matr2:n arvo on jo tulostaulussa,
                }
            }
            return result;
        }
        catch (NullPointerException e) {  // Jokin alilistoista tai matriisi itse voi olla null.
            return null;
        }
    }

    /**
     * Suorittaa matriisiyhteenlaskun annetuille matriiseille.
     *
     * @param matrix1 Ensimmäinen operoitava matriisi
     * @param matrix2 Toinen operoitava matriisi
     * @return Yhteenlaskun tulosmatriisi
     * @throws MatrixDimensionException Mikäli dimensiot eivät täsmää (oltava
     * täsmälleen samat).
     */
    public static double[][] MAdd(double[][] matrix1, int[][] matrix2) throws MatrixDimensionException {
        return MAdd(matrix2, matrix1);
    }

    /**
     * Suorittaa matriisiyhteenlaskun annetuille matriiseille.
     *
     * @param matrix1 Ensimmäinen operoitava matriisi
     * @param matrix2 Toinen operoitava matriisi
     * @return Yhteenlaskun tulosmatriisi
     * @throws MatrixDimensionException Mikäli dimensiot eivät täsmää (oltava
     * täsmälleen samat).
     */
    public static double[][] MAdd(double[][] matrix1, double[][] matrix2) throws MatrixDimensionException {
        try {  // Ei tarkisteta vaikeammin saavutettavia dimensioita (jokaisen listan pituutta) etukäteen.
            if (matrix1.length != matrix2.length) {
                throw new MatrixDimensionException("Matrices need to have same dimensions in addition!");
            }
            double[][] result = matrix1.clone();  // Nopeutetaan laskemista ottamalla pohjaksi toinen matriiseista.
            for (int i = 0; i < matrix1.length; i++) {
                for (int j = 0; j < matrix1[0].length; j++) {
                    result[i][j] += matrix2[i][j];  // matr1:n arvo on jo tulostaulussa.
                }
            }
            return result;
        }
        catch (NullPointerException e) {  // Jokin alilistoista tai matriisi itse voi olla null.
            return null;
        }
    }

    /**
     * Kertoo annetun matriisin annetulla vakiolla.
     *
     * @param constant Vakio
     * @param matrix Matriisi
     * @return Matriisi kerrotuuna vakiolla
     */
    public static int[][] MMult(int constant, int[][] matrix) {
        try {
            int[][] result = matrix.clone();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] *= constant;
                }
            }
            return result;
        }
        catch (NullPointerException e) {
            return null;
        }
    }

    /**
     * Kertoo annetun matriisin annetulla vakiolla.
     *
     * @param constant Vakio
     * @param matrix Matriisi
     * @return Matriisi kerrotuuna vakiolla
     */
    public static double[][] MMult(double constant, double[][] matrix) {
        try {
            double[][] result = matrix.clone();
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] *= constant;
                }
            }
            return result;
        }
        catch (NullPointerException e) {
            return null;
        }

    }

    /**
     * Kertoo annetun matriisin annetulla vakiolla.
     *
     * @param constant Vakio
     * @param matrix Matriisi
     * @return Matriisi kerrotuuna vakiolla
     */
    public static double[][] MMult(double constant, int[][] matrix) {
        try {
            double[][] result = new double[matrix.length][matrix[0].length];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = constant * matrix[i][j];
                }
            }
            return result;
        }
        catch (NullPointerException e) {
            return null;
        }
    }

    /**
     * Kertoo annetun matriisin annetulla vakiolla.
     *
     * @param constant Vakio
     * @param matrix Matriisi
     * @return Matriisi kerrotuuna vakiolla
     */
    public static double[][] MMult(int constant, double[][] matrix) {
        return MMult((double) constant, matrix);
    }
}
