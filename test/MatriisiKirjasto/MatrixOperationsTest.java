package MatriisiKirjasto;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import MatriisiKirjasto.virheet.MatrixDimensionException;
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

    /**
     * Test of MTranspose method, of class MatrixOperations.
     */
    @Test
    public void testMTranspose() {
        int[][] matrix = Matrices.rangeMatrix(2,3);
        assertArrayEquals(new int[][]{{1,4},{2,5},{3,6}},MatrixOperations.MTranspose(matrix));
        double[][] matr = Matrices.identityMatrixDbl(4);
        assertArrayEquals(matr, MatrixOperations.MTranspose(matr));
    }

    /**
     * Test of MAdd method, of class MatrixOperations.
     */
    @Test
    public void testMAdd_intArrArr_doubleArrArr() throws Exception {
        // Kopioitu toimivasta
    }

    /**
     * Test of MAdd method, of class MatrixOperations.
     */
    @Test
    public void testMAdd_doubleArrArr_intArrArr() throws Exception {
        // Kopioitu toimivasta
    }

    /**
     * Test of MMult method, of class MatrixOperations.
     */
    @Test
    public void testMMult_int_intArrArr() {
        int[][] matrix = Matrices.identityMatrix(2);
        assertArrayEquals(new int[][]{{2,0},{0,2}}, MatrixOperations.MMult(2, matrix));
    }

    /**
     * Test of MMult method, of class MatrixOperations.
     */
    @Test
    public void testMMult_double_doubleArrArr() {
        // funktionaalisesti identtinen ylläolevan kanssa.
    }

    /**
     * Test of MMult method, of class MatrixOperations.
     */
    @Test
    public void testMMult_double_intArrArr() {
        // funktionaalisesti identtinen
    }

    /**
     * Test of MMult method, of class MatrixOperations.
     */
    @Test
    public void testMMult_int_doubleArrArr() {
        // funktionaalisesti identtinen
    }

    /**
     * Test of MMult method, of class MatrixOperations.
     */
    @Test
    public void testMMult_intArrArr_intArrArr() throws Exception {
        try {
            int[][] matrix1 = Matrices.identityMatrix(3);
            int[][] matrix2 = Matrices.identityMatrix(2);
            MatrixOperations.MMult(matrix1, matrix2);
            MatrixOperations.MMult(matrix2, matrix1);
            fail();
        }
        catch (MatrixDimensionException e) {
            // Piti tulla virhe
        }
        // Identiteettimatriisilla kertominen ei muuta matriisia
        for (int i = 1; i < 10; i++) {
            int size = i;
            int[][] identity = Matrices.identityMatrix(size);
            int[][] range = Matrices.rangeMatrix(size);
            assertArrayEquals(range, MatrixOperations.MMult(range, identity));
            assertArrayEquals(range, MatrixOperations.MMult(identity, range));
        }
        // Nollalla kertominen tuottaa nollaa
        for (int i = 1; i < 10; i++) {
            int size = i;
            int[][] zero = Matrices.zeroMatrix(size);
            int[][] range = Matrices.rangeMatrix(size);
            assertArrayEquals(zero, MatrixOperations.MMult(range, zero));
            assertArrayEquals(zero, MatrixOperations.MMult(zero, range));
        }
        
        int[][] matrix1 = new int[][]{{-1, -3},{4, -2}};
        int[][] matrix2 = new int[][]{{2,-1,1},{3,4,-4}};
        assertArrayEquals(new int[][]{{-11,-11,11},{2,-12,12}}, MatrixOperations.MMult(matrix1, matrix2));
        
        matrix1 = Matrices.rangeMatrix(2,3);
        matrix2 = new int[][]{{7,8},{9,10},{11,12}};
        assertArrayEquals(new int[][]{{58,64},{139,154}}, MatrixOperations.MMult(matrix1, matrix2));
    }
}
