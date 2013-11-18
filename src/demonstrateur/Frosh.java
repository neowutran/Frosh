/**
 * @author Martini Didier
 */

package demonstrateur;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import lib.CopyFile;

import com.google.gson.Gson;

import config.Config;
import controllers.FroshController;

/**
 * The Class Frosh.
 */
public class Frosh {

    /** The Constant FOLDER. */
    public static final String FOLDER = "Frosh" + File.separator;

    /** The Constant CONFIG. */
    public static final String CONFIG = "config.json";

    /**
     * Load config file.
     * 
     * @param configFile
     *            the config file
     */
    private static void loadConfigFile( final Path configFile ) {

        // Read the file
        final Charset charset = Charset.forName( "UTF-8" );
        try( BufferedReader reader = Files.newBufferedReader( configFile,
                charset ) ) {
            String line;
            String text = "";
            while( ( line = reader.readLine( ) ) != null ) {
                text += line;
            }
            // Convert the JSON file to an java object
            final Gson gson = new Gson( );
            Config.setConfiguration( gson.fromJson( text, Map.class ) );
        } catch( final IOException x ) {

            System.err.format( "IOException: %s%n", x );
        }
    }

    /**
     * The main method.
     * 
     * @param args
     *            the arguments
     */
    public static void main( final String[ ] args ) {

        new Frosh( );

    }

    /**
     * Instantiates a new frosh.
     */
    public Frosh( ) {

        // Create the config folder
        if( !new File( Frosh.FOLDER ).isDirectory( ) ) {
            this.createConfigFolder( );
        }
        // Copy the default config file into the folder if no config file was
        // found
        if( !new File( Frosh.FOLDER + Frosh.CONFIG ).exists( ) ) {
            final CopyFile lib = new CopyFile( );
            lib.copyfile( Frosh.FOLDER + Frosh.CONFIG );
        }
        Frosh.loadConfigFile( Paths.get( Frosh.FOLDER, Frosh.CONFIG ) );
        new FroshController( ).run( );

    }

    /**
     * Creates the config folder.
     */
    private void createConfigFolder( ) {

        new File( Frosh.FOLDER ).mkdirs( );
    }
}
