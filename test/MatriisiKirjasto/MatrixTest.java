/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MatriisiKirjasto;

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
     * Test of toString method, of class Matrices.
     */
    @Test
    public void testToString() {
        int[][] nullMatrix = null;
        assertEquals(Matrices.emptyMatrixString, Matrices.toString(nullMatrix));
        int[][] empty = new int[][]{};
        assertEquals(Matrices.emptyMatrixString, Matrices.toString(empty));
        int[][]vector = new int[][]{{1}};
        assertEquals("[ 1 ]", Matrices.toString(vector));
        vector = new int[][]{{1,2,3}};
        assertEquals("[ 1, 2, 3 ]", Matrices.toString(vector));
        int[][] matrix = new int[][]{{1},
                                     {15}};
        assertEquals("|  1 |\n" +
                     "| 15 |", Matrices.toString(matrix));
        matrix = new int[][]{{1, 2},
                                     {3, 10}};
        assertEquals("|  1  2 |\n" +
                     "|  3 10 |", Matrices.toString(matrix));
    }

    /**
     * Test of zeroMatrix method, of class Matrices.
     */
    @Test
    public void testZeroMatrix_int() {
        // Kutsuu seuraavaa metodia, joten toimii, jos sekin toimii.
    }

    /**
     * Test of zeroMatrix method, of class Matrices.
     */
    @Test
    public void testZeroMatrix_int_int() {
        
        int size = -1;
        try {
            Matrices.zeroMatrix(size, 1);
            fail("Should not work with a negative argument!");
        }
        catch (IllegalArgumentException e) {}
        try {
            Matrices.zeroMatrix(1, size);
            fail("Should not work with a negative argument!");
        }
        catch (IllegalArgumentException e) {}
        
        size = 1;
        int[][] exp = new int[][]{{0}};
        int[][] result = Matrices.zeroMatrix(size, size);
        assertArrayEquals(exp, result);
        
        
        int dim1 = 2;
        int dim2 = 1;
        exp = new int[][]{{0},
                          {0}};
        result = Matrices.zeroMatrix(dim1, dim2);
        assertArrayEquals(exp, result);
        exp = new int[][]{{0, 0}};
        result = Matrices.zeroMatrix(dim2, dim1);
        assertArrayEquals(exp, result);
        
        size = 3;
        exp = new int[][]{{0, 0, 0},
                          {0, 0, 0},
                          {0, 0, 0}};
        result = Matrices.zeroMatrix(size, size);
        assertArrayEquals(exp, result);
    }

    /**
     * Test of zeroMatrixDbl method, of class Matrices.
     */
    @Test
    public void testZeroMatrixDbl_int() {
        // Toimii, jos seuraava toimii
    }

    /**
     * Test of zeroMatrixDbl method, of class Matrices.
     */
    @Test
    public void testZeroMatrixDbl_int_int() {

        int size = -1;
        try {
            Matrices.zeroMatrixDbl(size, 1);
            fail("Should not work with a negative argument!");
        }
        catch (IllegalArgumentException e) {
        }
        try {
            Matrices.zeroMatrixDbl(1, size);
            fail("Should not work with a negative argument!");
        }
        catch (IllegalArgumentException e) {
        }

        size = 1;
        double[][] exp = new double[][]{{0}};
        double[][] result = Matrices.zeroMatrixDbl(size, size);
        assertArrayEquals(exp, result);

        int dim1 = 2;
        int dim2 = 1;
        exp = new double[][]{{0},
                             {0}};
        result = Matrices.zeroMatrixDbl(dim1, dim2);
        assertArrayEquals(exp, result);
        exp = new double[][]{{0, 0}};
        result = Matrices.zeroMatrixDbl(dim2, dim1);
        assertArrayEquals(exp, result);

        size = 3;
        exp = new double[][]{{0, 0, 0},
                             {0, 0, 0},
                             {0, 0, 0}};
        result = Matrices.zeroMatrixDbl(size, size);
        assertArrayEquals(exp, result);
    }

    /**
     * Test of identityMatrix method, of class Matrices.
     */
    @Test
    public void testIdentityMatrix() {
        
        int size = -1;
        try {
            Matrices.zeroMatrix(size);
            fail("Should not work with negative argument!");
        }
        catch (IllegalArgumentException e) {}
        
        size = 1;
        int[][] exp = new int[][]{{1}};
        int[][] result = Matrices.identityMatrix(size);
        assertArrayEquals(exp, result);
        
        size = 2;
        exp = new int[][]{{1, 0},
                          {0, 1}};
        result = Matrices.identityMatrix(size);
        assertArrayEquals(exp, result);
        
        size = 3;
        exp = new int[][]{{1, 0, 0},
                          {0, 1, 0},
                          {0, 0, 1}};
        result = Matrices.identityMatrix(size);
        assertArrayEquals(exp, result);
    }

    /**
     * Test of identityMatrixDbl method, of class Matrices.
     */
    @Test
    public void testIdentityMatrixDbl() {
        
        int size = -1;
        try {
            Matrices.zeroMatrix(size);
            fail("Should not work with negative argument!");
        }
        catch (IllegalArgumentException e) {}
        
        size = 1;
        double[][] exp = new double[][]{{1}};
        double[][] result = Matrices.identityMatrixDbl(size);
        assertArrayEquals(exp, result);
        
        size = 2;
        exp = new double[][]{{1, 0},
                          {0, 1}};
        result = Matrices.identityMatrixDbl(size);
        assertArrayEquals(exp, result);
        
        size = 3;
        exp = new double[][]{{1, 0, 0},
                             {0, 1, 0},
                             {0, 0, 1}};
        result = Matrices.identityMatrixDbl(size);
        assertArrayEquals(exp, result);
    }



    /**
     * Test of main method, of class Matrices.
     * Ei testata.
     */
    @Test
    public void testMain() {
        
    }

    /**
     * Test of rangeMatrix method, of class Matrices.
     */
    @Test
    public void testRangeMatrix_int() {
        // Taas testataan vain yleistä versiota
    }

    /**
     * Test of rangeMatrix method, of class Matrices.
     */
    @Test
    public void testRangeMatrix_int_int() {
        
        int size = -1;
        try {
            Matrices.rangeMatrix(size, 1);
            fail("Should not work with negative argument!");
        }
        catch (IllegalArgumentException e) {}
        try {
            Matrices.rangeMatrix(1, size);
            fail("Should not work with negative argument!");
        }
        catch (IllegalArgumentException e) {}
        
        size = 1;
        int[][] exp = new int[][]{{1}};
        int[][] result = Matrices.rangeMatrix(size);
        assertArrayEquals(exp, result);
        
        size = 2;
        exp = new int[][]{{1, 2},
                          {3, 4}};
        result = Matrices.rangeMatrix(size);
        assertArrayEquals(exp, result);
        
        size = 3;
        exp = new int[][]{{1, 2, 3},
                          {4, 5, 6}};
        result = Matrices.rangeMatrix(2,3);
        assertArrayEquals(exp, result);
    }
}
