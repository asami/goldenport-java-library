package org.goldenport.statemachine;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @since   Aug.  2, 2011
 * @version Aug.  3, 2011
 * @author  ASAMI, Tomoharu
 */
public abstract class State {
    public final int code;
    public final String name;
    private final Transition[] _transitions;
    protected StateMachine stateMachine;
    private CopyOnWriteArrayList<IStateListener> _listeners = null;

    public State(int code, String name, List<Transition> transitions) {
        this.code = code;
        this.name = name;
        _transitions = transitions.toArray(new Transition[transitions.size()]);
        for (Transition t: _transitions) {
            t.init(this);
        }
    }

    public void init(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public StateMachine getStateMachine() {
        return stateMachine;
    }

    public int fire(SMEvent event) {
        if (event.code < 0 || event.code >= _transitions.length) {
            throw new IllegalStateException(String.format("Invalid event %s(%s)", event.name, event.code));
        }
        Transition ts = _transitions[event.code];
        if (ts == null) {
            throw new IllegalStateException(String.format("Invalid event %s(%s)", event.name, event.code));
        }
        return ts.fire(this, event);
    }

    public void enter(SMEvent event) {
        doEntry(event);
        for (IStateListener l: _listeners) {
            l.entry(stateMachine, this, event);
        }
        doStart(event);
    }

    protected void doEntry(SMEvent event) {
    }

    protected void doStart(SMEvent event) {
    }

    public void leave(SMEvent event) {
        doStop(event);
        for (IStateListener l: _listeners) {
            l.exit(stateMachine, this, event);
        }
        doExit(event);
    }

    protected void doStop(SMEvent event) {
    }

    protected void doExit(SMEvent event) {
    }

    protected void doStimulus() {
    }

    public void reEnter(SMEvent event) {
        doReEnter(event);
    }

    protected void doReEnter(SMEvent event) {
    }

    public void addStateListener(IStateListener l) {
        _listeners.add(l);
    }

    public void removeStateListener(IStateListener l) {
        _listeners.remove(l);
    }
}
