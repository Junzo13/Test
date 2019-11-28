package com.internousdev.ecsite.action;

//複数のクラスを分類・管理する構文
import java.util.Map;

//Mapコレクションを使えるようにする構文
import org.apache.struts2.interceptor.SessionAware;

//session(セッション属性のキー＋値をMapに格納したフィールド名)を使えるようにする構文
import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dao.LoginDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.dto.LoginDTO;
//他のクラスから情報を持ってくる構文
import com.opensymphony.xwork2.ActionSupport;
//PCにメッセージを表示させる構文

public class LoginAction extends ActionSupport implements SessionAware {
	// 「extends ActionSupport」と「implements SessionAware」を追記してこれから使用することを宣言
	private String loginUserId;
	private String loginPassword;
	// 「ユーザーID」と「パスワード」をカプセル化して特定情報でのみログインできるようにする
	private Map<String, Object> session;
	// MapキーはString、値はObjectをsessionで一つにまとめたものをカプセル化
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private BuyItemDAO buyItemDAO = new BuyItemDAO();
	// 「LoginDAO」「LoginDTO」「BuyItemDAO」の情報を呼び出すためにインスタンス化

	public String execute() {
		// 実行した内容をこれから記述するという宣言
		String result = ERROR;
		// 基本はstruts.xmlでERRORを設定したページへ飛ぶようにする
		loginDTO = loginDAO.getLoginUserInfo(loginUserId, loginPassword);
		/*
		 * LoginDTOに格納されたユーザーIDとパスワードを、
		 * LoginDAOからLoginUserInfoのユーザーIDとパスワードを受け取る
		 */
		session.put("loginUser", loginDTO);
		// LoginDTOにある情報をMap型sessionにloginUserをキーとして、LoginDTOを値として格納する
		if (((LoginDTO) session.get("loginUser")).getLoginFlg()) {
			result = SUCCESS;
			BuyItemDTO buyItemDTO = buyItemDAO.getBuyItemInfo();
			/*
			 * もしユーザーIDとパスワードが合っていれば、ログインフラグがオンの状態になり、 購入画面に進み、これ以降ログイン状態が継続される
			 */

			session.put("login_user_id", loginDTO.getLoginId());
			session.put("id", buyItemDTO.getId());
			session.put("buyItem_name", buyItemDTO.getItemName());
			session.put("buyItem_price", buyItemDTO.getItemPrice());
			// 購入画面で表示できるようにMap型sessionで各クラスから情報を呼び出す

			return result;

		}
		return result;

	}

	// カプセル化した情報をgetter/setterで呼び出す
	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override // ActionSupportクラスから継承して再定義したもの
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
