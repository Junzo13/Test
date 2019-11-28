package com.internousdev.ecsite.dao;

//複数のクラスを分類・管理する構文
import java.sql.Connection;
//データベースに接続する構文
import java.sql.PreparedStatement;
//SQL文をプリコンパイルして格納するための構文
import java.sql.ResultSet;
//executeQueryを実行することで返ってくる結果を表示する構文
import java.sql.SQLException;
//エラーが起きた際に、その原因を表示する構文

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;
//データベースJavaを繋ぐJDBCドライバーを使えるようにする構文

public class LoginDAO {
	public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword) {
		// ログインIDとパスワードをLoginUserInfoに入れてLoginDTOに渡す
		DBConnector db = new DBConnector();
		// DBConnectorを呼び出すためにｄｂにインスタンス化
		Connection con = db.getConnection();
		// DBConnectorから接続に必要なものを取り出してデータベースに接続
		LoginDTO loginDTO = new LoginDTO();
		// LoginDTOを呼び出すためにインスタンス化

		String sql = "select * from login_user_transaction where login_id=? and login_pass=?";
		// データベースからログインIDとパスワードを検索
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			// データベースから取得した情報をこのオブジェクトに一時的に格納しpsに代入
			ps.setString(1, loginUserId);
			ps.setString(2, loginPassword);
			// ユーザーIDとパスワードをpsに保存
			ResultSet rs = ps.executeQuery();
			// データベースから取得した情報を実行してrsに格納

			if (rs.next()) {
				loginDTO.setLoginId(rs.getString("login_id"));
				loginDTO.setLoginPassword(rs.getString("login_pass"));
				loginDTO.setUserName(rs.getString("user_name"));
				// ログインIDとパスワードとユーザー名をDTOに格納

				if (rs.getString("login_id") != null) {
					loginDTO.setLoginFlg(true);
					/*
					 * SQL文からlogin_idを探して、(何もない)でなければ=値があれば、
					 * trueとなってログイン状態が継続されるのをLoginDTOへ渡す
					 */
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginDTO;
		// LoginDTOにある情報を呼び出し元であるActionクラスへ渡す
	}

}
