package org.goldenport.feed;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * @since   Jun.  3, 2011
 * @version Jun.  4, 2011
 * @author  ASAMI, Tomoharu
 */
public class GEntry {
    public final String id;
    public final String title;
    public final String summary;
    public final String published;
    public final String updated;
    public final List<String> categories;
    public final List<String> links;
    public final List<String> authors;
    public final List<String> contributors;
    public final String rights;
    public final String source;
    public final String content;
    public final List<String> extensionElements;
    public final GSchema schema;
    public final Map<String, Object> contents;
    public final Map<String, Object> properties;
    
    public GEntry(
            String id,
            String title,
            String summary,
            String published,
            String updated,
            List<String> categories,
            List<String> links,
            List<String> authors,
            List<String> contributors,
            String rights,
            String source,
            String content,
            List<String> extensionElements,
            GSchema schema,
            Map<String, Object> contents,
            Map<String, Object> properties
            ) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.published = published;
        this.updated = updated;
        this.categories = Collections.unmodifiableList(categories);
        this.links = Collections.unmodifiableList(links);
        this.authors = Collections.unmodifiableList(authors);
        this.contributors = Collections.unmodifiableList(contributors);
        this.rights = rights;
        this.source = source;
        this.content = content;
        this.extensionElements = Collections.unmodifiableList(extensionElements);
        this.schema = schema;
        this.contents = Collections.unmodifiableMap(new LinkedHashMap<String, Object>(contents));
        this.properties = Collections.unmodifiableMap(new LinkedHashMap<String, Object>(properties));
    }
}
