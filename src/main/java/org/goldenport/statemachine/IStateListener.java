package org.goldenport.statemachine;

/**
 * @since   Aug. 3, 2011
 * @version Aug. 3, 2011
 * @author ASAMI, Tomoharu
 */
public interface IStateListener {
    void entry(StateMachine stateMachine, State state, SMEvent event);
    void exit(StateMachine stateMachine, State state, SMEvent event);
}
