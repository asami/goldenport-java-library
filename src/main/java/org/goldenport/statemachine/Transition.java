package org.goldenport.statemachine;

import java.util.List;

/**
 * @since   Aug.  2, 2011
 * @version Aug.  3, 2011
 * @author  ASAMI, Tomoharu
 */
public class Transition {
    protected StateMachine stateMachine;
    protected State state;
    private final Tuple[] _tuples;

    public Transition(List<Tuple> tuples) {
        _tuples = tuples.toArray(new Tuple[tuples.size()]);
    }

    public void init(State state) {
        this.state = state;
        this.stateMachine = state.getStateMachine();
    }

    public int fire(State state, SMEvent event) {
        Tuple tuple = _find_tuple(event);
        if (tuple != null) {
            tuple.action.action(stateMachine, state, event);
            return tuple.state;
        } else {
            return -1;
        }
    }

    private Tuple _find_tuple(SMEvent event) {
        for (Tuple t: _tuples) {
            if (t.guard == null) {
                return t;
            }
            if (t.guard.accept(stateMachine, state, event)) {
                return t;
            }
        }
        return null;
    }

    public static class Tuple {
        public Guard guard;
        public Action action;
        public int state;
    }
}
