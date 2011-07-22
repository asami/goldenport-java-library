package org.goldenport.feed;

/*
 * Derived from GAContent {
 * 
 * @since   Jun. 11, 2011
 * @version Jun. 23, 2011
 * @author  ASAMI, Tomoharu
 */
public abstract class GAContent {
    public final TextType type;

    protected GAContent(TextType type) {
        this.type = type;
    }
}
