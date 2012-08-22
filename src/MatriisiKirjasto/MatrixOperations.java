package MatriisiKirjasto;

/**
 * Sisältää operaatioita 2d-listoille eli matriiseille.
 *
 * @author Bugi
 */
public class MatrixOperations {
    
    /**
     * Transponoi parametrina annetun matriisin.
     * 
     * @param matrix Transponoitava matriisi
     * @return Matriisin transpoosi. Transpoosissa sarakkeet käännetään riveiksi
     */
    private static int[][] MTranspose(int[][] matrix) {
        try {
            // Nollanpituisia transpooseja on vaikea määritellä.
            // Tälläisessä tapauksessa matriisi ei voi sisältää kuitenkaan tietoa, joten palautetaan matriisi itsessään.
            if (matrix.length == 0 || matrix[0].length == 0) {
                return matrix;
            }

            int[][] transposed = new int[matrix[0].length][matrix.length];

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    transposed[j][i] = matrix[i][j];
                }
            }

            return transposed;
        }
        catch (NullPointerException e) {
            return null;
        }
    }

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
    
    /**
     * Suorittaa matriisikertolaskun syötteinä oleville matriiseille.
     * Syötematriisien dimensioiden tulee olla muotoa (m x n) * (n x p), jolloin tulosmatriisin dimensiot ovat m x p.
     * Mikäli keskimmäiset dimensiot eivät täsmää, ei operaatiota voida suorittaa.
     * 
     * @param matrix1 Ensimmäinen (vasen) syötematriisi
     * @param matrix2 Toinen (oikea) syötematriisi
     * @return Matriisikertolaskun tulosmatriisi
     */
    private static int[][] MMult(int[][] matrix1, int[][] matrix2) throws MatrixDimensionException{
        
        // Otetaan avuksi toisen matriisin transpoosi, jolloin luetaan sarakkeiden sijaan rivejä.
        // Tämä on villinä arvauksena muistinhallinnan ja lokaaliuden takia nopeampaa.
        int[][] matrix2Transposed = MTranspose(matrix2);
        int[][] result = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                /* 
                 * Lasketaan tulosmatriisin kukin alkio kaavasta C_ij = sum(A_ik * B_kj), k = 1, m
                 * Tässä m on ensimmäisen matriisin leveys ja toisen korkeus ja suoritettava laskutoimitus AB = C
                 * (Tässä tapauksessa siis matrix1 * matrix2 = result)
                 */
                int elementSum = 0;
                for (int k = 0; k < matrix2.length; k++) {
                    elementSum += matrix1[i][k] * matrix2Transposed[j][k];
                }
                result[i][j] = elementSum;
            }
        }

        return result;
    }
}
