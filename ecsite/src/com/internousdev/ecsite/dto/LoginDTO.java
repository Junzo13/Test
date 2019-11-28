package com.internousdev.ecsite.dto;
//複数のクラスを分類・管理する構文

public class LoginDTO {
	private String loginId;
	private String loginPassword;
	private String userName;
	private boolean loginFlg = false;
	// フィールド変数を宣言
	// boolean(trueまたはfalseのどちらかのデータが必ず入ることが決まっているデータ型)
	/*
	 * 基本的にloginFlgをfalseにしておいて、 LoginDAOである条件でtrueとなった場合のみ、 ログイン状態がオンで継続される
	 */

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean getLoginFlg() {
		return loginFlg;
	}

	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}

}
