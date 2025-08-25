package com.aurionpro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aurionpro.database.DBConnector;

public class AdminLeaveSummaryDao {

	private Connection connection = null;

	public AdminLeaveSummaryDao() {
		connection = DBConnector.connect();
	}
	
	public ResultSet getAllLeaves()
	{
		ResultSet result = null;
		String query = "select leave_id, u.user_id, name, from_date, to_date, reason, status from users u inner join leave_summary ls on u.user_id=ls.user_id";
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			result = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int updateStatus(int leaveId, String status)
	{
		String query = "update leave_summary set status=? where leave_id = ?";
		int rows = 0;
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, status);
			statement.setInt(2, leaveId);
			rows =  statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}
}
