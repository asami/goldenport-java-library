package org.goldenport.feed;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/*
 * @since   Jun.  4, 2011
 * @version Jun.  4, 2011
 * @author  ASAMI, Tomoharu
 */
public class GSchemaField {
    public final String name;
    public final Class<?> datatype; // XXX GDatatype
    public final GMultiplicity multiplicity;
    public final List<GConstraint> constraints;
    public final List<GFacet> facets;
    public final Map<String, Object> properties;

    public GSchemaField(
            String name,
            Class<?> datatype,
            GMultiplicity multiplicity,
            List<GConstraint> constraints,
            List<GFacet> facets,
            Map<String, Object> properties) {
        this.name = name;
        this.datatype = datatype;
        this.multiplicity = multiplicity;
        this.constraints = Collections.unmodifiableList(constraints);
        this.facets = Collections.unmodifiableList(facets);
        this.properties = Collections.unmodifiableMap(properties);
    }
}
