package models;

/**
 * Created by neowutran on 14/12/13.
 */
public class FroshRuntimeException extends RuntimeException {

    /**
     * Instantiates a new mini project exception.
     */
    public FroshRuntimeException( ) {
        super( );
    }

    /**
     * Instantiates a new mini project exception.
     *
     * @param message the message
     */
    public FroshRuntimeException( final String message ) {
        super( message );
    }

    /**
     * Instantiates a new mini project exception.
     *
     * @param message the message
     * @param cause the cause
     */
    public FroshRuntimeException( final String message, final Throwable cause ) {
        super( message, cause );
    }

    /**
     * Instantiates a new mini project exception.
     *
     * @param cause the cause
     */
    public FroshRuntimeException( final Throwable cause ) {
        super( cause );
    }
}
