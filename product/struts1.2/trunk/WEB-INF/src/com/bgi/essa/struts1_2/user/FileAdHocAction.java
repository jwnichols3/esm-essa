package com.bgi.essa.struts1_2.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

//import com.bgi.essa.jboss4.client.BusinessDelegate;

//import com.bgi.essa.shared.primitive.TrimString;

//import com.bgi.essa.shared.transfer.FileSampleDTO;

import com.bgi.essa.struts1_2.StrutsConstantsIf;
import com.bgi.essa.struts1_2.EssaAction;

/**
 * Service "ad hoc" file test operation
 * 
 * @struts.action 
 *   name="fileAdHocForm" 
 *   path="/user/fileAdHocAction"
 *   scope="request" 
 *   validate="false"
 * 
 * @struts.action-forward 
 *   name="adhoc_file" 
 *   path="file.adhoc.page"
 *   
 * @struts.action-forward 
 *   name="adhoc_file_response" 
 *   path="file.adhoc.response.page"
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
public final class FileAdHocAction extends EssaAction {

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
		_log.debug("entry into FileAdHocAction.execute()");

		if (isCancelled(request)) {
			_log.debug("FileAdHocAction notes cancellation");
			return(mapping.findForward(StrutsConstantsIf.CANCEL));
		}

		if (form == null) {
			_log.error("null form in FileAdHocAction.execute()");
			return(mapping.findForward(StrutsConstantsIf.FAILURE));
		}
		
		//final FileAdHocForm adhoc_form = (FileAdHocForm) form;

		actionPrep(request);
		_log.debug("FileAdHocAction:" + action);
		
		if (action.equals(StrutsConstantsIf.ADHOC)) {
			/*
			final FileSampleDTO dto = serviceAdHoc(adhoc_form);
			if (dto == null) {
				_log.info("file sample null");
			} else {
				_log.info(dto);
			}
			session.setAttribute(StrutsConstantsIf.RESPONSE1, dto);
			return(mapping.findForward(StrutsConstantsIf.FILE_ADHOC_RESPONSE));
			*/
		} else if (action.equals(StrutsConstantsIf.PREPARE)) {
			return(mapping.findForward(StrutsConstantsIf.FILE_ADHOC_NEW));
		} else {
			_log.error("unknown action:" + action);
		}

		return(mapping.findForward(StrutsConstantsIf.FAILURE));
	}
	
	/**
	 * 
	 * @param arg
	 */
	/*
	private FileSampleDTO serviceAdHoc(final FileAdHocForm arg) {
		_log.info(arg.isPersist() + ":" + arg.isEvaluate() + ":" + arg.getNote());
		
		final FileSampleCtx ctx1 = new FileSampleCtx();
		ctx1.setPersist(arg.isPersist());
		ctx1.setEvaluate(arg.isEvaluate());
	
		ctx1.setName(new TrimString("/etc/passwd"));
		
		FileSampleCtx ctx2 = null;
		try {
			ctx2 = (FileSampleCtx) _bd.serviceCommand(ctx1);
		} catch(final Exception exception) {
			_log.error("choke", exception);
		}
		
		java.util.Iterator iii = null;
		java.util.Set set = null;

		set = ctx1.keySet();
		_log.info("ctx1 population:" + set.size());
		
		iii = set.iterator();
		while(iii.hasNext()) {
			final Object oo = iii.next();
			_log.info(oo + ":" + ctx1.get(oo));
		}
		
		set = ctx2.keySet();
		_log.info("ctx2 population:" + set.size());
		
		iii = set.iterator();
		while(iii.hasNext()) {
			final Object oo = iii.next();
			_log.info(oo + ":" + ctx2.get(oo));
		}
		
		if (ctx2.isSuccess()) {
			_log.info("succssess huzza:" + ctx2.getSample());
			return((FileSampleDTO) ctx2.getSample());
		} else {
			_log.info("success failure");	
		}
			
		return(null);
	}
*/

	/**
	 * Handle to back end services
	 */
	//private final BusinessDelegate _bd = new BusinessDelegate();

	/**
	 * Define logger
	 */
	private final Log _log = LogFactory.getLog(FileAdHocAction.class);
}