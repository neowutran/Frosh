/**
 * @author Martini Didier
 */

package models.states;

/**
 * The Interface IState.
 */
public interface IState {

    /**
     * Apply.
     */
    void apply();

    /**
     * Gets the state name.
     * 
     * @return the state name
     */
    String getStateName();
}
