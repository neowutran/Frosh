/**
 * @author Martini Didier
 */

package demonstrateur;

import java.nio.file.Path;
import java.nio.file.Paths;

import lib.CopyFile;
import lib.Json;
import controllers.FroshController;

/**
 * The Class Frosh.
 */
public class Frosh {

    /**
     * The Constant FOLDER.
     */
    public static final String FOLDER = "Frosh" + java.io.File.separator;
    /**
     * The Constant CONFIG.
     */
    public static final String CONFIG = "config.json";

    /**
     * Load config file.
     * 
     * @param configFile
     *            the config file
     */
    private static void loadConfigFile(final Path configFile) {

        config.Config.setConfiguration(Json.loadFile(configFile));
    }

    /**
     * The main method.
     * 
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {

        new Frosh();
    }

    /**
     * Instantiates a new mini project.
     */
    public Frosh() {

        // Create the config folder
        if (!new java.io.File(Frosh.FOLDER).isDirectory()) {
            this.createConfigFolder();
        }
        // Copy the default config file into the folder if no config file was
        // found
        if (!new java.io.File(Frosh.FOLDER + Frosh.CONFIG).exists()) {
            CopyFile.copyFile(this.getClass().getClassLoader()
                    .getResourceAsStream(Frosh.CONFIG), Frosh.FOLDER
                    + Frosh.CONFIG);
        }
        Frosh.loadConfigFile(Paths.get(Frosh.FOLDER, Frosh.CONFIG));
        FroshController.getInstance();
    }

    /**
     * Creates the config folder.
     */
    private void createConfigFolder() {

        new java.io.File(Frosh.FOLDER).mkdirs();
    }
}
