package org.goldenport.feed;

import java.util.Collections;
import java.util.List;

/*
 * @since   Jun.  4, 2011
 * @version Jun.  4, 2011
 * @author  ASAMI, Tomoharu
 */
public class GSchema {
    public final List<GSchemaField> fields;

    public GSchema(List<GSchemaField> fields) {
        this.fields = Collections.unmodifiableList(fields);
    }
}
