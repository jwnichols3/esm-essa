package com.bgi.essa.jboss4.orm.hibernate3;

import java.io.Serializable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.HibernateException;

import org.hibernate.usertype.UserType;

import com.bgi.essa.shared.primitive.DateOnly;

/**
 * Map Hibernate UserType to DateOnly.  This is a single column mapping.
 *
 * @author G.S. Cole (guycole at gmail dot com)
 */
public class DateOnlyUserType implements UserType {

    /**
     * Mystery function, figure this out
     *
     * @param cached object to be cached
     * @param owner of cached object
     * @return reconstructed object (null because I don't know what to do)
     * @throws HibernateException hibernate problem
     */
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        //fixme
        _log.warn("DateOnlyUserType.assemble");
        return(null);
    }

    /**
     * Mystery function, figure this out
     * Transform the object into it's cacheable representation.
     * I think this means serialized object.
     *
     * @param arg object to cache
     * @return null because I'm not sure what this does     
     * @throws HibernateException hibernate problem
     */
    public Serializable disassemble(Object arg) throws HibernateException {
        //fixme
        _log.warn("DateOnlyUserType.disassemble");
        return(null);
    }

    /**
     * Mystery function, figure this out
     *
     * @param original xxx
     * @param target yyy
     * @param owner zzz
     * @return value to be merged
     * @throws HibernateException hibernate problem
     */
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        //fixme
        _log.warn("DateOnlyUserType.replace");
        return(null);
    }

    /**
     * Return a deep copy of the persistant state.  Treat as clone.
     *
     * @param arg object to clone or null
     * @return cloned object or null
     * @throws HibernateException hibernate problem
     */
    public Object deepCopy(Object arg) throws HibernateException {
        if (arg == null) {
            return(null);
        }
	
        DateOnly temp = (DateOnly) arg;
        return(temp.clone());
    }

    /**
     * Perform dirty checking to determine if a database write is required.
     *
     * @param xx comparison operator
     * @param yy comparison operator
     * @throws HibernateException hibernate problem
     */
    public boolean equals(Object xx, Object yy) throws HibernateException {
        if (xx == yy) {
            return(true);
        }

        if (xx == null || yy == null) {
            return(false);
        }

        return(xx.equals(yy));
    }

    /**
     * Return the hashCode for this object
     *
     * @param arg object to test
     * @return hash code for this object
     * @throws HibernateException hibernate problem
     */
    public int hashCode(Object arg) throws HibernateException {
        return(arg.hashCode());
    }
    
    /**
     * DateOnly is immutable
     *
     * @return false, DateOnly is immutable
     */
    public boolean isMutable() {
        return(false);
    }

    /**
     * Populate DateOnly from ResultSet
     *
     * @param result_set JDBC result set
     * @param names column names (should only have one element)
     * @param owner parent entity
     * @throws HibernateException hibernate problem
     * @throws SQLException SQL problem
     */
    public Object nullSafeGet(ResultSet result_set, String[] names, Object owner) throws HibernateException, SQLException {
        if (result_set.wasNull()) {
            return(null);
        }

        return(new DateOnly(result_set.getDate(names[0])));
    }

    /**
     * Populate Statement from DateOnly
     *
     * @param statement JDBC prepared statement
     * @param value object to write from
     * @param index statement parameter index
     * @throws HibernateException hibernate problem
     * @throws SQLException SQL problem
     */
    public void nullSafeSet(PreparedStatement statement, Object value, int index) throws HibernateException, SQLException {
        if (value == null) {
        	statement.setNull(index, Types.DATE);
        } else {
        	DateOnly temp = (DateOnly) value;
        	statement.setDate(index, temp.getSqlDateValue());
        }
    }

    /**
     * Return Java type mapped by UserType
     *
     * @return Java type mapped by UserType
     */
	public Class<DateOnly> returnedClass() {
        return(DateOnly.class);
    }

    /**
     * Return column type definitions.  DateOnly only has a single column.
     *
     * @return column type definitions.
     */
    public int[] sqlTypes() { 
        return(SQL_TYPES);
    }

    /**
     * Column type definition, DateOnly only has a single column.
     */
    private static final int SQL_TYPES[] = { Types.DATE };

    /**
     * Define logger
     */    
    private static final Log _log = LogFactory.getLog(DateOnlyUserType.class);
}