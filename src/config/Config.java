/*
 * 
 */

package config;

import java.util.Map;

/**
 * The Class Config.
 */
public class Config {

    /** The configuration. */
    private static Map<String, Object> configuration;

    /**
     * Gets the configuration.
     * 
     * @return the configuration
     */
    public static Map<String, Object> getConfiguration( ) {
        return Config.configuration;
    }

    /**
     * Sets the configuration.
     * 
     * @param configuration
     *            the configuration
     */
    public static void setConfiguration( final Map<String, Object> configuration ) {
        Config.configuration = configuration;
    }
}
