/*
 * @author Martini Didier
 */

package lib;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import controllers.FroshController;

// TODO: Auto-generated Javadoc
/**
 * The Class CopyFile.
 */
public class CopyFile {

    /** The destination. */
    private String            destination;

    /** The sources. */
    private final InputStream sources      = this.getClass( )
                                                   .getClassLoader( )
                                                   .getResourceAsStream(
                                                           "config.json" );

    /** The Constant TAILLEBUFFER. */
    private static final int  TAILLEBUFFER = 1024;

    /**
     * Copyfile.
     * 
     * @param destination
     *            the destination
     */
    public void copyfile( final String destination ) {

        this.setDestination( destination );
        try {
            final File f2 = new File( destination );
            final OutputStream out = new FileOutputStream( f2 );
            final byte[ ] buf = new byte[ CopyFile.TAILLEBUFFER ];
            int len;
            while( ( len = this.sources.read( buf ) ) > 0 ) {
                out.write( buf, 0, len );
            }
            this.sources.close( );
            out.close( );
        } catch( final FileNotFoundException ex ) {
            FroshController.LOGGER.severe( java.util.Arrays.toString( ex
                    .getStackTrace( ) ) );
            System.exit( 0 );
        } catch( final IOException e ) {
            FroshController.LOGGER.severe( java.util.Arrays.toString( e
                    .getStackTrace( ) ) );
        }
    }

    /**
     * Gets the destination.
     * 
     * @return the destination
     */
    public String getDestination( ) {

        return this.destination;
    }

    /**
     * Sets the destination.
     * 
     * @param destination
     *            the new destination
     */
    public void setDestination( final String destination ) {

        this.destination = destination;
    }
}
