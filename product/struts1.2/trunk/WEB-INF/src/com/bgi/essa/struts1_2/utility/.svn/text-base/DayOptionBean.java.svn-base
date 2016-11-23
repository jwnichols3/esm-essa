package com.bgi.essa.struts1_2.utility;

import java.util.Map;

import com.bgi.essa.shared.primitive.Day;

/**
 * Utility support for Day drop down
 * 
 * @author coleguy
 */
public final class DayOptionBean extends AbstractOptionBean {

	/**
     * Create an array of CandidateBean for use in day drop down
     * 
     * @param arg enable optional labels such as "any" or "unknown"
     */
	public DayOptionBean(OptionStunt arg) {
		String[] keyz = Day.getSortedKeys();
		int limit = keyz.length;
		int ndx = 0;
		
		if (arg.equals(OptionStunt.ANY)) {
			limit += 1;
			candidatez = new CandidateBean[limit];
			candidatez[ndx] = getAnyBean(ndx);
			++ndx;
		} else if (arg.equals(OptionStunt.NONE)) {
			candidatez = new CandidateBean[limit];
		} else if (arg.equals(OptionStunt.UNKNOWN)) {
			limit += 1;
			candidatez = new CandidateBean[limit];
			candidatez[ndx] = getUnknownBean(ndx);
			++ndx;
		} else {
			throw new IllegalArgumentException("unknown stunt:" + arg);
		}
		
		Map<String, Day> map = Day.getAll();
		for (int ii = 0; ii < map.size(); ii++) {
			CandidateBean cb = new CandidateBean();
			cb.setCandidate(keyz[ii], ndx, map.get(keyz[ii]));
			candidatez[ndx++] = cb;
		}
	}
	
    /**
     * Eclipse generated version ID 
     */
	private static final long serialVersionUID = -4019169684944807778L;
}
