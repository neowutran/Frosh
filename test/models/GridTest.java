
package models;

import models.Grid.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
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

    // TODO methode clone ou cheat pour faire la meme chose.
    // TODO methode equals
    // TODO methode random avec parametre pour que ce ne soit pas random (pour
    // les tests)
    @Test
	public void move_A$Cardinal$int$int() throws Exception {
	   
	    Grid grid = new Grid();
	    
	    //TODO Stocker / enregistrer l'etat d'origine ( via un clone? il ne faut pas que ce soit par reference) 
	    Lifeform[][] origine = Grid.getGrid( );
	    
	    //TODO Boucle sur chaque cellule de la grille (tableau), jusqu'a trouver un element non nul ( = lifeform) 
	    // Calculer 2-3 deplacement et les enregistrer dans une variable en tant qu'etat de validation
	    Lifeform[][] monEtatEnregistrer = origine;
	    monEtatEnregistrer[1][2] = monEtatEnregistrer[1][1];
	    monEtatEnregistrer[1][1] = null;
	    
	   //TODO Faire le move de la lifeform 
		Grid.move(Cardinal.EAST, 1, 1);
		
		//TODO Faire les tests
		Assert.assertThat(Grid.getGrid( ), Assert.isEquals(to(monEtatEnregistrer));
	}

    @Test
    public void nextDay_A$( ) throws Exception {
        // TODO auto-generated by JUnit Helper.
        Grid.nextDay( );
    }

    @Test
    public void hasEnded_A$( ) throws Exception {
        // TODO auto-generated by JUnit Helper.
        Grid target = new Grid( );
        boolean actual = target.hasEnded( );
        boolean expected = false;
        Assert.assertThat( actual,
                CoreMatchers.is( CoreMatchers.equalTo( expected ) ) );
    }

}
