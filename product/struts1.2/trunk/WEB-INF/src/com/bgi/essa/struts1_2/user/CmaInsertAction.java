package com.bgi.essa.struts1_2.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bgi.essa.struts1_2.StrutsConstantsIf;

/**
 * Insert new CMA attribute
 * 
 * @struts.action 
 *   name="cmaForm" 
 *   path="/user/cmaInsertAction"
 *   input="cma.new.page" 
 *   scope="request" 
 *   validate="true"
 *
 * @struts.action-forward 
 *   name="failed_attribute" 
 *   path="cma.failure.page"
 *   
 * @struts.action-forward 
 *   name="success_attribute" 
 *   path="/user/taskPrepAction.do?action=refresh"
 * 
 * @struts.action-forward 
 *   name="session_reset" 
 *   path="/user/taskPrepAction.do?action=browse"
 *   
 * @struts.action-set-property 
 *   property="cancellable" 
 *   value="true"
 * 
 * @struts.action-forward 
 *   name="cancel" 
 *   path="/user/taskPrepAction.do?action=refresh"
 * 
 * @struts.action-forward 
 *   name="failure" 
 *   path="generic.failure.page"
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public final class CmaInsertAction extends AbstractCmaAction {

	/**
	 * Process HTTP request.
	 * 
	 * @param mapping associated ActionMapping
	 * @param form optional ActionForm bean
	 * @param request servlet request
	 * @param response servlet response
	 * @throws Exception if problem (should never happen)
	 */
	@Override
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
		_log.info("entry into CmaInsertAction.execute()");
	
		String forward = StrutsConstantsIf.FAILURE;
		
		try {
			forward = actionLogic(request, (CmaForm) form);
		} catch(Exception exception) {
			_log.error("CmaInsertAction", exception);
		}

		_log.info("CmaInsertAction forward:" + forward);
		return(mapping.findForward(forward));
	}

	/**
	 * action logic
	 * 
	 * @param request from client browser
	 * @param form from struts
	 * @return struts mapping.findForward string
	 */
	private String actionLogic(HttpServletRequest request, CmaForm form) {
		if (isCancelled(request)) {
			_log.debug("cancellation noted");
			return(StrutsConstantsIf.CANCEL);
		}
		
		if (form == null) {
			_log.error("null form");
			return(StrutsConstantsIf.FAILURE);
		}
		
		actionPrep(request);
		
		if (current_task == null) {
			_log.info("session time out");
			return(StrutsConstantsIf.SESSION_RESET);
		}
		
		if (action.equals(StrutsConstantsIf.INSERT)) {
			if (performAttributeInsert(form.getValue())) {
				return(StrutsConstantsIf.ATTRIBUTE_SUCCESS);
			}
			
			return(StrutsConstantsIf.ATTRIBUTE_FAILURE);
		} else {
			_log.error("unknown action:" + action);
		}
		
		return(StrutsConstantsIf.FAILURE);
	}
	
	/**
	 * Define logger
	 */
	private final Log _log = LogFactory.getLog(getClass());
}