package models;

import models.Grid.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import lib.Rand;
import models.lifeform.Human;
import models.lifeform.animal.Chicken;
import models.lifeform.animal.Duck;
import models.lifeform.animal.Pig;
import com.google.gson.internal.LinkedTreeMap;
import config.Config;
import controllers.FroshController;
public class GridTest {

	@Test
	public void move_A$Cardinal$int$int() throws Exception {
		// TODO auto-generated by JUnit Helper.
	    Cardinal cardinal = null;
		int column = 0;
		int line = 0;
		Grid.move(cardinal, column, line);
	}

	@Test
	public void nextDay_A$() throws Exception {
		// TODO auto-generated by JUnit Helper.
		Grid.nextDay();
	}

	@Test
	public void hasEnded_A$() throws Exception {
		// TODO auto-generated by JUnit Helper.
		Grid target = new Grid();
		boolean actual = target.hasEnded();
		boolean expected = false;
		assertThat(actual, is(equalTo(expected)));
	}

}