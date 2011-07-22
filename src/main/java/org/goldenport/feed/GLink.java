package org.goldenport.feed;

import java.net.URI;

/*
 * Derived from GALink
 *
 * @since   Jun. 11, 2011
 * @version Jul. 21, 2011
 * @author  ASAMI, Tomoharu
 */
public class GLink {
    public final String type;
    public final URI href;
    public final String rel;

    public GLink(String type, URI href, String rel) {
        this.type = type;
        this.href = href;
        this.rel = rel;
    }
}
