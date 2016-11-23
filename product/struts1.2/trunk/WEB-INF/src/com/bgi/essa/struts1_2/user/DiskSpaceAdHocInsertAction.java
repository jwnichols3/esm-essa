package com.bgi.essa.struts1_2.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.command.JniStatVfsCtx;

import com.bgi.essa.shared.primitive.TrimString;

import com.bgi.essa.shared.transfer.StatVfsDTO;

import com.bgi.essa.struts1_2.StrutsConstantsIf;
import com.bgi.essa.struts1_2.EssaAction;

/**
 * Service "ad hoc" disk space operation
 * 
 * @struts.action 
 *   name="diskSpaceAdHocForm"
 *   path="/user/diskSpaceAdHocInsertAction"
 *   input="disk_space.adhoc.page"
 *   scope="request" 
 *   validate="true"
 *   
 * @struts.action-forward 
 *   name="fs_size_response" 
 *   path="disk_space.adhoc.response.page"
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
public final class DiskSpaceAdHocInsertAction extends EssaAction {

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
		_log.debug("entry into DiskSpaceAdHocInsertAction.execute()");

		if (isCancelled(request)) {
			_log.debug("DiskSpaceAdHocInsertAction notes cancellation");
			return(mapping.findForward(StrutsConstantsIf.CANCEL));
		}

		if (form == null) {
			_log.error("null form in DiskSpaceAdHocInsertAction.execute()");
			return(mapping.findForward(StrutsConstantsIf.FAILURE));
		}
		
		final DiskSpaceAdHocForm adhoc_form = (DiskSpaceAdHocForm) form;

		actionPrep(request);
		_log.debug("DiskSpaceAdHocInsertAction:" + action);
		
		if (action.equals(StrutsConstantsIf.ADHOC)) {
			final StatVfsDTO dto = serviceAdHoc(adhoc_form);
			if (dto == null) {
				_log.info("file system size null");
			} else {
				_log.info("completed:" + dto.getRowId() + ":" + dto);
			}
			session.setAttribute(StrutsConstantsIf.RESPONSE1, dto);
			return(mapping.findForward(StrutsConstantsIf.FS_SIZE_ADHOC_RESPONSE));
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
	private StatVfsDTO serviceAdHoc(final DiskSpaceAdHocForm arg) {
		_log.info(arg.isPersist() + ":" + arg.isEvaluate() + ":" + arg.getNote());
		
		final JniStatVfsCtx ctx1 = new JniStatVfsCtx();
		ctx1.setName(new TrimString(arg.getName()));
		/*
		ctx1.setPersist(arg.isPersist());
		ctx1.setEvaluate(arg.isEvaluate());
*/
		JniStatVfsCtx ctx2 = null;
		
		try {
			ctx2 = (JniStatVfsCtx) _bd.serviceCommand(ctx1);
		} catch(final Exception exception) {
			_log.error("choke", exception);
		}
		
		if (ctx2.isSuccess()) {
			return((StatVfsDTO) ctx2.getSample());
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
	private final Log _log = LogFactory.getLog(DiskSpaceAdHocInsertAction.class);
}