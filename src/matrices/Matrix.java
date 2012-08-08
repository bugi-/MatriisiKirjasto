package matrices;

/**
 * Sisältää matriiseja generoivia metodeja, sekä 2d taulukoiden tulostukseen
 * soveltuvia metodeja.
 *
 * @author Bugi
 */
public class Matrix {

    private static final String emptyMatrixString = "[ ]";
    
    private Matrix() {
    }

    /*
     * *** MATRIISIEN TULOSTUSTA     ******
     * 
     * Tulostuksien ei tarvitse olla tehokkaita, koska niitä ei toivottavasti
     * käytetä kriittisissä vaiheissa.
     */
    
    /**
     * Muodostaa merkkijonoesityksen parametrinä annetusta matriisista.
     * 
     * @param matrix Matriisi, josta muodostetaan merkkijono.
     * @return Merkkijonoesitys annetusta matriisista.
     */
    public static String toString(int[][] matrix) {
        if (matrix.length == 0) {
            return emptyMatrixString;
        }
        else if (matrix.length == 1) {
            StringBuilder result = new StringBuilder("[");
            for (int i = 0; i < matrix[0].length; i++) {
                result.append(matrix[0][i]);
            }
            result.append(" ]");
            return result.toString();
        }
        else {
            if (matrix[0].length == 0) {
                return emptyMatrixString;
            }
            else {
                // Etsitään suurin ja pienin alkio formatointia varten.
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        int current = matrix[i][j];
                        if (current < min) min = current;
                        if (current > max) max = current;
                    }
                }
                // Lasketaan merkkien määrä kymmenkantaisena ("hitaasti", mutta vakioajassa (kai)).
                int minLength = String.valueOf(min).length();
                int maxLength = String.valueOf(max).length();
                // Valitaan pidempi
                int indexMaxLength = Math.max(minLength, maxLength);

                // Muodostetaan merkkijono alkioista riveittäin.
                StringBuilder result = new StringBuilder();
                for (int i = 0; i < matrix.length; i++) {
                    result.append("|");
                    for (int j = 0; j < matrix[i].length; j++) {
                        // Tasataan oikealle, joten alkuun täytetään välilyönneillä  (vähintään 1)
                        int currentElement = matrix[i][j];
                        int numSpaces = indexMaxLength - String.valueOf(currentElement).length() + 1;
                        for (int k = numSpaces; k > 0; k--) {
                            result.append(" ");
                        }
                        result.append(currentElement);
                    }
                    result.append(" |\n");
                }
                result.deleteCharAt(result.length() - 1); // Poistetaan viimeinen rivinvaihto.
                return result.toString();
            }
        }
    }

    /**
     * *** MATRIISIEN GENEROINTIA     ******
     * 
     * Generointi on myös harvoin käytettävä toimenpide, joten turhaa optimointia ei harrasteta.
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
    public static int[][] zeroMatrix(int height, int width) throws IllegalArgumentException {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("A matrix must have positive dimensions!");
        }
        int[][] zeros = new int[height][width];
        // Ei luoteta oletusarvoihin, vaikka ehkä voisi.
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
    public static double[][] zeroMatrixDbl(int height, int width) throws IllegalArgumentException {
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
    
    /**
     * Luo matriisin, jonka alkiona on riveittäin juokseva alkion "järjestysluku".
     * Esim | 1, 2|
     *      | 3, 4|
     * Sopii vaikkapa testailuun
     * 
     * @param width Matriisin leveys
     * @param height Matriisin korkeus
     * @return Kuvatunkaltainen matriisi
     */
    public static int[][] rangeMatrix(int height, int width) {
        if (width < 0 || height < 0) {
            throw new IllegalArgumentException("A matrix must have positive dimensions!");
        }
        int[][] rangeMatrix = new int[height][width];
        int currentNum = 1;
        for (int i = 0; i < rangeMatrix.length; i++) {
            for (int j = 0; j < rangeMatrix[0].length; j++) {
                rangeMatrix[i][j] = currentNum;
                currentNum++;
            }
        }
        return rangeMatrix;
    }
    
    public static void main(String[] args) {
        System.out.println(toString(rangeMatrix(0, 5)));
    }
}
