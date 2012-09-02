/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MatriisiKirjasto;

import MatriisiKirjasto.virheet.MatrixDimensionException;
import MatriisiKirjasto.virheet.MatrixException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author bugi
 */
public class LUTest {
    static final double delta = 0.0001;
    
    public LUTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of determinant method, of class LU.
     */
    @Test
    public void testDeterminant() {
        try {
            LU identity = new LU(Matrices.identityMatrix(100));
            assertEquals(1, identity.determinant(), delta); // Yksikkömatriisin determinantti on 1
            int[][] matrix = new int[][] {{3,2,-1,4},  // det = -418
                                          {2,1,5,7},
                                          {0,5,2,-6},
                                          {-1,2,1,0}};
            LU det = new LU(matrix);
            assertEquals(det.determinant(), -418, delta);
            matrix = new int[][]{{2,-2,0},{-1,5,1},{3,4,5}};
            det = new LU(matrix);
            assertEquals(det.determinant(), 26, delta);
            matrix = new int[][]{{3,1,8},{2,-5,4},{-1,6,-2}};
            det = new LU(matrix);
            assertEquals(det.determinant(), 14, delta);
            
        }
        catch (MatrixException e) {
            fail();
        }
    }



    /**
     * Test of solve method, of class LU.
     */
    @Test
    public void testSolve() throws Exception {
        double[][] matrix = new double[][]{{2,-3},{4,1}};
        int[][] identity = Matrices.identityMatrix(5);
        try{
            LU decomp = new LU(identity);
            double[] x = decomp.solve(new double[]{1,1,1,1,1});
            assertArrayEquals(new double[]{1,1,1,1,1}, x, delta);
            decomp = new LU(matrix);
            x = decomp.solve(new double[]{-2,24});
            for (int i = 0; i < x.length; i++) {
                System.out.print(x[i] + " ");
            }
        }
        catch (MatrixException e) {
            fail();
        }
    }
}
