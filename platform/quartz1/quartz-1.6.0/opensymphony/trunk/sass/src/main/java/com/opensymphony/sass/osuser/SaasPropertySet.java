package com.opensymphony.sass.osuser;

import com.opensymphony.module.propertyset.PropertySet;
import com.opensymphony.module.propertyset.PropertySetSchema;
import com.opensymphony.module.propertyset.PropertyException;
import com.opensymphony.sass.user.User;
import org.w3c.dom.Document;

import java.util.Date;
import java.util.Collection;
import java.util.Properties;
import java.util.Map;

/**
 * @author Patrick Lightbody (plightbo at gmail dot com)
 */
public class SaasPropertySet implements PropertySet {
    PropertySet ps;
    User user;

    public SaasPropertySet(PropertySet ps, User user) {
        this.ps = ps;
        this.user = user;
    }

    public void setSchema(PropertySetSchema propertySetSchema) throws PropertyException {
        ps.setSchema(propertySetSchema);
    }

    public PropertySetSchema getSchema() throws PropertyException {
        return ps.getSchema();
    }

    public void setAsActualType(String s, Object o) throws PropertyException {
        if (s.equals("email") || s.equals("fullName")) {
            return;
        }

        ps.setAsActualType(s, o);
    }

    public Object getAsActualType(String s) throws PropertyException {
        if (s.equals("email")) {
            return user.getEmail();
        } else if (s.equals("fullName")) {
            return user.getName();
        } else {
            return ps.getAsActualType(s);
        }
    }

    public void setBoolean(String s, boolean b) throws PropertyException {
        ps.setBoolean(s, b);
    }

    public boolean getBoolean(String s) throws PropertyException {
        return ps.getBoolean(s);
    }

    public void setData(String s, byte[] bytes) throws PropertyException {
        ps.setData(s, bytes);
    }

    public byte[] getData(String s) throws PropertyException {
        return ps.getData(s);
    }

    public void setDate(String s, Date date) throws PropertyException {
        ps.setDate(s, date);
    }

    public Date getDate(String s) throws PropertyException {
        return ps.getDate(s);
    }

    public void setDouble(String s, double v) throws PropertyException {
        ps.setDouble(s, v);
    }

    public double getDouble(String s) throws PropertyException {
        return ps.getDouble(s);
    }

    public void setInt(String s, int i) throws PropertyException {
        ps.setInt(s, i);
    }

    public int getInt(String s) throws PropertyException {
        return ps.getInt(s);
    }

    public Collection getKeys() throws PropertyException {
        return ps.getKeys();
    }

    public Collection getKeys(int i) throws PropertyException {
        return ps.getKeys(i);
    }

    public Collection getKeys(String s) throws PropertyException {
        return ps.getKeys(s);
    }

    public Collection getKeys(String s, int i) throws PropertyException {
        return ps.getKeys(s, i);
    }

    public void setLong(String s, long l) throws PropertyException {
        ps.setLong(s, l);
    }

    public long getLong(String s) throws PropertyException {
        return ps.getLong(s);
    }

    public void setObject(String s, Object o) throws PropertyException {
        ps.setObject(s, o);
    }

    public Object getObject(String s) throws PropertyException {
        return ps.getObject(s);
    }

    public void setProperties(String s, Properties properties) throws PropertyException {
        ps.setProperties(s, properties);
    }

    public Properties getProperties(String s) throws PropertyException {
        return ps.getProperties(s);
    }

    public boolean isSettable(String s) {
        return ps.isSettable(s);
    }

    public void setString(String s, String s1) throws PropertyException {
        if (s.equals("email") || s.equals("fullName")) {
            return;
        }

        ps.setString(s, s1);
    }

    public String getString(String s) throws PropertyException {
        if (s.equals("email")) {
            return user.getEmail();
        } else if (s.equals("fullName")) {
            return user.getName();
        } else {
            return ps.getString(s);
        }
    }

    public void setText(String s, String s1) throws PropertyException {
        ps.setText(s, s1);
    }

    public String getText(String s) throws PropertyException {
        return ps.getText(s);
    }

    public int getType(String s) throws PropertyException {
        return ps.getType(s);
    }

    public void setXML(String s, Document document) throws PropertyException {
        ps.setXML(s, document);
    }

    public Document getXML(String s) throws PropertyException {
        return ps.getXML(s);
    }

    public boolean exists(String s) throws PropertyException {
        return ps.exists(s);
    }

    public void init(Map map, Map map1) {
        ps.init(map, map1);
    }

    public void remove(String s) throws PropertyException {
        ps.remove(s);
    }

    public boolean supportsType(int i) {
        return ps.supportsType(i);
    }

    public boolean supportsTypes() {
        return ps.supportsTypes();
    }

}
