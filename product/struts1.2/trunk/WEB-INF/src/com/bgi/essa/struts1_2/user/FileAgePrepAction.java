package com.bgi.essa.struts1_2.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bgi.essa.shared.primitive.SelectOption;
import com.bgi.essa.struts1_2.StrutsConstantsIf;

/**
 * Prepare to service "file age" rule operations
 * 
 * @struts.action 
 *   name="fileAgeForm" 
 *   path="/user/fileAgePrepAction"
 *   scope="request" 
 *   validate="false"
 *
 * @struts.action-forward 
 *   name="audit_rule" 
 *   path="file_age.audit.page"
 *   
 * @struts.action-forward 
 *   name="browse_rule" 
 *   path="file_age.browse.page"
 *   
 * @struts.action-forward 
 *   name="browse_sample" 
 *   path="file_age.sample.page"
 * 
 * @struts.action-forward 
 *   name="edit_rule" 
 *   path="file_age.edit.page"
 *   
 * @struts.action-forward 
 *   name="new_rule" 
 *   path="file_age.new.page"
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
 *   path="generic.cancel.page"
 *   
 * @struts.action-forward 
 *   name="failure" 
 *   path="generic.failure.page"
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public final class FileAgePrepAction extends AbstractFileAgeAction {

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
		_log.debug("entry into FileAgePrepAction.execute()");

		String forward = StrutsConstantsIf.FAILURE;
		
		try {
			forward = actionLogic(request, (FileAgeForm) form);
		} catch(Exception exception) {
			_log.error("FileAgePrepAction", exception);
		}

		_log.debug("FileAgePrepAction forward:" + forward);
		return(mapping.findForward(forward));
	}

	/**
	 * action logic
	 * 
	 * @param request from client browser
	 * @param form from struts
	 * @return struts mapping.findForward string
	 */
	private String actionLogic(HttpServletRequest request, FileAgeForm form) {
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
		
		if (action.equals(StrutsConstantsIf.AUDIT)) {
			session.setAttribute(StrutsConstantsIf.AUDIT_LIST, selectAudit(SelectOption.SELECT_ALL));
			return(StrutsConstantsIf.RULE_AUDIT);
		} else if (action.equals(StrutsConstantsIf.BROWSE)) {
			session.setAttribute(StrutsConstantsIf.RULE_LIST, selectRules(SelectOption.SELECT_ALL));
			return(StrutsConstantsIf.RULE_BROWSE);
		} else if (action.equals(StrutsConstantsIf.EDIT)) {
			if (selectRuleForEdit(getKey(request), form)) {
				return(StrutsConstantsIf.RULE_EDIT);
			}
		} else if (action.equals(StrutsConstantsIf.NEW)) {
			return(StrutsConstantsIf.RULE_NEW);
		} else if (action.equals(StrutsConstantsIf.SAMPLE)) {
			session.setAttribute(StrutsConstantsIf.SAMPLE_LIST, selectSamples(getKey(request), SelectOption.SELECT_ALL));
			return(StrutsConstantsIf.SAMPLE_BROWSE);
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