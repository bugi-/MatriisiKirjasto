package MatriisiKirjasto;

/**
 * Erilaista kokeilua. Ei varsinaisesti arvosteltavaksi,
 * mutta sisältää matriisikertolaskun nopeudentestausohjelman, jonka tulokset sisällytetään palautukseen.
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
    
    /**
     * Testaa vaihtoehtoisia matriisien kertomisalgoritmeja.
     */
    private static void testaaMatriisikertolaskua() {
        final int sampleSize = 1000;
        final int maxSize = 150;
        final int sizeStep = 10;
        
        int[] naiveTimes = new int[maxSize / sizeStep + 1];
        int[] transposedTimes = new int[maxSize / sizeStep + 1];
        
        for (int matrixSize = 10; matrixSize <= maxSize; matrixSize += sizeStep) {
            System.out.println(matrixSize);
            int[][] range = Matrices.rangeMatrix(matrixSize);
            int[][] unit = Matrices.identityMatrix(matrixSize);

            long startTime = System.currentTimeMillis();
            for (int i = 0; i < sampleSize; i++) {
                MMult2(range, unit);
            }
            long finishTime = System.currentTimeMillis();
            transposedTimes[matrixSize / sizeStep] = (int)(finishTime - startTime);

            startTime = System.currentTimeMillis();
            for (int i = 0; i < sampleSize; i++) {
                MMult(range, unit);
            }
            finishTime = System.currentTimeMillis();
            naiveTimes[matrixSize / sizeStep] = (int)(finishTime - startTime);
        }
        System.out.println("Naiivi implementaatio:");
        System.out.println(Matrices.toString(new int[][]{naiveTimes}));
        
        System.out.println("Transpoosin avulla:");
        System.out.println(Matrices.toString(new int[][]{transposedTimes}));
    }

    private static double[][] LUdecomp(double[][] matrix) throws SingularMatrixException{
        final int n = matrix.length;
        int perm = 1;
        final double epsilon = Double.MIN_VALUE;
        double[][] LU = matrix.clone(); // Muodostetaan hajotelma tähän matriisiin. Sekä ala-, että yläkolmiomatriisi voidaan sijoittaa samaan matriisiin, koska toisen näistä diagonaali on aina 1, joten mitään tietoa ei menetetä.
        
        for (int k = 0; k < n; k++) {
            // Haetaan sarakkeen suurin alkio "pivot"-paikalle
            double rowMax = 0;
            int exchangeColumn = k;
            for (int i = k; i < n; i++) {
                if (Math.abs(LU[i][k]) > rowMax) {
                    rowMax = Math.abs(LU[i][k]);
                    exchangeColumn = k;
                }
            }
            if (Math.abs(rowMax) < epsilon) throw new SingularMatrixException(); // Suurinkin on liian lähellä nollaa, joten sillä ei voida jakaa.
            if (exchangeColumn != k) {  // Suoritetaan permutaatio
                perm *= -1;  // Ei tarvita permutaatiomatriisia, sillä tarvitsee vain tietää tehtyjen rivinvaihtojen määrä.
                for (int i = 0; i < n; i++) {
                    double temp = LU[i][k];
                    LU[i][k] = LU[i][exchangeColumn];
                    LU[i][exchangeColumn] = temp;
                }
            }
            for (int i = k + 1; i < n; i++) {
                LU[i][k] /= LU[k][k];
                for (int j = k + 1; j < n; j++) {
                    LU[i][j] -= LU[i][k] * LU[k][j];
                }
            }
        }
        
        return LU;
    }
    
    public static void main(String[] args) {
        double[][] matrix = new double[][] {{2,3,1,5},
                                            {6,13,5,19},
                                            {2,19,10,23},
                                            {4,10,11,31}};
        try {
            matrix = LUdecomp(matrix);
        }
        catch (SingularMatrixException e) {
            
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
