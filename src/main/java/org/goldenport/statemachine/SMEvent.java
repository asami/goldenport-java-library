package org.goldenport.statemachine;

/**
 * @since   Aug.  2, 2011
 * @version Aug.  2, 2011
 * @author  ASAMI, Tomoharu
 */
public class SMEvent {
    public final int code;
    public final String name;
    public SMEvent(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
