/*
 * @author Martini Didier
 */

package models.disease;

import models.Lifeform;

/**
 * The Class H5N1Model.
 */
public class H5N1 extends Disease {

    /**
     * Instantiates a new h5 n1 model.
     * 
     * @param carrier
     *            the carrier
     */
    public H5N1(final Lifeform carrier) {

        super(carrier);
    }

    /*
     * (non-Javadoc)
     * 
     * @see models.disease.IDiseaseType#getDiseaseType()
     */
    @Override
    public String getDiseaseType() {

        return "H5N1";
    }

}
