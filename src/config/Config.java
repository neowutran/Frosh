/*
 * @author Martini Didier
 */

package config;

import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class Config.
 */
public final class Config {

    /**
     * The configuration.
     */
    private static Map<String, Object> configuration;
    /**
     * The Constant MAX.
     */
    private static final Integer       MAX = 100;

    /**
     * Gets the configuration.
     * 
     * @return the configuration
     */
    public static Map<String, Object> getConfiguration() {

        return Config.configuration;
    }

    // SonarHQ complience
    /**
     * Gets the max.
     * 
     * @return the max
     */
    public static Integer getMax() {

        return Config.MAX;
    }

    /**
     * Sets the configuration.
     * 
     * @param configuration
     *            the configuration
     */
    public static void setConfiguration(final Map<String, Object> configuration) {

        Config.configuration = configuration;
    }

    /**
     * Instantiates a new config.
     */
    private Config() {

    }
}
