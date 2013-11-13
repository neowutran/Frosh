/*
 * @author Martini Didier
 */

package models.disease;

import models.Lifeform;

/**
 * The Class H1N1Model.
 */
public class H1N1 extends Disease {

    /**
     * Instantiates a new h1 n1 model.
     *
     * @param carrier the carrier
     */
    public H1N1(final Lifeform carrier) {

        super(carrier);
    }

    /*
     * (non-Javadoc)
     * 
     * @see models.disease.IDiseaseType#getDiseaseType()
     */
    @Override
    public String getDiseaseType() {

        return "H1N1";
    }

}
