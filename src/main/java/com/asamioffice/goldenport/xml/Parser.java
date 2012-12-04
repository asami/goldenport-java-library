package com.asamioffice.goldenport.xml;

import org.xml.sax.SAXException;
import org.w3c.dom.*;
import java.io.*;
import javax.xml.parsers.*;

/*
 * Parser
 *
 * @since   Dec.  4, 2012
 * @version Dec.  4, 2012
 * @author  ASAMI, Tomoharu
 */
public class Parser {
    private static DocumentBuilderFactory factory = null;
    private static DocumentBuilder builder = null;

    private static DocumentBuilderFactory getFactory() {
        if (factory == null) {
            factory = DocumentBuilderFactory.newInstance();
        }
        return factory;
    }

    private static DocumentBuilder getBuilder() {
        try {
            if (builder == null) {
                builder = getFactory().newDocumentBuilder();
            }
            return builder;
        } catch (ParserConfigurationException e) {
            throw new InternalError(e.getMessage());
        }
    }

    public static Document parseString(String s) throws SAXException, IOException {
        InputStream in = new ByteArrayInputStream(s.getBytes("utf-8"));
        try {
            return getBuilder().parse(in);
        } finally {
            in.close();
        }
    }
}
