package org.goldenport.statemachine;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @since   Aug. 1, 2011
 * @version Aug. 3, 2011
 * @author ASAMI, Tomoharu
 */
public class StateMachine {
    private final State[] states;
    private final EventClass[] events;
    private State state;
    private CopyOnWriteArrayList<IStateMachineListener> _listeners;

    public StateMachine(List<State> states, List<EventClass> events) {
        this.states = states.toArray(new State[states.size()]);
        for (State s: states) {
            s.init(this);
        }
        this.events = events.toArray(new EventClass[events.size()]);
        this.state = states.get(0);
        for (IStateMachineListener l: _listeners) {
            l.start(this.state);
        }
    }

    public void fire(Object signal) throws IOException {
        SMEvent event = _distill_event(signal);
        if (event != null) {
            fire(event);
        }
    }

    private SMEvent _distill_event(Object signal) {
        for (EventClass ec : events) {
            SMEvent event = ec.acceptSignal(signal);
            if (event != null) {
                return event;
            }
        }
        return null;
    }

    public void fire(SMEvent event) {
        int code = state.fire(event);
        try {
            State newState = states[code];
            State oldState = state;
            if (newState != state) {
                state.leave(event);
                update_State(state, newState);
                validate_State(state, newState);
                state = newState;
                state.enter(event);
                for (IStateMachineListener l: _listeners) {
                    l.transition(oldState, newState, event);
                }
            } else {
                state.reEnter(event);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalStateException("Illegal event: " + event + ", state: " + code);
        }
    }

    public int getStateCode() {
        return state.code;
    }

    public String getStateName() {
        return state.name;
    }

    private void update_State(State oldstate, State newstate)
            throws IllegalStateException {
    }

    protected void validate_State(State oldstate, State newstate) {
    }

    public void addStateMachineListener(IStateMachineListener l) {
        _listeners.add(l);
    }

    public void removeStateMachineListener(IStateMachineListener l) {
        _listeners.remove(l);
    }

    public void addStateListener(int state, IStateListener l) {
        states[state].addStateListener(l);
    }

    public void removeStateListener(int state, IStateListener l) {
        states[state].removeStateListener(l);
    }
}
