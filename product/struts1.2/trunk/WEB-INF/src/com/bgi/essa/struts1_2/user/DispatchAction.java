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
 * No work is performed, simply pass through to the appropriate page.
 * 
 * @struts.action 
 *   path="/user/dispatchAction"
 * 
 * @struts.action-forward 
 *   name="refresh" 
 *   path="/user/taskPrepAction.do?action=refresh"
 *   
 * @struts.action-forward 
 *   name="welcome" 
 *   path="welcome.page"
 * 
 * @struts.action-forward 
 *   name="failure" 
 *   path="generic.failure.page"
 * 
 * @author G.S. Cole (guycole at gmail dot com)
 */
public final class DispatchAction extends EssaAction {

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
		_log.debug("entry into DispatchAction.execute()");

		actionPrep(request);
		
		_log.debug("DispatchAction:" + action);

		if (action.equals(StrutsConstantsIf.REFRESH)) {
			return(mapping.findForward(StrutsConstantsIf.REFRESH));
		} else if (action.equals(StrutsConstantsIf.WELCOME)) {
			return(mapping.findForward(StrutsConstantsIf.WELCOME));
		} else {
			_log.error("unknown action:" + action);
		}

		return(mapping.findForward(StrutsConstantsIf.FAILURE));
	}
    
    /**
     * Define logger
     */
    private static final Log _log = LogFactory.getLog(DispatchAction.class);
}