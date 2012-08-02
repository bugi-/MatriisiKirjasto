/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import matrices.Matrix;
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
public class MatrixTest {
    
    public MatrixTest() {
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
     * Test of printMatrix method, of class Matrix.
     */
    @Test
    public void testPrintMatrix() {
        fail("No one can be told what the Matrix is.");
    }

    /**
     * Test of zeroMatrix method, of class Matrix.
     */
    @Test
    public void testZeroMatrix() {
        // Tyhjä
        int size = 0;
        int[][] exp = new int[][]{};
        int[][] result = Matrix.zeroMatrix(size);
        assertArrayEquals(exp, result);
        
        size = -1;
        try {
            Matrix.zeroMatrix(size);
            fail("Should not work with negative argument!");
        }
        catch (IllegalArgumentException e) {}
        
        size = 1;
        exp = new int[][]{{0}};
        result = Matrix.zeroMatrix(size);
        assertArrayEquals(exp, result);
        
        size = 2;
        exp = new int[][]{{0, 0},
                          {0, 0}};
        result = Matrix.zeroMatrix(size);
        assertArrayEquals(exp, result);
        
        size = 3;
        exp = new int[][]{{0, 0, 0},
                          {0, 0, 0},
                          {0, 0, 0}};
        result = Matrix.zeroMatrix(size);
        assertArrayEquals(exp, result);
    }

    /**
     * Test of identityMatrix method, of class Matrix.
     */
    @Test
    public void testIdentityMatrix() {
        int size = 0;
        int[][] exp = new int[][]{};
        int[][] result = Matrix.identityMatrix(size);
        assertArrayEquals(exp, result);
        
        size = -1;
        try {
            Matrix.zeroMatrix(size);
            fail("Should not work with negative argument!");
        }
        catch (IllegalArgumentException e) {}
        
        size = 1;
        exp = new int[][]{{1}};
        result = Matrix.identityMatrix(size);
        assertArrayEquals(exp, result);
        
        size = 2;
        exp = new int[][]{{1, 0},
                          {0, 1}};
        result = Matrix.identityMatrix(size);
        assertArrayEquals(exp, result);
        
        size = 3;
        exp = new int[][]{{1, 0, 0},
                          {0, 1, 0},
                          {0, 0, 1}};
        result = Matrix.identityMatrix(size);
        assertArrayEquals(exp, result);
    }
}
