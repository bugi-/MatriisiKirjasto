/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MatriisiKirjasto;

/**
 *
 * @author bugi
 */
public class SingularMatrixException extends Exception {
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
