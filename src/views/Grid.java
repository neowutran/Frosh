/*
 * 
 */

package views;

import models.GridModel;
import models.LifeformModel;
import models.lifeform.HumanModel;
import models.lifeform.animal.ChickenModel;
import models.lifeform.animal.DuckModel;
import models.lifeform.animal.PigModel;
import models.states.ContagiousModel;
import models.states.HealtyModel;
import models.states.RecoveringModel;
import models.states.SickModel;

// TODO: Auto-generated Javadoc
/**
 * The Class Grid.
 */
public class Grid {

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
        final LifeformModel[ ][ ] grid = GridModel.getGrid( );
        for( final LifeformModel[ ] element : grid ) {
            for( final LifeformModel element2 : element ) {
                if( element2 == null ) {
                    resultat += "--";
                    resultat += "\t|\t";
                    continue;
                }
                if( element2 instanceof HumanModel ) {
                    resultat += "H";
                } else if( element2 instanceof PigModel ) {
                    resultat += "P";
                } else if( element2 instanceof ChickenModel ) {
                    resultat += "C";
                } else if( element2 instanceof DuckModel ) {
                    resultat += "D";
                }

                if( element2.getStates( ) instanceof HealtyModel ) {
                    resultat += 0;
                } else if( element2.getStates( ) instanceof SickModel ) {
                    resultat += 1;
                } else if( element2.getStates( ) instanceof ContagiousModel ) {
                    resultat += 2;
                } else if( element2.getStates( ) instanceof RecoveringModel ) {
                    resultat += 3;
                }

                if( element2.isImmune( ) ) {
                    resultat += "*";
                } else {
                    resultat += " ";
                }
                resultat += "\t|\t";
            }
            resultat += "\n";
        }
        resultat += "\n\n\n";
        return resultat;
    }
}
