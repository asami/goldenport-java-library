package org.goldenport.statemachine;

/**
 * @since   Aug.  2, 2011
 * @version Aug.  2, 2011
 * @author  ASAMI, Tomoharu
 */
public abstract class EventClass {
    public abstract SMEvent acceptSignal(Object signal);
}
