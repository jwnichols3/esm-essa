package com.opensymphony.sass.jira;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;

/**
 * User: plightbo
 * Date: Nov 23, 2005
 * Time: 12:57:32 PM
 */
public class JiraToLdif {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();

        System.out.println("Parsing XML...");

        Document d = db.parse(new File("jira.xml"));
        Element root = d.getDocumentElement();

        System.out.println("... XML parsed!");

        // build up all the users
        NodeList users = root.getElementsByTagName("OSUser");
        HashMap list = new HashMap(users.getLength());
        for (int i = 0; i < users.getLength(); i++) {
            Element e = (Element) users.item(i);
            User user = new User();
            user.username = e.getAttribute("name");
            user.id = Long.parseLong(e.getAttribute("id"));
            list.put(new Long(user.id), user);
        }

        System.out.println("All users built up!");

        // build up OSPropertyStrings
        Map propString = new HashMap(users.getLength() * 10);
        NodeList propsNL = root.getElementsByTagName("OSPropertyString");
        for (int i = 0; i < propsNL.getLength(); i++) {
            Element e = (Element) propsNL.item(i);
            propString.put(new Long(e.getAttribute("id")), e.getAttribute("value"));
        }

        System.out.println("All property strings built up!");

        // now process OSPropertyEntry
        propsNL = root.getElementsByTagName("OSPropertyEntry");
        for (int i = 0; i < propsNL.getLength(); i++) {
            Element e = (Element) propsNL.item(i);
            Long propId = new Long(e.getAttribute("id"));
            String key = e.getAttribute("propertyKey");
            if (e.getAttribute("entityName").equals("OSUser") && (key.equals("email") || key.equals("fullName"))) {
                long userId = Long.parseLong(e.getAttribute("entityId"));
                User user = (User) list.get(new Long(userId));
                if (user != null) {
                    String value = (String) propString.get(propId);
                    if (key.equals("email")) {
                        user.email = value;
                    } else {
                        user.name = value;
                    }
                }
            }
        }

        for (Iterator iterator = list.values().iterator(); iterator.hasNext();) {
            User user = (User) iterator.next();

            System.out.println("");
            System.out.println("dn: uid=" + user.username + ",ou=People,dc=opensymphony,dc=com");
            System.out.println("objectClass: inetOrgPerson");
            System.out.println("objectClass: organizationalPerson");
            System.out.println("objectClass: person");
            System.out.println("objectClass: top");
            System.out.println("cn: " + user.name);
            System.out.println("mail: " + user.email);
            System.out.println("sn: " + user.name);
            System.out.println("uid: " + user.username);
        }
    }

    static class User {
        long id;
        String username;
        String name;
        String email;

        public String toString() {
            return username + ", " + name + ", " + email;
        }

        public boolean isValid() {
            return username != null && name != null && email != null;
        }
    }
}
