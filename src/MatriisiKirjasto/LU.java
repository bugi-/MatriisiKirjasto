/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MatriisiKirjasto;

import MatriisiKirjasto.virheet.MatrixDimensionException;
import MatriisiKirjasto.virheet.SingularMatrixException;

/**
 * Sisältää yhden LU-hajotelman
 *
 * @author bugi
 */
public class LU {

    private int perm;  // 1 tai -1, käytetään determinantin laskemisessa
    private int[] permutationMatrix;  // Jokaiselle alkiolle a_i paikassa i, hajotelman i:s rivi on alkuperäisen matriisin a_i:s rivi.
    private double[][] LU;  // Sisältää itse hajotelman.
    
    public int getPerm() {
        return perm;
    }
    
    public int[] getPermutationMatrix() {
        return permutationMatrix;
    }

    public double[][] getLU() {
        return LU;
    }
    
    /**
     * Muuttaa annetun int-matriisin double-matriisiksi.
     * 
     * @param matrix Muutettava matriisi
     * @return Annettu matriisi doublena
     */
    private static double[][] intToDoubleMatrix(int[][] matrix) {
        double[][] dblMatrix = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dblMatrix[i][j] = matrix[i][j];
            }
        }
        return dblMatrix;
    }
    
    /**
     * Luo LU-hajotelman syötteenä annetulle matriisille.
     * 
     * @param matrix Matriisi, josta hajotelma muodostetaan.
     * @throws SingularMatrixException Matriisin ollessa singulaarinen
     * @throws MatrixDimensionException Matriisin ollessa muu kuin neliö.
     */
    public LU(int[][] matrix) throws SingularMatrixException, MatrixDimensionException {
        // Muutetaan int-matriisi double-matriisiksi ja syötetään se double-konstruktoriin.
        // Hajotelman teossa jaetaan alkioilla, jolloin tulos ei välttämättä pysy kokonaislukuna.
        this(intToDoubleMatrix(matrix));
    }
    
    /**
     * Luo LU-hajotelman syötteenä annetulle matriisille.
     * 
     * @param matrix Matriisi, josta hajotelma muodostetaan.
     * @throws SingularMatrixException Matriisin ollessa singulaarinen.
     * @throws MatrixDimensionException Matriisin ollessa muu kuin neliö.
     */
    public LU(double[][] matrix) throws SingularMatrixException, MatrixDimensionException {
        if (matrix.length != matrix[0].length) throw new MatrixDimensionException("Can not create LU decomposition of a non square matrix!");
        final int n = matrix.length;
        int perm = 1;  // Tähän muuttujaan tulee tehtyjen permutaatioiden perusteella 1 tai -1
        int[] permutationMatrix = new int[n];  // Permutaatiomatriisi voidaan ilmaista listalla, jossa i:s alkio kertoo, mikä rivi on vaihdettu i:ksi.
        for (int i = 0; i < n; i++) {
            permutationMatrix[i] = i;
        }
        final double epsilon = Double.MIN_VALUE;
        double[][] LU = matrix.clone(); // Muodostetaan hajotelma tähän matriisiin. Sekä ala-, että yläkolmiomatriisi voidaan sijoittaa samaan matriisiin, koska toisen näistä diagonaali on aina 1, joten mitään tietoa ei menetetä.

        for (int k = 0; k < n; k++) {
            // Haetaan sarakkeen suurin alkio "pivot"-paikalle.
            // Tämä vahvistaa numeerista vakautta, koska kyseisellä alkiolla jaetaan.
            double rowMax = 0;
            int exchangeColumn = k;
            for (int i = k; i < n; i++) {
                if (Math.abs(LU[i][k]) > rowMax) {
                    rowMax = Math.abs(LU[i][k]);
                    exchangeColumn = i;
                }
            }
            if (Math.abs(rowMax) < epsilon) {
                throw new SingularMatrixException(); // Suurinkin on liian lähellä nollaa, joten sillä ei voida jakaa.
            }            // Suoritetaan permutaatio
            if (exchangeColumn != k) {
                // Laitetaan permutaatio talteen.
                int tempPerm = permutationMatrix[k];
                permutationMatrix[k] = permutationMatrix[exchangeColumn];
                permutationMatrix[exchangeColumn] = tempPerm;
                perm *= -1;
                for (int i = 0; i < n; i++) {
                    double temp = LU[k][i];
                    LU[k][i] = LU[exchangeColumn][i];
                    LU[exchangeColumn][i] = temp;
                }
            }
            for (int i = k + 1; i < n; i++) {
                LU[i][k] /= LU[k][k];
                for (int j = k + 1; j < n; j++) {
                    LU[i][j] -= LU[i][k] * LU[k][j];
                }
            }
        }
        this.perm = perm;
        this.permutationMatrix = permutationMatrix;
        this.LU = LU;
    }
    
    /**
     * Palauttaa matriisin determinantin.
     * 
     * @return Determinantin arvo
     */
    public double determinant() {
        // Matematiikka kertoo determinantin arvon olevan diagonaalialkioiden tulo kerrottuna perm:llä.
        double det = perm;
        for (int i = 0; i < LU.length; i++) {
            det *= LU[i][i];
        }
        return det;
    }
    
//        public double[] solve(double[] b) throws MatrixDimensionException {
//        try {
//            int n = LU.length;
//            if (b.length != n) {
//                throw new MatrixDimensionException("Matrix must be NxN and b must have length N.");
//            }
//            
//            return null;
//        }
//        catch (NullPointerException e) {
//            return null;
//        }
//    }
}
