package org.goldenport.statemachine;

/**
 * @since   Aug.  3, 2011
 * @version Aug.  3, 2011
 * @author  ASAMI, Tomoharu
 */
public abstract class Action {
    public abstract void action(StateMachine stateMachine, State state, SMEvent event);
}

