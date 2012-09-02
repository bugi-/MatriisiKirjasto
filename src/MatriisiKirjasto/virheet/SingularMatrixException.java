/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MatriisiKirjasto.virheet;

/**
 * Käytetään, mikäli käsiteltävä matriisi on singulaarinen operaation vaatiessa ei-singulaarissta.
 * 
 * @author bugi
 */
public class SingularMatrixException extends MatrixException {
    static final String defaultMessage = "The matrix is singular!";

    /**
     * Poikkeuksen luonti oletusviestillä.
     */
    public SingularMatrixException() {
        super(defaultMessage);
    }

    /**
     * Poikkeuksen luonti omalla viestillä.
     * @param msg the detail message.
     */
    public SingularMatrixException(String msg) {
        super(msg);
    }
}
