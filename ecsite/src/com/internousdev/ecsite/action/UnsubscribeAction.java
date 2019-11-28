package com.internousdev.ecsite.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.UnsubscribeDAO;
import com.internousdev.ecsite.dto.UnsubscribeDTO;
import com.opensymphony.xwork2.ActionSupport;

public class UnsubscribeAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;
	private UnsubscribeDAO unsubscribeDAO = new UnsubscribeDAO();
	private ArrayList<UnsubscribeDTO> unsubscribeList = new ArrayList<UnsubscribeDTO>();
	private String deleteFlg;
	private String message;

	public String execute() throws SQLException {
		if (deleteFlg == null) {
			String login_id = session.get("login_user_id").toString();
			unsubscribeList = unsubscribeDAO.getUserInfo(login_id);
		} else if (deleteFlg.equals("1")) {
			delete();
		}
		String result = SUCCESS;
		return result;
	}

	public void delete() throws SQLException {
		String login_id = session.get("login_user_id").toString();
		int res = unsubscribeDAO.userDelete(login_id);
		if (res > 0) {
			unsubscribeList = null;
			setMessage("ご利用ありがとうございました。");
		} else if (res == 0) {
			setMessage("会員情報の削除に失敗しました。");
		}
		session.clear();

	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public ArrayList<UnsubscribeDTO> getUnsubscribeList() {
		return this.unsubscribeList;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getSession() {
		return this.session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
