package com.bgi.essa.struts1_2.utility;

import java.util.Map;

import com.bgi.essa.shared.primitive.SizeThreshold;

/**
 * Utility support for size threshold drop downs
 * 
 * @author gsc
 */
public final class SizeThresholdOptionBean extends AbstractOptionBean {

	/**
     * Create an array of CandidateBean for use in size threshold drop down
     * 
     * @param arg enable optional labels such as "any" or "unknown"
     */
	public SizeThresholdOptionBean(OptionStunt arg) {
		String[] keyz = SizeThreshold.getSortedKeys();
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
		
		Map<String, SizeThreshold> map = SizeThreshold.getAll();
		for (int ii = 0; ii < map.size(); ii++) {
			CandidateBean cb = new CandidateBean();
			cb.setCandidate(keyz[ii], ndx, map.get(keyz[ii]));
			candidatez[ndx++] = cb;
		}
	}
	
    /**
     * Eclipse generated version ID 
     */
	private static final long serialVersionUID = -8749977722190875605L;
}
