package com.internousdev.ecsite.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.ecsite.dto.ItemListDTO;
import com.internousdev.ecsite.util.DBConnector;

public class ItemListDAO {
	public ArrayList<ItemListDTO> getItemListInfo() throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<ItemListDTO> itemList = new ArrayList<ItemListDTO>();

		String sql = "select * from item_info_transaction";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ItemListDTO dto = new ItemListDTO();
				dto.setItemName(rs.getString("item_name"));
				dto.setItemPrice(rs.getString("item_price"));
				dto.setItemStock(rs.getString("item_stock"));
				itemList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return itemList;
	}

	public int ItemListDelete() throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "delete from item_info_transaction";
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
