package com.bgi.essa.struts1_2.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.bgi.essa.jboss4.client.BusinessDelegate;

import com.bgi.essa.shared.command.BootTimeCtx;

import com.bgi.essa.shared.transfer.BootTimeSampleDTO;
import com.bgi.essa.struts1_2.StrutsConstantsIf;
import com.bgi.essa.struts1_2.EssaAction;

/**
 * Service "ad hoc" boot time operation
 * 
 * @struts.action 
 *   name="bootTimeAdHocForm" 
 *   path="/user/bootTimeAdHocAction"
 *   scope="request" 
 *   validate="false"
 * 
 * @struts.action-forward 
 *   name="adhoc_boot" 
 *   path="boot_time.adhoc.page"
 *   
 * @struts.action-forward 
 *   name="adhoc_boot_response" 
 *   path="boot_time.adhoc.response.page"
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
public final class BootTimeAdHocAction extends EssaAction {

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
		_log.debug("entry into BootTimeAdHocAction.execute()");

		if (isCancelled(request)) {
			_log.debug("BootTimeAdHocAction notes cancellation");
			return(mapping.findForward(StrutsConstantsIf.CANCEL));
		}

		if (form == null) {
			_log.error("null form in BootTimeAdHocAction.execute()");
			return(mapping.findForward(StrutsConstantsIf.FAILURE));
		}
		
		final BootTimeAdHocForm adhoc_form = (BootTimeAdHocForm) form;

		actionPrep(request);
		_log.debug("BootTimeAdHocAction:" + action);
		
		if (action.equals(StrutsConstantsIf.ADHOC)) {
			final BootTimeSampleDTO dto = serviceAdHoc(adhoc_form);
			if (dto == null) {
				_log.info("boot time null");
			} else {
				_log.info("completed:" + dto.getRowId() + ":" + dto);
			}
			session.setAttribute(StrutsConstantsIf.RESPONSE1, dto);
			return(mapping.findForward(StrutsConstantsIf.BOOT_ADHOC_RESPONSE));
		} else if (action.equals(StrutsConstantsIf.PREPARE)) {
			return(mapping.findForward(StrutsConstantsIf.BOOT_ADHOC));
		} else {
			_log.error("unknown action:" + action);
		}

		return(mapping.findForward(StrutsConstantsIf.FAILURE));
	}
	
	/**
	 * Request boot time from JBoss
	 *  
	 * @param arg form arguments or null if problem
	 */
	private BootTimeSampleDTO serviceAdHoc(final BootTimeAdHocForm arg) {
		_log.info(arg.isPersist() + ":" + arg.isEvaluate() + ":" + arg.getNote());
		
		final BootTimeCtx ctx1 = new BootTimeCtx();
		/*
		ctx1.setPersist(arg.isPersist());
		ctx1.setEvaluate(arg.isEvaluate());
		*/
		BootTimeCtx ctx2 = null;
		
		try {
			ctx2 = (BootTimeCtx) _bd.serviceCommand(ctx1);
		} catch(final Exception exception) {
			_log.error("choke", exception);
		}
		
		if (ctx2.isSuccess()) {
			//arg.setValues((BootTimeSampleDTO) ctx2.getSample());
			return((BootTimeSampleDTO) ctx2.getSample());
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
	private final Log _log = LogFactory.getLog(BootTimeAdHocAction.class);
}