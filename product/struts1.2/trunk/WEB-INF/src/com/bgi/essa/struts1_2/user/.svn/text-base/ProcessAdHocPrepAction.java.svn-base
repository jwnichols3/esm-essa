package com.bgi.essa.struts1_2.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bgi.essa.struts1_2.StrutsConstantsIf;
import com.bgi.essa.struts1_2.EssaAction;

/**
 * Service "ad hoc" process test
 * 
 * @struts.action 
 *   name="processAdHocForm" 
 *   path="/user/processAdHocPrepAction"
 *   scope="request" 
 *   validate="false"
 * 
 * @struts.action-forward 
 *   name="new_process" 
 *   path="process.adhoc.page"
 *   
 * @struts.action-set-property 
 *   property="cancellable" 
 *   value="true"
 * 
 * @struts.action-forward 
 *   name="cancel" 
 *   path="generic.cancel.page"
 *   
 * @struts.action-forward 
 *   name="failure" 
 *   path="/jsp/public/genericFailure.jsp"
 * 
 * @struts.action-exception 
 *   key="generic.error"
 *   path="/jsp/public/errors/genericFailure.jsp"
 *   type="com.bgi.essa.shared.exception.EssaException"
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public final class ProcessAdHocPrepAction extends EssaAction {

	/**
	 * Process HTTP request.
	 * 
	 * @param mapping associated ActionMapping
	 * @param form optional ActionForm bean
	 * @param request servlet request
	 * @param response servlet response
	 * @throws Exception if problem
	 */
	@Override
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
		_log.info("entry into ProcessAdHocPrepAction.execute()");

		if (isCancelled(request)) {
			_log.debug("ProcessAdHocPrepAction notes cancellation");
			return(mapping.findForward(StrutsConstantsIf.CANCEL));
		}

		if (form == null) {
			_log.error("null form in ProcessAdHocPrepAction.execute()");
			return(mapping.findForward(StrutsConstantsIf.FAILURE));
		}
		
	//	final ProcessAdHocForm adhoc_form = (ProcessAdHocForm) form;

		actionPrep(request);
		_log.debug("ProcessAdHocPrepAction:" + action);
		
		if (action.equals(StrutsConstantsIf.NEW)) {
			return(mapping.findForward(StrutsConstantsIf.PROCESS_NEW));
		} else {
			_log.error("unknown action:" + action);
		}

		return(mapping.findForward(StrutsConstantsIf.FAILURE));
	}
	
	/**
	 * Define logger
	 */
	private final Log _log = LogFactory.getLog(getClass());
}