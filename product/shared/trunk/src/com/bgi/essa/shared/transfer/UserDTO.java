package com.bgi.essa.shared.transfer;

import com.bgi.essa.shared.primitive.ConstantsIf;
import com.bgi.essa.shared.primitive.TrimString;

/**
 * Place holder for user attributes (when authentication is implemented)
 * 
 * @author coleguy
 */
public class UserDTO {

	/**
	 * user name
	 */
	private TrimString _name = new TrimString(ConstantsIf.EMPTY_STRING);

	/**
	 * Return the user name
	 * 
	 * @return user name
	 */
	public TrimString getName() {
		return(_name);
	}

	/**
	 * Define the user name
	 * 
	 * @param arg user name
	 * @throws NullPointerException if null arg
	 */
	public void setName(TrimString arg) {
		if (arg == null) {
			throw new NullPointerException("null file name");
		}
		
		_name = new TrimString(arg);
	}
}
