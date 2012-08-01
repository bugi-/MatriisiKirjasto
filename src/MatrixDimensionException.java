/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Tarkistettava poikkeus, joka heitetään, mikäli metodin käsittelemien matriisien
 * koot eivät täsmää. Matriisien yhteenlaskussa tulee olla täsmälleen samat
 * dimensiot ja kertolaskussa matriisien tulee olla muotoa (n*m)(m*p).
 * @author Bugi
 */
public class MatrixDimensionException extends RuntimeException {

    static final String defaultMessage = "Dimensions of the matrices are incorrect for this operation";

    /**
     * Poikkeuksen luonti oletusviestillä.
     */
    public MatrixDimensionException() {
        super(defaultMessage);
    }

    /**
     * Poikkeuksen luonti omalla viestillä.
     * @param msg the detail message.
     */
    public MatrixDimensionException(String msg) {
        super(msg);
    }
}
