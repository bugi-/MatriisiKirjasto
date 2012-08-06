package matrices;

/**
 * Erilaista kokeilua. Ei arvosteltavaksi.
 * 
 * @author Bugi
 */
public class Kokeiluversioita {
    
    public static int[][] MTranspose(int[][] matrix) {
        int[][] transposed = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        
        return transposed;
    }
    
    public static void main(String[] args) {
        int[][] unit = Matrix.identityMatrix(5);
        System.out.println(Matrix.toString(MTranspose(unit)));
    }
}
