/**
 * @author Martini Didier
 */

package models;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import lib.ArrayUtils;
import models.lifeform.Human;
import models.lifeform.animal.Pig;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import demonstrateur.Frosh;

public class GridTest {

    @Test
    public void hasEnded_A$( ) throws Exception {

        final Grid target = new Grid( );
        Lifeform[ ][ ] origine = Grid.getGrid( );
        origine = new Lifeform[ 2 ][ 2 ];
        origine[ 0 ][ 0 ] = null;
        origine[ 1 ][ 1 ] = null;
        origine[ 0 ][ 1 ] = new Pig( 0, 1 );
        origine[ 1 ][ 0 ] = null;
        Grid.setGrid( origine );

        final boolean actual = target.hasEnded( );
        final boolean expected = true;
        Assert.assertThat( actual, CoreMatchers.equalTo( expected ) );

    }

    // Methode d'initilisation (chargement du fichier de configuration)
    @Before
    public void initialisation( ) {

        try {
            final Method m = Frosh.class.getDeclaredMethod( "loadConfigFile",
                    Path.class );
            m.setAccessible( true );
            m.invoke( null, Paths.get( Frosh.FOLDER, Frosh.CONFIG ) );

        } catch( IllegalAccessException | IllegalArgumentException
                | InvocationTargetException | NoSuchMethodException
                | SecurityException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace( );
        }
    }

    @Test
    public void move_A$Cardinal$int$int( ) throws Exception {

        final Grid grid = new Grid( );

        // Recuperation par reference de la grille, et creation d'une nouvelle
        // plus simple et non aleatoire
        Lifeform[ ][ ] origine = Grid.getGrid( );
        origine = new Lifeform[ 2 ][ 2 ];
        origine[ 0 ][ 0 ] = null;
        origine[ 1 ][ 1 ] = null;
        origine[ 0 ][ 1 ] = new Human( 0, 1 );
        origine[ 1 ][ 0 ] = null;
        Grid.setGrid( origine );

        // Clonage de la grille et modification de celle ci (deplacement de la
        // forme de vie vers le nord de la grille
        final Lifeform[ ][ ] etat1 = ArrayUtils.clone2DArray( origine );

        etat1[ 0 ][ 0 ] = etat1[ 0 ][ 1 ];
        etat1[ 0 ][ 0 ].setLine( 0 );
        etat1[ 0 ][ 1 ] = null;

        // On teste le deplacement vers le nord de notre forme de vie avec notre
        // methode
        Grid.move( Cardinal.SOUTH, 0, 1 );
        origine = Grid.getGrid( );

        final boolean equals = Arrays.deepEquals( origine, etat1 );

        // On verifie si les resultats sont bien egaux
        Assert.assertThat( true, CoreMatchers.equalTo( equals ) );

    }

    @Test
    public void nextDay_A$( ) throws Exception {

    }

}
