/*
 * @author Martini Didier
 */

package views;

import models.Grid;
import models.Lifeform;
import models.Stats;

import com.google.gson.internal.LinkedTreeMap;

import config.Config;

/**
 * The Class View.
 */
public class View {

    /** The day. */
    private int day = 0;

    /**
     * Show.
     */
    public void show( ) {

        System.out.println( this.toString( ) );
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString( ) {

        String resultat = "\n\n\n";
        resultat += "day:" + this.day + "\n";
        resultat += "dead:" + Stats.getDead( ) + "\n";
        this.day++;
        final Lifeform[ ][ ] grid = Grid.getGrid( );
        for( final Lifeform[ ] element : grid ) {
            for( final Lifeform element2 : element ) {
                if( element2 == null ) {
                    resultat += "--";
                    resultat += "\t|\t";
                    continue;
                }

                resultat += ( ( LinkedTreeMap<?, ?> ) ( ( LinkedTreeMap<?, ?> ) Config
                        .getConfiguration( ).get( "view" ) ).get( "lifeform" ) )
                        .get( element2.getLifeformType( ) );

                resultat += ( ( Double ) ( ( LinkedTreeMap<?, ?> ) ( ( LinkedTreeMap<?, ?> ) Config
                        .getConfiguration( ).get( "view" ) )
                        .get( "diseaseState" ) ).get( element2.getStates( )
                        .getStateName( ) ) ).intValue( );

                resultat += "\t|\t";
            }
            resultat += "\n";
        }
        resultat += "\n\n\n";
        return resultat;
    }
}
