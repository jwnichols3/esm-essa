package com.bgi.essa.shared.primitive;

/**
 * Fake boolean type to pacify Apache Derby.
 * 
 * Immutable value type.
 * 
 * @author gsc
 */
public final class FauxBoolean implements Comparable<Object>, ValueTypeIf {

	/**
	 * Ctor w/initialization
	 * 
	 * @param arg boolean value
	 */
    public FauxBoolean(boolean arg) {
        _value = arg;
    }
    
    /**
	 * Ctor w/initialization
	 * 
	 * @param arg boolean value as a char Y/N or T/F
	 */
    public FauxBoolean(char arg) {
    	if ((arg == 'y') || (arg == 'Y') || (arg == 't') || (arg == 'T')) {
    		_value = true;
    	} else if ((arg == 'n') || (arg == 'N') || (arg == 'f') || (arg == 'F')) {
    		_value = false;
    	} else {
            throw new IllegalArgumentException("FauxBoolean bad character");
        }
    }
    
    /**
	 * Ctor w/initialization
	 * 
	 * @param arg boolean value as a char Y/N or T/F
	 * @throws NullPointerException if null arg
	 */
    public FauxBoolean(String arg) {
        if (arg == null) {
            throw new NullPointerException("null FauxBoolean.ctor");
        }
        
    	if (arg.equals("y") || arg.equals("Y") || arg.equals("t") || arg.equals("T")) {
    		_value = true;
    	} else if (arg.equals("n") || arg.equals("N") || arg.equals("f") || arg.equals("F")) {
    		_value = false;
    	} else {
            throw new IllegalArgumentException("FauxBoolean bad character");
        }
    }   
    
    /**
	 * Ctor w/initialization
	 * 
	 * @param arg value to copy
	 * @throws NullPointerException if null arg
	 */
    public FauxBoolean(FauxBoolean arg) {
        if (arg == null) {
            throw new NullPointerException("null FauxBoolean.ctor");
        }
        
        _value = arg.getBooleanValue().booleanValue();
    }
    
    /**
     * Return true if true
     * 
     * @return true if true
     */
    public boolean isTrue() {
    	return(_value);
    }
   
    /**
	 * Return value as a character
	 * 
	 * @return value as character
	 */
    public char getValue() {
    	if (_value) {
    		return('T');
    	}
    	
    	return('F');
    }
    
    /**
	 * Return value as Boolean
	 * 
	 * @return value as Boolean
	 */
    public Boolean getBooleanValue() {
        return(new Boolean(_value));
    }
    
    /**
	 * Return value as a string
	 * 
	 * @return value as string
	 */
    public String getStringValue() {
    	if (_value) {
    		return("T");
    	}
    	
    	return("F");
    }

    /**
	 * Creates and returns a copy of this object
	 * 
	 * @return populated copy of this object
	 */
	public Object clone() {
        return(new FauxBoolean(_value));
    }
    
    /**
	 * Return hash code for this object
	 * 
	 * @return hash code for this object
	 */
	public int hashCode() {
        Boolean temp = new Boolean(_value);
        return(13 * temp.hashCode());
    } 
    
    /**
	 * Return true if the values match
	 * 
	 * @param arg test candidate, will be cast to FauxBoolean
	 * @return true if the key values match
	 * @throws ClassCastException if arg cannot be cast to FauxBoolean
	 */
	public boolean equals(Object arg) {
        if (arg == null) {
            return(false);
        }
        
    	FauxBoolean fb = (FauxBoolean) arg;
    	if (_value == fb.getBooleanValue().booleanValue()) {
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
    	FauxBoolean fb = (FauxBoolean) arg;
    	if (_value == fb.getBooleanValue().booleanValue()) {
    		return(0);
    	}
 
        return(1);
    }

    /**
	 * Return object state as a string
	 * 
	 * @return object state as a string
	 */
	public String toString() {
		if (_value) {
			return("true");
		}
		
		return("false");  
    }
	
	/**
	 * Return object state as a XML formatted string 
	 * 
	 * @return object state as a XML formatted string
	 */
	public String toXml() {
		return(toString());
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
	 * key value
	 */
    private boolean _value;
    
    /**
	 * Generated serial version identifier. 
	 */
	private static final long serialVersionUID = -2965533913751256171L;
}
