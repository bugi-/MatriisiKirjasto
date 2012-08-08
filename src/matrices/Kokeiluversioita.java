package matrices;

/**
 * Erilaista kokeilua. Ei arvosteltavaksi.
 * 
 * @author Bugi
 */
public class Kokeiluversioita {
    
    //naiivi, en keksi heti optimointeja
    public static int[][] MTranspose(int[][] matrix) {
        int[][] transposed = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        
        return transposed;
    }
    
    //naiivi
    public static int[][] MMult(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < result.length ; i++) {
            for (int j = 0; j < result[0].length; j++) {
                /* 
                 * Lasketaan tulosmatriisin kukin alkio kaavasta C_ij = sum(A_ik * B_kj), k = 1, m
                 * Tässä m on ensimmäisen matriisin leveys ja toisen korkeus ja suoritettava laskutoimitus AB = C
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
    
    
    
    public static void main(String[] args) {
        int[][] range = Matrix.rangeMatrix(5,3);
        int[][] unit  = Matrix.identityMatrix(5);
        int[][] prod  = MMult(unit, range);
        System.out.println(Matrix.toString(prod));
    }
}
