package org.goldenport.statemachine;

/**
 * @since   Aug.  2, 2011
 * @version Aug.  3, 2011
 * @author  ASAMI, Tomoharu
 */
public interface IStateMachineListener {
    void start(State state);
    void transition(State oldState, State newState, SMEvent event);
}
