/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MatriisiKirjasto.virheet;

/**
 * Toimii erityisten matriisivirheiden yläluokkana.
 * 
 * @author bugi
 */
public class MatrixException extends Exception {
    
    public MatrixException() {
        super();
    }
    
    public MatrixException(String msg) {
        super(msg);
    }
    
}
