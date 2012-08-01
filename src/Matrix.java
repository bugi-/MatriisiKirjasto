
public class Matrix {

    private final double[][] matrix;

    /**
     * Luo uuden matriisin int-listasta
     *
     * @param vector
     */
    public Matrix(int[] vector) {
        matrix = new double[1][vector.length];
        for (int i = 0; i < vector.length; i++) {
            matrix[0][i] = vector[i];
        }
    }

    /**
     * Luo uuden matriisin float-listasta
     *
     * @param vector
     */
    public Matrix(float[] vector) {
        matrix = new double[1][vector.length];
        for (int i = 0; i < vector.length; i++) {
            matrix[0][i] = vector[i];
        }
    }

    /**
     * Luo uuden matriisin double-listasta
     *
     * @param vector
     */
    public Matrix(double[] vector) {
        matrix = new double[1][vector.length];
        for (int i = 0; i < vector.length; i++) {
            matrix[0][i] = vector[i];
        }
    }

    @Override
    public String toString() {
        if (matrix.length <= 1) {
            String result = "[";
            for (int i = 0; i < matrix[0].length; i++) {
                result = result.concat(" " + matrix[0][i]);
            }
            result = result.concat(" ]");
            return result;
        }
        else {
            return "";
        }
    }
    
    public static void main(String[] args) {
        Matrix matriisi = new Matrix(new int[]{});
        System.out.println(matriisi);
    }
}
