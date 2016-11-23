package com.bgi.essa.shared.primitive;

import java.text.DecimalFormat;

/**
 * Long integer (database) key.
 * 
 * Immutable value type.
 * 
 * @author gsc
 */
public final class LongKey implements Comparable<Object>, ValueTypeIf {

	/**
	 * Ctor w/initialization
	 * 
	 * @param arg key
	 * @throws IllegalArgumentException if value < 0
	 */
    public LongKey(final long arg) {
        if (arg < 0) {
            throw new IllegalArgumentException("LongKey.ctor less than 0");
        }
        
        _value = arg;
    }
    
    /**
	 * Ctor w/initialization
	 * 
	 * @param arg key to copy
	 * @throws NullPointerException if null arg
	 * @throws IllegalArgumentException if value < 0
	 */
    public LongKey(final Long arg) {
        if (arg == null) {
            throw new NullPointerException("null LongKey.ctor");
        }

        if (arg < 0) {
            throw new IllegalArgumentException("LongKey.ctor less than 0");
        }
        
        _value = arg.longValue();
    }   
    
    /**
	 * Ctor w/initialization
	 * 
	 * @param arg key to copy
	 * @throws NullPointerException if null arg
	 */
    public LongKey(final LongKey arg) {
        if (arg == null) {
            throw new NullPointerException("null LongKey.ctor");
        }
        
        _value = arg.getValue();
    }
    
    /**
	 * Ctor w/initialization
	 * 
	 * @param arg key to copy
	 * @throws NullPointerException if null arg
	 * @throws IllegalArgumentException if value < 0
	 */
    public LongKey(final String arg) {
        if (arg == null) {
            throw new NullPointerException("null LongKey.ctor");
        }
        
        _value = Long.parseLong(arg);
        
        if (_value < 0) {
            throw new IllegalArgumentException("LongKey.ctor less than 0");
        }
    }
    
    /**
	 * Ctor w/initialization
	 * 
	 * @param arg key to copy
	 * @throws NullPointerException if null arg
	 * @throws IllegalArgumentException if value < 0
	 */
    public LongKey(final TrimString arg) {
        if (arg == null) {
            throw new NullPointerException("null LongKey.ctor");
        }
        
        _value = Long.parseLong(arg.getValue());
        
        if (_value < 0) {
            throw new IllegalArgumentException("LongKey.ctor less than 0");
        }
    }
    
    /**
	 * Return key as long
	 * 
	 * @return key as long
	 */
    public long getValue() {
        return(_value);
    }
    
    /**
	 * Return key as Long
	 * 
	 * @return key as Long
	 */
    public Long getLongKeyValue() {
        return(new Long(_value));
    }

    /**
	 * Creates and returns a copy of this object
	 * 
	 * @return populated copy of this object
	 */
    @Override
	public Object clone() {
        return(new LongKey(_value));
    }
    
    /**
	 * Return hash code for this object
	 * 
	 * @return hash code for this object
	 */
    @Override
	public int hashCode() {
        final Long temp = new Long(_value);
        return(11 * temp.hashCode());
    } 
    
    /**
	 * Return true if the keys match
	 * 
	 * @param arg test candidate, will be cast to LongKey
	 * @return true if the key values match
	 * @throws ClassCastException if arg cannot be cast to Long or LongKey
	 */
    @Override
	public boolean equals(final Object arg) {
        if (arg == null) {
            return(false);
        }
        
        if (arg instanceof Long) {
        	return(arg.equals(new Long(_value)));
        }

        if (_value == ((LongKey) arg).getValue()) {
            return(true);
        }

        return(false);
    }

    /**
	 * Compare this object w/the specified object.
	 * 
	 * @return -1 (less than), 0 (equals), 1 (greater than)
	 * @throws ClassCastException if arg cannot be cast
	 */
    public int compareTo(final Object arg) {
        final LongKey lk = (LongKey) arg;
        if (_value < lk.getValue()) {
            return(-1);
        }
        
        if (_value > lk.getValue()) {
            return(1);
        }

        return(0);
    }

    /**
	 * Return a formatted key string.
	 * 
	 * @return a formatted key string.
	 */
    @Override
	public String toString() {
        return(_df.format(_value));        
    }	
	
	/**
	 * Return object state as a XML formatted string 
	 * 
	 * @return object state as a XML formatted string
	 */
    public String toXml() {
        return(_df.format(_value));        
    }
    
	/**
	 * Return object state as a XML formatted string
	 * 
	 * @param tag xml tag
	 * @return object state as a XML formatted string
	 * @throws NullPointerException if tag is null
	 */
	public String toXml(String tag) {
		if (tag == null) {
			throw new NullPointerException("null XML tag");
		}
		
		return("<" + tag + ">" + toXml() + "</" + tag + ">");
	}
    
    /**
	 * format used by toString() method, always eight digits.
	 */
    private static final DecimalFormat _df = new DecimalFormat("00000000");
    
    /**
	 * key value
	 */
    private long _value;
    
    /**
	 * Generated serial version identifier. 
	 */
	private static final long serialVersionUID = -6162844079966432390L;
}