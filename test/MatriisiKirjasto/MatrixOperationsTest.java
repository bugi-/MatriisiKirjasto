package MatriisiKirjasto;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Bugi
 */
public class MatrixOperationsTest {
    
    public MatrixOperationsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of MAdd method, of class MatrixOperations.
     */
    @Test
    public void testMAdd_intArrArr_intArrArr() throws Exception {
        int[][] zeros = Matrices.zeroMatrix(2, 3);
        assertArrayEquals(zeros, MatrixOperations.MAdd(zeros, zeros));
        int[][] matr = new int[][]{{1,2,3},
                                   {4,5,6}};
        assertArrayEquals(matr, MatrixOperations.MAdd(matr, zeros));
        assertArrayEquals(matr, MatrixOperations.MAdd(zeros, matr)); // Varmistetaan kommutatiivisuus
        int[][] doubled = new int[][]{{2, 4, 6},
                                      {8,10,12}};
        assertArrayEquals(doubled, MatrixOperations.MAdd(matr, matr));
        
    }

    /**
     * Test of MAdd method, of class MatrixOperations.
     */
    // Seuraavan testin läpäisy ei ole itsestäänselvää kaikilla alustoilla numeeristen epätarkkuuksien vuoksi.
    // Toimii testatulla koneella.
    @Test
    public void testMAdd_doubleArrArr_doubleArrArr() throws Exception {
        double[][] zeros = Matrices.zeroMatrixDbl(2, 3);
        assertArrayEquals(zeros, MatrixOperations.MAdd(zeros, zeros));
        double[][] matr = new double[][]{{1,2,3},
                                         {4,5,6}};
        assertArrayEquals(matr, MatrixOperations.MAdd(matr, zeros));
        assertArrayEquals(matr, MatrixOperations.MAdd(zeros, matr)); // Varmistetaan kommutatiivisuus
        double[][] doubled = new double[][]{{2, 4, 6},
                                            {8,10,12}};
        
        assertArrayEquals(doubled, MatrixOperations.MAdd(matr, matr));
    }
}
