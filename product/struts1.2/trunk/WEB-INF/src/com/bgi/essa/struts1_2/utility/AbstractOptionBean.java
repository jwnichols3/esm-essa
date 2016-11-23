package com.bgi.essa.struts1_2.utility;

import java.io.Serializable;

import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.struts1_2.StrutsConstantsIf;

/**
 * Abstract parent for support of Struts html:optionsCollection (dropdowns).
 * 
 * Supports a single list of string items.
 * 
 * @author G.S. Cole (guycole@gmail.com)
 */
public abstract class AbstractOptionBean implements Serializable {

	/**
	 * Bean for drop down, contains label (displayed string) and value (index).
	 */
	public class CandidateBean implements Serializable {
		private int _ndx = 0;

		private String _label = "overwrite me";

		private Object _payload = null;

		/**
		 * Define the contents of this Candidate
		 * 
		 * @param label label value (drop down contents)
		 * @param ndx origin zero based index into list
		 * @param payload associated raw object
		 */
		public void setCandidate(String label, int ndx, Object payload) {
			_ndx = ndx;
			_label = label;
			_payload = payload;
		}

		/**
		 * Define the contents of this Candidate
		 * 
		 * @param label label value (drop down contents)
		 * @param ndx origin zero based index into list
		 * @param payload associated raw object
		 */
		public void setCandidate(TrimString label, int ndx, Object payload) {
			_ndx = ndx;
			_label = label.getValue();
			_payload = payload;
		}

		/**
		 * html:optionsCollection value (key), zero origin index into list
		 * 
		 * @return key, zero origin index into list
		 */
		public int getNdx() {
			return(_ndx);
		}

		/**
		 * html:optionsCollection label (string key)
		 * 
		 * @return label (string key)
		 */
		public String getLabel() {
			return(_label);
		}

		/**
		 * Associated raw object
		 * 
		 * @return associated raw object
		 */
		public Object getPayload() {
			return(_payload);
		}
		
		/**
		 * Generated serial ID
		 */
		private static final long serialVersionUID = -646976997744413433L;
	}

	/**
	 * Return all candidates
	 * 
	 * @return all candidates
	 */
	public CandidateBean[] getCandidates() {
		return(candidatez);
	}

	/**
	 * Return a specific candidate by index
	 * 
	 * @param arg index
	 */
	public CandidateBean getCandidate(int arg) {
		return(candidatez[arg]);
	}

	/**
	 * Return a specific candidate by label
	 * 
	 * @return a specific candidate by label
	 */
	public CandidateBean getCandidate(String arg) {
		for (int ii = 0; ii < candidatez.length; ii++) {
			if (candidatez[ii].getLabel().equals(arg)) {
				return(candidatez[ii]);
			}
		}

		return(null);
	}

	/**
	 * Return a specific candidate by payload
	 * 
	 * @return a specific candidate by payload
	 */
	public CandidateBean getCandidate(Object arg) {
		for (int ii = 0; ii < candidatez.length; ii++) {
			if (candidatez[ii].getPayload() == null) {
				//not every element will have an object payload
				//"any" items only have labels
				continue;
			}
			
			if (candidatez[ii].getPayload().equals(arg)) {
				return(candidatez[ii]);
			}
		}

		return(null);
	}
	
	/**
	 * Return the "any" candidate
	 * 
	 * @param ndx target array ndx
	 * @return populated bean
	 */
	public CandidateBean getAnyBean(int ndx) {
		CandidateBean result = new CandidateBean();
		result.setCandidate(StrutsConstantsIf.ANY, ndx, null);
		return(result);
	}
	
	/**
	 * Return the "unknown" candidate
	 * 
	 * @param ndx target array ndx
	 * @return populated bean
	 */
	public CandidateBean getUnknownBean(int ndx) {
		CandidateBean result = new CandidateBean();
		result.setCandidate(StrutsConstantsIf.UNKNOWN, ndx, null);
		return(result);
	}
	
	/**
	 * Array of candidates
	 */
	CandidateBean[] candidatez;
}
