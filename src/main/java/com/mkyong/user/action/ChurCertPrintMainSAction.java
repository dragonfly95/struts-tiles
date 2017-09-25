package onnuri.acts29.chur.actions;


import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import onnuri.acts29.chur.dao.DutyDAO;
import onnuri.acts29.common.util.ListHandler;
import onnuri.acts29.login.actions.SignonDispatchAction;
import onnuri.acts29.common.util.RequestToHash;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


public class ChurCertPrintMainSAction extends SignonDispatchAction {

	private DutyDAO dutyDAO;
	private DutyManager dutyManager;

  public ChurCertPrintMainSAction() {
  	dutyDAO = new DutyDAO();
		dutyManager = new DutyManager();
	}

	public ActionForward first(
					ActionMapping mapping,	ActionForm form,
					HttpServletRequest request,	HttpServletResponse response) throws Exception {
		return unspecified(mapping,form,request,response);
	}


	public ActionForward view(
					ActionMapping mapping,	ActionForm form,
	  HttpServletRequest request,	HttpServletResponse response) throws Exception {
		return mapping.findForward("view");
	}


	protected ActionForward unspecified(
					ActionMapping mapping,	ActionForm form,
					HttpServletRequest request,	HttpServletResponse response) throws Exception
	{
		String cpage = request.getParameter("cpage");

		if("".equals(cpage) || cpage == null) {
			cpage = "1";
			map.put("cpage", new Integer(cpage));
		}

		if(!"".equals(map.get("key"))) {
			if("sname".equals(map.get("key"))) map.put("sname", map.get("keyword"));
			if("j_chSearch".equals(map.get("key"))) map.put("j_chSearch", map.get("keyword"));
		}


		map.put("kk_code", kkCode);

		ListHandler listHandler = new ListHandler();
		map.put("pageSize", new Integer(listHandler.getPageSize()));


		int totalCount = dutyManager.getTotalCount(map);
		request.setAttribute("CertList", dutyManager.getDutyList(map));
		request.setAttribute("CertTotal",new Integer(totalCount));

		listHandler.setCpage(new Integer(cpage).intValue());
		listHandler.setTotal(totalCount);
		listHandler.setPageSize(listHandler.getPageSize());
		listHandler.setLink("./churCertPrintMainS.do?act=first");

		request.setAttribute("numbering", listHandler.getNumbering());
		return mapping.findForward("executeQueryForList");
	}

}
