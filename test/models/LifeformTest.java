/**
 * @author Lissillour Benjamin
 */

package models;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import models.disease.Disease;
import models.disease.H1N1;
import models.disease.H5N1;
import models.lifeform.Human;
import models.lifeform.animal.Pig;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import demonstrateur.Frosh;

/**
 * The Class LifeformTest.
 */
public class LifeformTest {

    /**
     * Equals.
     * 
     * @throws Exception
     *             the exception
     */
    @Test
    public void equals( ) throws Exception {

        final Human human1 = new Human( 0, 0 );
        final Human human2 = new Human( 0, 0 );
        final Human human3 = new Human( 1, 0 );
        final Pig pig1 = new Pig( 0, 0, false );
        final Pig pig2 = new Pig( 1, 1, false );
        final Pig pig3 = new Pig( 0, 0, true );

        MatcherAssert.assertThat( human2, CoreMatchers.equalTo( human1 ) );
        MatcherAssert.assertThat( human2,
                CoreMatchers.not( CoreMatchers.equalTo( human3 ) ) );
        MatcherAssert.assertThat( human2,
                CoreMatchers.not( CoreMatchers.equalTo( ( Lifeform ) pig1 ) ) );
        MatcherAssert.assertThat( pig1,
                CoreMatchers.not( CoreMatchers.equalTo( pig2 ) ) );
        MatcherAssert.assertThat( pig3,
                CoreMatchers.not( CoreMatchers.equalTo( pig2 ) ) );
        MatcherAssert.assertThat( pig3,
                CoreMatchers.not( CoreMatchers.equalTo( pig1 ) ) );

    }

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
     * Checks if is immune_ a$ disease.
     * 
     * @throws Exception
     *             the exception
     */
    @Test
    public void isImmune_A$Disease( ) throws Exception {
    	
		Lifeform pig = new Pig(1, 1);
		Lifeform human = new Human(2, 1);

		Disease dis = new H1N1(pig);
		Disease dis2 = new H5N1(human);

		Assert.assertEquals(false, pig.isImmune(dis));
		Assert.assertEquals(false, human.isImmune(dis));

		List<Disease> listDisease = new ArrayList<>();

		listDisease.add(dis);

		pig.setImmune(listDisease);

		Assert.assertEquals(true, pig.isImmune(dis));
		Assert.assertEquals(false, pig.isImmune(dis2));
    }

    /**
     * Next day_ a$ list$ list.
     * 
     * @throws Exception
     *             the exception
     */
    @Test
    public void nextDay_A$List$List( ) throws Exception {
    	
		/*
		Grid grid = new Grid();
		Lifeform grille[][] = new Lifeform[10][20];

		Human hum = new Human(2, 2);
		Pig pig = new Pig(2, 3);
		Disease dis2 = new H5N1(pig);
		grille[1][2] = hum;
		grille[1][3] = pig;
		grid.setGrid(grille);

		List<Lifeform> neighbors = new ArrayList<>();
		List<Cardinal> freespace = new ArrayList<>();
		neighbors.add(pig);
		freespace.add(Cardinal.SOUTH);

		hum.nextDay(neighbors, freespace);
		Assert.assertEquals(2, hum.getLine());
		Assert.assertEquals(3, hum.getColumn());
		Assert.assertEquals("H5N1", hum.getDisease().getDiseaseType());
		*/
    }

    /**
     * Test clone.
     * 
     * @throws Exception
     *             the exception
     */
    @Test
    public void TestClone( ) throws Exception {

        final Human human1 = new Human( 0, 0 );
        final Human human2 = ( Human ) human1.clone( );

        human1.setColumn( 5 );

        MatcherAssert
                .assertThat( human1.getColumn( ), CoreMatchers
                        .not( CoreMatchers.equalTo( human2.getColumn( ) ) ) );

    }

    /**
     * Will change grid state_ a$.
     * 
     * @throws Exception
     *             the exception
     */
    @Test
    public void willChangeGridState_A$( ) throws Exception {
    	
		Lifeform human = new Human(2, 1);
		Assert.assertEquals(false, human.willChangeGridState());

		Disease dis2 = new H5N1(human);

		human.setDisease(dis2);
		Assert.assertEquals(true, human.willChangeGridState());

    }

}
