
/**
 *
 * @author Bugi
 */
public class MatrixOperations {
    
    /**
     * Suorittaa matriisiyhteenlaskun annetuille matriiseille.
     * @param matr1 Ensimmäinen operoitava matriisi
     * @param matr2 Toinen operoitava matriisi
     * @return Yhteenlaskun tulosmatriisi
     * @throws MatrixDimensionException Mikäli dimensiot eivät täsmää (oltava täsmälleen samat).
     */
    public static int[][] MAdd(int[][] matr1, int[][] matr2) throws MatrixDimensionException{
        if (matr1.length != matr2.length) {
            throw new MatrixDimensionException("Matrices need to have same dimensions in addition!");
        }
        try {  // Ei tarkisteta vaikeammin saavutettavia dimensioita (jokaisen listan pituutta) etukäteen.
            int[][] result = matr1.clone();  // Nopeutetaan laskemista ottamalla pohjaksi toinen matriiseista.
            for (int i = 0; i < matr1.length; i++) {
                for (int j = 0; j < matr1[0].length; j++) {
                    result[i][j] += matr2[i][j];  // matr1:n arvo on jo tulostaulussa,
                }
            }
            return result;
        }
        catch (ArrayIndexOutOfBoundsException e){
            throw new MatrixDimensionException("Matrices need to have same dimensions in addition!");
        }
    }
    
    /**
     * Suorittaa matriisiyhteenlaskun annetuille matriiseille.
     * @param matr1 Ensimmäinen operoitava matriisi
     * @param matr2 Toinen operoitava matriisi
     * @return Yhteenlaskun tulosmatriisi
     * @throws MatrixDimensionException Mikäli dimensiot eivät täsmää (oltava täsmälleen samat).
     */
    public static double[][] MAdd(double[][] matr1, double[][] matr2) throws MatrixDimensionException{
        if (matr1.length != matr2.length) {
            throw new MatrixDimensionException("Matrices need to have same dimensions in addition!");
        }
        try {  // Ei tarkisteta vaikeammin saavutettavia dimensioita (jokaisen listan pituutta) etukäteen.
            double[][] result = matr1.clone();  // Nopeutetaan laskemista ottamalla pohjaksi toinen matriiseista.
            for (int i = 0; i < matr1.length; i++) {
                for (int j = 0; j < matr1[0].length; j++) {
                    result[i][j] += matr2[i][j];  // matr1:n arvo on jo tulostaulussa.
                }
            }
            return result;
        }
        catch (ArrayIndexOutOfBoundsException e){
            throw new MatrixDimensionException("Matrices need to have same dimensions in addition!");
        }
    }
    

}
