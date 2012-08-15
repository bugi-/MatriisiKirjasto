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
     * Test of toString method, of class Matrix.
     */
    @Test
    public void testToString() {
        int[][] nullMatrix = null;
        assertEquals(Matrix.emptyMatrixString, Matrix.toString(nullMatrix));
        int[][] empty = new int[][]{};
        assertEquals(Matrix.emptyMatrixString, Matrix.toString(empty));
        int[][]vector = new int[][]{{1}};
        assertEquals("[ 1 ]", Matrix.toString(vector));
        vector = new int[][]{{1,2,3}};
        assertEquals("[ 1, 2, 3 ]", Matrix.toString(vector));
        int[][] matrix = new int[][]{{1},
                                     {15}};
        assertEquals("|  1 |\n" +
                     "| 15 |", Matrix.toString(matrix));
        matrix = new int[][]{{1, 2},
                                     {3, 10}};
        assertEquals("|  1  2 |\n" +
                     "|  3 10 |", Matrix.toString(matrix));
    }

    /**
     * Test of zeroMatrix method, of class Matrix.
     */
    @Test
    public void testZeroMatrix_int() {
        // Kutsuu seuraavaa metodia, joten toimii, jos sekin toimii.
    }

    /**
     * Test of zeroMatrix method, of class Matrix.
     */
    @Test
    public void testZeroMatrix_int_int() {
        // Tyhjä
        int size = 0;
        int[][] exp = new int[][]{};
        int[][] result = Matrix.zeroMatrix(size, size);
        assertArrayEquals(exp, result);
        
        size = -1;
        try {
            Matrix.zeroMatrix(size, 1);
            fail("Should not work with a negative argument!");
        }
        catch (IllegalArgumentException e) {}
        try {
            Matrix.zeroMatrix(1, size);
            fail("Should not work with a negative argument!");
        }
        catch (IllegalArgumentException e) {}
        
        size = 1;
        exp = new int[][]{{0}};
        result = Matrix.zeroMatrix(size, size);
        assertArrayEquals(exp, result);
        
        int dim1 = 2;
        int dim2 = 0;
        exp = new int[][]{{},
                          {}};
        result = Matrix.zeroMatrix(dim1, dim2);
        assertArrayEquals(exp, result);
        exp = new int[][]{};
        result = Matrix.zeroMatrix(dim2, dim1);
        assertArrayEquals(exp, result);
        
        dim1 = 2;
        dim2 = 1;
        exp = new int[][]{{0},
                          {0}};
        result = Matrix.zeroMatrix(dim1, dim2);
        assertArrayEquals(exp, result);
        exp = new int[][]{{0, 0}};
        result = Matrix.zeroMatrix(dim2, dim1);
        assertArrayEquals(exp, result);
        
        size = 3;
        exp = new int[][]{{0, 0, 0},
                          {0, 0, 0},
                          {0, 0, 0}};
        result = Matrix.zeroMatrix(size, size);
        assertArrayEquals(exp, result);
    }

    /**
     * Test of zeroMatrixDbl method, of class Matrix.
     */
    @Test
    public void testZeroMatrixDbl_int() {
        // Toimii, jos seuraava toimii
    }

    /**
     * Test of zeroMatrixDbl method, of class Matrix.
     */
    @Test
    public void testZeroMatrixDbl_int_int() {
        // Tyhjä
        int size = 0;
        double[][] exp = new double[][]{};
        double[][] result = Matrix.zeroMatrixDbl(size, size);
        assertArrayEquals(exp, result);

        size = -1;
        try {
            Matrix.zeroMatrixDbl(size, 1);
            fail("Should not work with a negative argument!");
        }
        catch (IllegalArgumentException e) {
        }
        try {
            Matrix.zeroMatrixDbl(1, size);
            fail("Should not work with a negative argument!");
        }
        catch (IllegalArgumentException e) {
        }

        size = 1;
        exp = new double[][]{{0}};
        result = Matrix.zeroMatrixDbl(size, size);
        assertArrayEquals(exp, result);

        int dim1 = 2;
        int dim2 = 0;
        exp = new double[][]{{},
                             {}};
        result = Matrix.zeroMatrixDbl(dim1, dim2);
        assertArrayEquals(exp, result);
        exp = new double[][]{};
        result = Matrix.zeroMatrixDbl(dim2, dim1);
        assertArrayEquals(exp, result);

        dim1 = 2;
        dim2 = 1;
        exp = new double[][]{{0},
                             {0}};
        result = Matrix.zeroMatrixDbl(dim1, dim2);
        assertArrayEquals(exp, result);
        exp = new double[][]{{0, 0}};
        result = Matrix.zeroMatrixDbl(dim2, dim1);
        assertArrayEquals(exp, result);

        size = 3;
        exp = new double[][]{{0, 0, 0},
                             {0, 0, 0},
                             {0, 0, 0}};
        result = Matrix.zeroMatrixDbl(size, size);
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

    /**
     * Test of identityMatrixDbl method, of class Matrix.
     */
    @Test
    public void testIdentityMatrixDbl() {
        int size = 0;
        double[][] exp = new double[][]{};
        double[][] result = Matrix.identityMatrixDbl(size);
        assertArrayEquals(exp, result);
        
        size = -1;
        try {
            Matrix.zeroMatrix(size);
            fail("Should not work with negative argument!");
        }
        catch (IllegalArgumentException e) {}
        
        size = 1;
        exp = new double[][]{{1}};
        result = Matrix.identityMatrixDbl(size);
        assertArrayEquals(exp, result);
        
        size = 2;
        exp = new double[][]{{1, 0},
                          {0, 1}};
        result = Matrix.identityMatrixDbl(size);
        assertArrayEquals(exp, result);
        
        size = 3;
        exp = new double[][]{{1, 0, 0},
                             {0, 1, 0},
                             {0, 0, 1}};
        result = Matrix.identityMatrixDbl(size);
        assertArrayEquals(exp, result);
    }



    /**
     * Test of main method, of class Matrix.
     * Ei testata.
     */
    @Test
    public void testMain() {
        
    }

    /**
     * Test of rangeMatrix method, of class Matrix.
     */
    @Test
    public void testRangeMatrix_int() {
        // Taas testataan vain yleistä versiota
    }

    /**
     * Test of rangeMatrix method, of class Matrix.
     */
    @Test
    public void testRangeMatrix_int_int() {
        int size = 0;
        int[][] exp = new int[][]{};
        int[][] result = Matrix.rangeMatrix(size, size);
        assertArrayEquals(exp, result);
        
        size = -1;
        try {
            Matrix.rangeMatrix(size, 1);
            fail("Should not work with negative argument!");
        }
        catch (IllegalArgumentException e) {}
        try {
            Matrix.rangeMatrix(1, size);
            fail("Should not work with negative argument!");
        }
        catch (IllegalArgumentException e) {}
        
        size = 1;
        exp = new int[][]{{1}};
        result = Matrix.identityMatrix(size);
        assertArrayEquals(exp, result);
        
        size = 2;
        exp = new int[][]{{1, 2},
                          {3, 4}};
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
