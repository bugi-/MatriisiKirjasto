
public class Matrix {

    private boolean isVector = true; // Kertoo, käsitelläänkö matriisia vektorina vai ei.
    private double[][] matrix;
    private double[] vector;

    /**
     * Luo uuden matriisin int-listasta
     *
     * @param vector
     */
    public Matrix(int[] vector) {
        this.vector = new double[vector.length];
        for (int i = 0; i < vector.length; i++) {
            this.vector[i] = vector[i];
        }
    }

    /**
     * Luo uuden matriisin float-listasta
     *
     * @param vector
     */
    public Matrix(float[] vector) {
        this.vector = new double[vector.length];
        for (int i = 0; i < vector.length; i++) {
            this.vector[i] = vector[i];
        }
    }

    /**
     * Luo uuden matriisin double-listasta
     *
     * @param vector
     */
    public Matrix(double[] vector) {
        this.vector = new double[vector.length];
        System.arraycopy(vector, 0, this.vector, 0, vector.length);
    }

    @Override
    public String toString() {
        if (isVector) {
            String result = "[";
            for (int i = 0; i < vector.length; i++) {
                result = result.concat(" " + vector[i]);
            }
            result = result.concat(" ]");
            return result;
        }
        else {
            return "";
        }
    }
    
    public static void main(String[] args) {
        Matrix matriisi = new Matrix(new double[]{});
        System.out.println(matriisi);
    }
}
