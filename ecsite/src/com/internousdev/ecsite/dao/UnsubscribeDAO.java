package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.UnsubscribeDTO;
import com.internousdev.ecsite.util.DBConnector;

public class UnsubscribeDAO {
	public ArrayList<UnsubscribeDTO> getUserInfo(String login_id) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<UnsubscribeDTO> unsubscribeDTO = new ArrayList<UnsubscribeDTO>();
		String sql = "select * from login_user_transaction where login_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, login_id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				UnsubscribeDTO dto = new UnsubscribeDTO();
				dto.setLoginId(rs.getString("login_id"));
				dto.setLoginPass(rs.getString("login_pass"));
				dto.setUserName(rs.getString("user_name"));
				dto.setId(rs.getString("id"));
				dto.setUserMail(rs.getString("user_mail"));
				unsubscribeDTO.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return unsubscribeDTO;
	}

	public int userDelete(String login_id) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "delete from login_user_transaction where login_id=?";
		PreparedStatement ps;
		int result = 0;

		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, login_id);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;
	}

}
