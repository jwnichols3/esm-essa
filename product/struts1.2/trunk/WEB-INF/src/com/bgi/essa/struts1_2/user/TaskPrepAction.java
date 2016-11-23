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
 * Prepare to service task operations
 * 
 * @struts.action 
 *   name="taskForm" 
 *   path="/user/taskPrepAction"
 *   scope="request" 
 *   validate="false"
 *   
 * @struts.action-forward 
 *   name="browse_task" 
 *   path="task.browse.page"
 * 
 * @struts.action-forward 
 *   name="edit_task" 
 *   path="task.edit.page"
 *   
 * @struts.action-forward 
 *   name="new_task" 
 *   path="task.new.page"
 *   
 * @struts.action-forward 
 *   name="session_reset" 
 *   path="/user/taskPrepAction.do?action=browse"
 *   
 * @struts.action-set-property 
 *   property="cancellable" 
 *   value="false"
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
public final class TaskPrepAction extends AbstractTaskAction {

	/**
	 * Process HTTP request.
	 * 
	 * @param mapping associated ActionMapping
	 * @param form optional ActionForm bean
	 * @param request servlet request
	 * @param response servlet response
	 * @throws Exception if problem (should not happen)
	 */
	@Override
	public ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response) throws Exception {
		_log.debug("entry into TaskPrepAction.execute()");
		
		String forward = StrutsConstantsIf.FAILURE;
		
		try {
			forward = actionLogic(request, (TaskForm) form);
		} catch(Exception exception) {
			_log.error("TaskPrepAction", exception);
		}

		_log.debug("TaskPrepAction forward:" + forward);
		return(mapping.findForward(forward));
	}
	
	/**
	 * action logic
	 * 
	 * @param request from client browser
	 * @param form from struts
	 * @return struts mapping.findForward string
	 */
	private String actionLogic(HttpServletRequest request, TaskForm form) {
		/*
		if (isCancelled(request)) {
			_log.debug("cancellation noted");
			return(StrutsConstantsIf.CANCEL);
		}
		*/
		
		if (form == null) {
			_log.error("null form");
			return(StrutsConstantsIf.FAILURE);
		}
		
		actionPrep(request);
		
		if (action.equals(StrutsConstantsIf.BROWSE)) {			
			session.setAttribute(StrutsConstantsIf.TASK_LIST, selectActiveTask());
			return(StrutsConstantsIf.TASK_BROWSE);
		} else if (action.equals(StrutsConstantsIf.EDIT)) {	
			if (selectTaskForEdit(getKey(request), form)) {
				return(StrutsConstantsIf.TASK_EDIT);
			}
		} else if (action.equals(StrutsConstantsIf.NEW)) {
			return(StrutsConstantsIf.TASK_NEW);
		} else if (action.equals(StrutsConstantsIf.REFRESH)) {
			if (current_task == null) {
				_log.info("session time out");
				return(StrutsConstantsIf.SESSION_RESET);
			}
			
			if (selectTaskForEdit(current_task.getRowId(), form)) {
				return(StrutsConstantsIf.TASK_EDIT);
			}
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