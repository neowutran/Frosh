/*
 * @author Martini Didier
 */

package models.disease;

import models.LifeformModel;

/**
 * The Class H1N1Model.
 */
public class H1N1Model extends DiseaseModel {

    /**
     * Instantiates a new h1 n1 model.
     * 
     * @param carrier
     *            the carrier
     */
    public H1N1Model(final LifeformModel carrier) {

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
