package MatriisiKirjasto;

/**
 * Erilaista kokeilua. Ei arvosteltavaksi.
 *
 * @author Bugi
 */
public class Kokeiluversioita {

    //naiivi, en keksi heti optimointeja epämääräisen muistinhallinnan takia
    private static int[][] MTranspose(int[][] matrix) {
        if (matrix == null) {
            return null;
        }
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

    //naiivi, mutta ainoa mahdollinen yleisessä tapauksessa
    private static int[][] MMult(int[][] matrix1, int[][] matrix2) {
        if (matrix1 == null || matrix2 == null) {
            return null;
        }
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
                    elementSum += matrix1[i][k] * matrix2[k][j];
                }
                result[i][j] = elementSum;
            }

        }

        return result;
    }

    //naiivi transpoosin avulla
    private static int[][] MMult2(int[][] matrix1, int[][] matrix2) {
        // Otetaan avuksi toisen matriisin transpoosi, jolloin luetaan sarakkeiden sijaan rivejä.
        // Tämä on muistinhallinnan ja lokaaliuden takia nopeampaa.
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
    
    /**
     * Ajaa 
     */
    private static void testaaMatriisikertolaskua() {
        final int sampleSize = 1000;
        final int maxSize = 100;
        
        for (int matrixSize = 0; matrixSize < maxSize; matrixSize += 10) {
            int[][] range = Matrix.rangeMatrix(matrixSize);
            int[][] unit = Matrix.identityMatrix(matrixSize);

            long startTime = System.currentTimeMillis();
            for (int i = 0; i < sampleSize; i++) {
                MMult2(range, unit);
            }
            long finishTime = System.currentTimeMillis();
            System.out.println("Transpoosin avulla: " + (finishTime - startTime) + " ms");

            startTime = System.currentTimeMillis();
            for (int i = 0; i < sampleSize; i++) {
                MMult(range, unit);
            }
            finishTime = System.currentTimeMillis();
            System.out.println("Naiivisti: " + (finishTime - startTime) + " ms");
        }
    }

    public static void main(String[] args) {
        testaaMatriisikertolaskua();
    }
}
