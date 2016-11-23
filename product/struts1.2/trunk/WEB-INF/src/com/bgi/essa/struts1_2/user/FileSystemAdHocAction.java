package com.bgi.essa.struts1_2.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.command.FileSystemCtx;

import com.bgi.essa.shared.transfer.FileSystemSampleDTO;

import com.bgi.essa.struts1_2.StrutsConstantsIf;
import com.bgi.essa.struts1_2.EssaAction;

/**
 * Service "ad hoc" file system discovery
 * 
 * @struts.action 
 *   name="fileSystemAdHocForm" 
 *   path="/user/fileSystemAdHocAction"
 *   scope="request" 
 *   validate="false"
 * 
 * @struts.action-forward 
 *   name="adhoc_file_system" 
 *   path="file_system.adhoc.page"
 *   
 * @struts.action-forward 
 *   name="adhoc_file_system_response" 
 *   path="file_system.adhoc.response.page"
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
public final class FileSystemAdHocAction extends EssaAction {

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
		_log.debug("entry into FileSystemAdHocAction.execute()");

		if (isCancelled(request)) {
			_log.debug("FileSystemAdHocAction notes cancellation");
			return(mapping.findForward(StrutsConstantsIf.CANCEL));
		}

		if (form == null) {
			_log.error("null form in FileSystemAdHocAction.execute()");
			return(mapping.findForward(StrutsConstantsIf.FAILURE));
		}
		
		final FileSystemAdHocForm adhoc_form = (FileSystemAdHocForm) form;

		actionPrep(request);
		_log.debug("FileSystemAdHocAction:" + action);
		
		if (action.equals(StrutsConstantsIf.ADHOC)) {
			final FileSystemSampleDTO dto = serviceAdHoc(adhoc_form);
			if (dto == null) {
				_log.info("file system null");
			} else {
				_log.info("completed:" + dto.getRowId() + ":" + dto);
			}
			
			System.out.println("xxx xxx xxx:" + dto.getCandidates().size());
			
			session.setAttribute(StrutsConstantsIf.RESPONSE1, dto);
			session.setAttribute(StrutsConstantsIf.RESPONSE2, dto.getCandidates());
			return(mapping.findForward(StrutsConstantsIf.FILE_SYSTEM_ADHOC_RESPONSE));
		} else if (action.equals(StrutsConstantsIf.PREPARE)) {
			return(mapping.findForward(StrutsConstantsIf.FILE_SYSTEM_ADHOC));
		} else {
			_log.error("unknown action:" + action);
		}

		return(mapping.findForward(StrutsConstantsIf.FAILURE));
	}
	
	/**
	 * Request file systems from JBoss
	 *  
	 * @param arg form arguments or null if problem
	 */
	private FileSystemSampleDTO serviceAdHoc(final FileSystemAdHocForm arg) {
		_log.info(arg.isPersist() + ":" + arg.isEvaluate() + ":" + arg.getNote());
		
		final FileSystemCtx ctx1 = new FileSystemCtx();
		/*
		ctx1.setPersist(arg.isPersist());
		ctx1.setEvaluate(arg.isEvaluate());
		*/
		FileSystemCtx ctx2 = null;
		
		try {
			ctx2 = (FileSystemCtx) _bd.serviceCommand(ctx1);
		} catch(final Exception exception) {
			_log.error("choke", exception);
		}
		
		if (ctx2.isSuccess()) {
			return((FileSystemSampleDTO) ctx2.getSample());
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
	private final Log _log = LogFactory.getLog(FileSystemAdHocAction.class);
}