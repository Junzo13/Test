package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UserListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UserListDAO {
	public ArrayList<UserListDTO> getUserListInfo() throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<UserListDTO> userList = new ArrayList<UserListDTO>();

		String sql = "select * from login_user_transaction";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				UserListDTO dto = new UserListDTO();
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPass(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				dto.setUserMail(rs.getString("user_mail"));
				userList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return userList;
	}

	public int UserListDelete() throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "delete from login_user_transaction";
		PreparedStatement ps;
		int result = 0;

		try {
			ps = con.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;
	}

}
