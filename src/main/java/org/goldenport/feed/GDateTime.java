package org.goldenport.feed;

import java.util.Date;
import java.util.TimeZone;

/*
 * Derived from GADatetime
 *
 * @since   Jun. 11, 2011
 * @version Jul. 21, 2011
 * @author  ASAMI, Tomoharu
 */
public class GDateTime {
    public final Date datetime;
    public final TimeZone timezone;

    public GDateTime(Date datetime, TimeZone timezone) {
        this.datetime = datetime;
        this.timezone = timezone;
    }

    public GDateTime(String text) {
        this.datetime = null;        // TODO Auto-generated constructor stub
        this.timezone = null;        // TODO Auto-generated constructor stub
    }
}
