/**
 * @author Marongiu Anais
 */

package models.disease;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;

import models.lifeform.Human;
import models.states.Sick;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import demonstrateur.Frosh;

/**
 * The Class DiseaseTest.
 */
public class DiseaseTest {

    /**
     * Initialisation.
     */
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
        // System.out.println( "Bite" );
    }

    /**
     * Next day_ a$.
     * 
     * @throws Exception
     *             the exception
     */
    @Test
    public void nextDay_A$( ) throws Exception {
        new Frosh( );

        final Human hum = new Human( 2, 2 );
        hum.setStates( new Sick( hum ) );

        final H1N1 h = new H1N1( hum );
        h.setDayBeforeNextState( 3 );
        hum.setDisease( h );

        Assert.assertEquals( 3, h.getIncubationTime( ) );
        Assert.assertEquals( 100, h.getMortality( ) );
        Assert.assertEquals( 4, h.getRecoveryTime( ) );
        Assert.assertEquals( 10, h.getContagiousTime( ) );

        // On regarde le temps avant le prochain état
        Assert.assertEquals( 3, ( int ) h.getDayBeforeNextState( ) );

        // On passe au jour suivant
        h.nextDay( );

        // On vérifie que le temps avant le prochain état s'est décrémentée
        Assert.assertEquals( 2, ( int ) h.getDayBeforeNextState( ) );

        // On vérifie que les autres propriétés n'ont pas bougées
        Assert.assertEquals( 3, h.getIncubationTime( ) );
        Assert.assertEquals( 100, h.getMortality( ) );
        Assert.assertEquals( 4, h.getRecoveryTime( ) );
        Assert.assertEquals( 10, h.getContagiousTime( ) );

        // --------------------------

        final Human hum2 = new Human( 2, 2 );
        hum2.setStates( new Sick( hum2 ) );

        final H5N1 h5 = new H5N1( hum2 );
        h5.setDayBeforeNextState( 5 );
        hum2.setDisease( h );

        Assert.assertEquals( 3, h5.getIncubationTime( ) );
        Assert.assertEquals( 100, h5.getMortality( ) );
        Assert.assertEquals( 4, h5.getRecoveryTime( ) );
        Assert.assertEquals( 10, h5.getContagiousTime( ) );

        Assert.assertEquals( 5, ( int ) h5.getDayBeforeNextState( ) );
        h5.nextDay( );
        h5.nextDay( );
        Assert.assertEquals( 3, ( int ) h5.getDayBeforeNextState( ) );

        h5.nextDay( );
        h5.nextDay( );
        h5.nextDay( );
        Assert.assertEquals( 0, ( int ) h5.getDayBeforeNextState( ) );

        Assert.assertEquals( 3, h5.getIncubationTime( ) );
        Assert.assertEquals( 100, h5.getMortality( ) );
        Assert.assertEquals( 4, h5.getRecoveryTime( ) );
        Assert.assertEquals( 10, h5.getContagiousTime( ) );

        // --------------------------

    }

}
