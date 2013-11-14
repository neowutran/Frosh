/*
 * @author Martini Didier
 */

package models.disease;

import models.Lifeform;

// TODO: Auto-generated Javadoc
/**
 * The Class H5N1.
 */
public class H5N1 extends Disease {

    /**
     * Instantiates a new h5 n1.
     * 
     * @param carrier
     *            the carrier
     */
    public H5N1( final Lifeform carrier ) {

        super( carrier );
    }

    /*
     * (non-Javadoc)
     * 
     * @see models.disease.IDiseaseType#getDiseaseType()
     */
    @Override
    public String getDiseaseType( ) {

        return "H5N1";
    }

}
