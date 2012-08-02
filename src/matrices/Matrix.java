package matrices;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * Sisältää matriiseja generoivia metodeja, sekä 2d taulukoiden tulostukseen
 * soveltuvia metodeja.
 *
 * @author Bugi
 */
public class Matrix {

    private Matrix() {
    }

    /**
     * *** MATRIISIEN TULOSTUSTA     ******
     */
    /*
     * Tulostuksien ei tarvitse olla tehokkaita, koska niitä ei toivottavasti
     * käytetä kriittisissä vaiheissa.
     */
    
    /**
     * Muodostaa merkkijonoesityksen parametrinä annetusta matriisista.
     * 
     * @param matrix Matriisi, josta muodostetaan merkkijono.
     * @return Merkkijonoesitys annetusta matriisista.
     */
//    public static String printMatrix(int[][] matrix) {
//        if (matrix.length <= 1) {
//            String result = "[";
//            for (int i = 0; i < matrix[0].length; i++) {
//                result = result.concat(" " + matrix[0][i]);
//            }
//            result = result.concat(" ]");
//            return result;
//        } else {
//            // Etsitään suurin ja pienin alkio formatointia varten.
//            int min = Integer.MAX_VALUE;
//            int max = Integer.MIN_VALUE;
//            for (int i = 0; i < matrix.length; i++) {
//                for (int j = 0; j < matrix[i].length; j++) {
//                    int current = matrix[i][j];
//                    if (current < min) min = current;
//                    if (current > max) max = current;
//                }
//            }
//            // Lasketaan näiden pituudet ("hitaasti", mutta vakioajassa).
//            int minLength = String.valueOf(min).length();
//            int maxLength = String.valueOf(max).length();
//            // Valitaan pidempi
//            int indexMaxLength = Math.max(minLength, maxLength);
//            
//            // Muodostetaan merkkijono alkioista riveittäin.
//            String result = new String();
//            for (int i = 0; i < matrix.length; i++) {
//                result = result.concat("|");
//                for (int j = 0; j < matrix[i].length; j++) {
//                    StringUtils.repeat();
//                }
//                result = result.concat(" |" + "\n");
//            }
//            return "";
//        }
//    }

    /**
     * *** MATRIISIEN GENEROINTIA     ******
     */
    /*
     * Generointi on myös harvoin käytettävä toimenpide, joten mitään optimointia ei harrasteta.
     */
    
    /**
     * Tuottaa annetun kokoisen nollamatriisin.
     *
     * @param size Nollamatriisin koko (>=0).
     * @return size:n kokoinen nollamatriisi.
     * @throws IllegalArgumentException
     */
    public static int[][] zeroMatrix(int size) throws IllegalArgumentException {
        return zeroMatrix(size, size);
    }
        
    /**
     * Tuottaa annetun kokoisen nollamatriisin.
     *
     * @param width Nollamatriisin leveys.
     * @param height Nollamatriisin korkeus.
     * @return width*height-kokoinen nollamatriisi.
     * @throws IllegalArgumentException
     */
    public static int[][] zeroMatrix(int width, int height) throws IllegalArgumentException {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("A matrix must have positive dimensions!");
        }
        int[][] zeros = new int[height][width];
        // Ei luoteta oletusarvoihin. 
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                zeros[i][j] = 0;
            }
        }
        return zeros;
    }
    
    /**
     * Tuottaa annetun kokoisen nollamatriisin.
     *
     * @param size Nollamatriisin koko (>=0).
     * @return size:n kokoinen nollamatriisi.
     * @throws IllegalArgumentException
     */
    public static double[][] zeroMatrixDbl(int size) throws IllegalArgumentException {
        return zeroMatrixDbl(size, size);
    }

    /**
     * Tuottaa annetun kokoisen nollamatriisin.
     *
     * @param width Nollamatriisin leveys.
     * @param height Nollamatriisin korkeus.
     * @return width*height-kokoinen nollamatriisi.
     * @throws IllegalArgumentException
     */
    public static double[][] zeroMatrixDbl(int width, int height) throws IllegalArgumentException {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("A matrix must have positive dimensions!");
        }
        double[][] zeros = new double[height][width];
        // Ei luoteta oletusarvoihin. 
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                zeros[i][j] = 0;
            }
        }
        return zeros;
    }

    /**
     * Tuottaa pyydetyn kokoisen yksikkömatriisin.
     *
     * @param size Yksikkömatriisin koko (>= 0).
     * @return size:n kokoinen yksikkömatriisi.
     */
    public static int[][] identityMatrix(int size) throws IllegalArgumentException {
        if (size < 0) {
            throw new IllegalArgumentException("A matrix must have positive size!");
        }
        int[][] identity = zeroMatrix(size);
        for (int i = 0; i < size; i++) {
            identity[i][i] = 1;
        }
        return identity;
    }
    
    /**
     * Tuottaa pyydetyn kokoisen yksikkömatriisin.
     *
     * @param size Yksikkömatriisin koko (>= 0).
     * @return size:n kokoinen yksikkömatriisi.
     */
    public static double[][] identityMatrixDbl(int size) throws IllegalArgumentException {
        if (size < 0) {
            throw new IllegalArgumentException("A matrix must have positive size!");
        }
        double[][] identity = zeroMatrixDbl(size);
        for (int i = 0; i < size; i++) {
            identity[i][i] = 1;
        }
        return identity;
    }
}
