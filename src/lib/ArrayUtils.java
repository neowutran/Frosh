
package lib;

import models.Lifeform;

/**
 * Created by draragar on 17/11/13.
 */
public class ArrayUtils {

    public static <T> T[ ][ ] clone2DArray( T[ ][ ] array ) {
        int rows = array.length;
        T[ ][ ] newArray = array.clone( );
        for( int row = 0; row < rows; row++ ) {
            newArray[ row ] = array[ row ].clone( );
        }

        return newArray;
    }
    
    private ArrayUtils(){
        
    }

    /*
     * public static void printLifeform( Lifeform[ ][ ] toPrint ) {
     * 
     * System.out.println( "==== START ARRAY PRINT ====" ); for( int i = 0; i <
     * toPrint.length; i++ ) { for( int j = 0; j < toPrint.length; j++ ) {
     * 
     * System.out.println( "======START PRINT=====" ); System.out.println(
     * "column: " + i + "; line:" + j ); System.out.println( toPrint[ i ][ j ]
     * ); System.out.println( "======END PRINT=====" );
     * 
     * } } System.out.println( "==== END ARRAY PRINT ====" );
     * 
     * }
     */
}
