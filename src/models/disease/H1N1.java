/*
 * @author Martini Didier
 */

package models.disease;

import models.Lifeform;

// TODO: Auto-generated Javadoc
/**
 * The Class H1N1.
 */
public class H1N1 extends Disease {

    /**
     * Instantiates a new h1 n1.
     * 
     * @param carrier
     *            the carrier
     */
    public H1N1( final Lifeform carrier ) {

        super( carrier );
    }

    /*
     * (non-Javadoc)
     * 
     * @see models.disease.Disease#clone()
     */
    @Override
    public Object clone( ) throws CloneNotSupportedException {

        return super.clone( H1N1.class );

    }

    /*
     * (non-Javadoc)
     * 
     * @see models.disease.IDiseaseType#getDiseaseType()
     */
    @Override
    public String getDiseaseType( ) {

        return "H1N1";
    }

}
