package com.bgi.essa.struts1_2.utility;

import java.util.Map;

import com.bgi.essa.shared.primitive.ProcessThreshold;

/**
 * Utility support for process threshold drop downs
 * 
 * @author gsc
 */
public final class ProcessThresholdOptionBean extends AbstractOptionBean {

	/**
     * Create an array of CandidateBean for use in process threshold drop down
     * 
     * @param arg enable optional labels such as "any" or "unknown"
     */
	public ProcessThresholdOptionBean(OptionStunt arg) {
		String[] keyz = ProcessThreshold.getSortedKeys();
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
		
		Map<String, ProcessThreshold> map = ProcessThreshold.getAll();
		for (int ii = 0; ii < map.size(); ii++) {
			CandidateBean cb = new CandidateBean();
			cb.setCandidate(keyz[ii], ndx, map.get(keyz[ii]));
			candidatez[ndx++] = cb;
		}
	}
	
    /**
     * Eclipse generated version ID 
     */
	private static final long serialVersionUID = -8865214945781160246L;
}
