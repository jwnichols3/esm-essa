package com.bgi.essa.struts1_2.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.command.DirectorySizeCtx;

//import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.DirectorySizeSampleDTO;

import com.bgi.essa.struts1_2.StrutsConstantsIf;
import com.bgi.essa.struts1_2.EssaAction;

/**
 * Service "ad hoc" directory operation
 * 
 * @struts.action 
 *   name="directorySizeAdHocForm"
 *   path="/user/directorySizeAdHocInsertAction"
 *   input="directory_size.adhoc.page"
 *   scope="request" 
 *   validate="true"
 *   
 * @struts.action-forward 
 *   name="directory_size_response" 
 *   path="directory_size.adhoc.response.page"
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
public final class DirectorySizeAdHocInsertAction extends EssaAction {

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
		_log.debug("entry into DirectorySizeAdHocInsertAction.execute()");

		if (isCancelled(request)) {
			_log.debug("DirectoryAdHocInsertAction notes cancellation");
			return(mapping.findForward(StrutsConstantsIf.CANCEL));
		}

		if (form == null) {
			_log.error("null form in DirectorySizeAdHocInsertAction.execute()");
			return(mapping.findForward(StrutsConstantsIf.FAILURE));
		}
		
		final DirectorySizeAdHocForm dirsize_form = (DirectorySizeAdHocForm) form;

		actionPrep(request);
		_log.debug("DirectorySizeAdHocInsertAction:" + action);
		
		if (action.equals(StrutsConstantsIf.ADHOC)) {
			final DirectorySizeSampleDTO dto = serviceAdHoc(dirsize_form);
			if (dto == null) {
				_log.info("directory size null");
			} else {
				_log.info("completed:" + dto.getRowId() + ":" + dto);
			}
			session.setAttribute(StrutsConstantsIf.RESPONSE1, dto);
			return(mapping.findForward(StrutsConstantsIf.DIRECTORY_SIZE_ADHOC_RESPONSE));
		} else {
			_log.error("unknown action:" + action);
		}

		return(mapping.findForward(StrutsConstantsIf.FAILURE));
	}
	
	/**
	 * Request directory size information
	 *  
	 * @param arg form arguments or null if problem
	 */
	private DirectorySizeSampleDTO serviceAdHoc(final DirectorySizeAdHocForm arg) {
		_log.info(arg.isPersist() + ":" + arg.isEvaluate() + ":" + arg.getNote());
		
		final DirectorySizeCtx ctx1 = new DirectorySizeCtx();
		/*
		ctx1.setName(new TrimString(arg.getName()));
		ctx1.setRecursive(arg.isRecursive());
		ctx1.setPersist(arg.isPersist());
		ctx1.setEvaluate(arg.isEvaluate());
*/
		DirectorySizeCtx ctx2 = null;
		
		try {
			ctx2 = (DirectorySizeCtx) _bd.serviceCommand(ctx1);
		} catch(final Exception exception) {
			_log.error("choke", exception);
		}
		
		if (ctx2.isSuccess()) {
			return((DirectorySizeSampleDTO) ctx2.getSample());
		} 
		
		return(null);
	}

	/**
	 * Handle to back end services
	 */
	private final BusinessDelegate _bd = new BusinessDelegate();

	/**
	 * Define logger
	 */
	private final Log _log = LogFactory.getLog(DirectorySizeAdHocInsertAction.class);
}