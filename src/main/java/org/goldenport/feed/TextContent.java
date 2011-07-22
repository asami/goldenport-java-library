package org.goldenport.feed;


/*
 * @since   Jun. 12, 2011
 * @version Jul. 23, 2011
 * @author  ASAMI, Tomoharu
 */
public class TextContent extends GAContent {
    public final String text;

    public TextContent(String text) {
        super(TextType.text);
        this.text = text;
    }
}
