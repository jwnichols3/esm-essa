package com.bgi.essa.shared.primitive;

/**
 * Define String which cannot be null or empty. Trims whitespace.
 * 
 * @author gsc
 */
public final class TrimString implements Comparable<Object>, ValueTypeIf {

	/**
	 * Ctor w/initialization
	 * 
	 * @param arg non-null string w/1 or more characters. Whitespace will be trimmed.
	 * @throws NullPointerException if null arg
	 * @throws IllegalArgumentException if arg length < 1
	 */
	public TrimString(final String arg) {
		if (arg == null) {
			throw new NullPointerException("null TrimString.ctor");
		}

		_string = arg.trim();

		if (_string.length() < 1) {
			throw new IllegalArgumentException("zero length trim string");
		}
	}

	/**
	 * Ctor w/initialization
	 * 
	 * @param arg non-null TrimString object
	 * @throws NullPointerException if null arg
	 */
	public TrimString(final TrimString arg) {
		if (arg == null) {
			throw new NullPointerException("null TrimString.ctor");
		}

		_string = arg.getValue();
	}

	/**
	 * Return string value
	 * 
	 * @return string value
	 */
	public String getValue() {
		return(_string);
	}

	/**
	 * Return string value
	 * 
	 * @return string value
	 */
	public String getUpperCaseValue() {
	    return(_string.toUpperCase());
	}
	
	/**
	 * Convert the string value to upper case
	 */
	public void toUpperCase() {
		_string = _string.toUpperCase();
	}

	/**
	 * Creates and returns a copy of this object
	 * 
	 * @return populated copy of this object
	 */
	@Override
	public Object clone() {
		return(new TrimString(_string));
	}

	/**
	 * Return hash code value for this object
	 * 
	 * @return hash code value for this object
	 */
	@Override
	public int hashCode() {
		return(29 * _string.hashCode());
	}

	/**
	 * Return true if this object is not null and has equal text content
	 * 
	 * @return true if this object is not null and has equal text content
	 * @throws ClassCastException if arg cannot be cast to String or TrimString
	 */
	@Override
	public boolean equals(final Object arg) {
		if (arg == null) {
			return(false);
		}
		
		if (arg instanceof String) {
			return(_string.equals(arg));
		}

		return(_string.equals(((TrimString) arg).getValue()));
	}

	/**
	 * Compare this object w/the specified object.
	 * 
	 * @return -1 (less than), 0 (equals), 1 (greater than)
	 * @throws ClassCastException if arg cannot be cast
	 */
	public int compareTo(final Object arg) {
		final TrimString ts = (TrimString) arg;
		
		final int result = _string.compareTo(ts.getValue());
		
		if (result < 0) {
			return(-1);
		} else if (result > 0) {
			return(1);
		}
		
		return(0);
	}

	/**
	 * Return object state as a string
	 * 
	 * @return object state as a string
	 */
	@Override
	public String toString() {
		return(_string);
	}
	
	/**
	 * Return XML escaped value
	 * 
	 * @return XML escaped value
	 */
	public String toXml() {
		StringBuilder result = new StringBuilder();
		
		int limit = _string.length();
		for (int ii = 0; ii < limit; ii++) {
			char cc = _string.charAt(ii);
			
			if (cc == '<') {
				result.append("&lt;");
			} else if (cc == '>') {
				result.append("&gt;");
			} else if (cc == '&') {
				result.append("&amp;");
			} else if (cc == '"') {
				result.append("&quot;");
			} else if (cc == '\'') {
				result.append("&apos;");
			} else {
				result.append(cc);
			}
		}
		
		return(result.toString());
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
	 * free form content
	 */
	private String _string;
	
	/**
	 * Generated serial version identifier. 
	 */
	private static final long serialVersionUID = 6644053833636085776L;
}