package org.goldenport.feed;

/*
 * Derived from GAText
 *
 * @since   Jun. 11, 2011
 * @version Jul. 23, 2011
 * @author  ASAMI, Tomoharu
 */
public class GText {
    public final TextType type;
    public final String text;

    public GText(TextType type, String text) {
        this.type = type;
        this.text = text;
    }

    public GText(String title) {
        this(TextType.text, title);
    }
}
