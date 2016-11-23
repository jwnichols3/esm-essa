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
 * Service configuration upload
 * 
 * @struts.action 
 *   name="configurationForm" 
 *   path="/user/configurationPrepAction"
 *   scope="request" 
 *   validate="false"
 *   
 * @struts.action-forward 
 *   name="dump_configuration" 
 *   path="/jsp/public/rawDump.jsp"
 *   
 * @struts.action-forward 
 *   name="new_configuration" 
 *   path="configuration.upload.page"
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
public final class ConfigurationPrepAction extends AbstractConfigurationAction {

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
		_log.info("entry into ConfigurationPrepAction.execute()");
		
		String forward = StrutsConstantsIf.FAILURE;
		
		try {
			forward = actionLogic(request, (ConfigurationForm) form);
		} catch(Exception exception) {
			_log.error("ConfigurationPrepAction", exception);
		}

		_log.info("ConfigurationPrepAction forward:" + forward);
		return(mapping.findForward(forward));
	}
	
	/**
	 * action logic
	 * 
	 * @param request from client browser
	 * @param form from struts
	 * @return struts mapping.findForward string
	 */
	private String actionLogic(HttpServletRequest request, ConfigurationForm form) {
		if (isCancelled(request)) {
			_log.debug("cancellation noted");
			return(StrutsConstantsIf.CANCEL);
		}
		
		if (form == null) {
			_log.error("null form");
			return(StrutsConstantsIf.FAILURE);
		}

		actionPrep(request);	
		
		//note the absence of test for current session, no task for this operation
		
		if (action.equals(StrutsConstantsIf.DUMP)) {	
			request.setAttribute(StrutsConstantsIf.BROWSE_LIST, dumpAll());
			return(StrutsConstantsIf.CONFIGURATION_DUMP);
		} else if (action.equals(StrutsConstantsIf.NEW)) {	
			return(StrutsConstantsIf.CONFIGURATION_NEW);
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