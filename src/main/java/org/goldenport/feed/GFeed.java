package org.goldenport.feed;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/*
 * @since   Jun.  3, 2011
 * @version Jul. 23, 2011
 * @author  ASAMI, Tomoharu
 */
public class GFeed {
    public final String id;
    public final String title;
    public final String subtitle;
    public final String updated;
    public final List<GEntry> entries;
    public final List<String> categories;
    public final List<String> links;
    public final List<String> contributors;
    public final String generator;
    public final String rights;
    public final String icon;
    public final String logo;
    public final List<String> extensionElements;
    public final GSchema schema;
    public final Map<String, Object> properties;

    public GFeed(
            String id,
            String title,
            String subtitle,
            String updated,
            List<GEntry> entries,
            List<String> categories,
            List<String> links,
            List<String> contributors,
            String generator,
            String rights,
            String icon,
            String logo,
            List<String> extensionElements,
            GSchema schema,
            Map<String, Object> properties) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.updated = updated;
        this.entries = Collections.unmodifiableList(entries);
        this.categories = Collections.unmodifiableList(categories);
        this.links = Collections.unmodifiableList(links);
        this.contributors = Collections.unmodifiableList(contributors);
        this.generator = generator;
        this.rights = rights;
        this.icon = icon;
        this.logo = logo;
        this.extensionElements = extensionElements;
        this.schema = schema;
        this.properties = Collections.unmodifiableMap(properties);
    }
/*
    public GFeedBuilder builder() {
        return new GFeedBuilder(
        );
    }
*/
}
