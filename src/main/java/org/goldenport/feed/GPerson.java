package org.goldenport.feed;

import java.net.URI;


/*
 * Derived from GAPerson
 *
 * @since   Jun. 11, 2011
 * @version Jul. 23, 2011
 * @author  ASAMI, Tomoharu
 */
public class GPerson {
    public final String name;
    public final URI uri;
    public final String email;
    
    public GPerson(String name, URI uri, String email) {
        this.name = name;
        this.uri = uri;
        this.email = email;
    }

    public GPerson(String person) {
        this.name = person;
        this.uri = null;
        this.email = null;
    }
}
