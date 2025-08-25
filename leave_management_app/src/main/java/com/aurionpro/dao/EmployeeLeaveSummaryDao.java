package com.aurionpro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aurionpro.database.DBConnector;
import com.aurionpro.model.Leave;

public class EmployeeLeaveSummaryDao {
	private Connection connection = null;

	public EmployeeLeaveSummaryDao() {
		connection = DBConnector.connect();
	}
	
	public boolean addLeave(Leave leave)
	{
		try {
			PreparedStatement statement = connection.prepareStatement("insert into leave_summary (user_id, from_date, to_date, reason, status) values (?,?,?,?,?)");
			statement.setInt(1,leave.getUserId());
			statement.setDate(2,java.sql.Date.valueOf(leave.getFromDate()));
			statement.setDate(3,java.sql.Date.valueOf(leave.getToDate()));
			statement.setString(4, leave.getReason());
			statement.setString(5, leave.getStatus().name());
			int rows = statement.executeUpdate();
			if(rows>0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ResultSet getAllLeaves(int userId)
	{
		ResultSet result = null;
//		if(userId==-1)
//		{
//			try {
//				PreparedStatement statement = connection.prepareStatement("select * from leave_summary");
//				result = statement.executeQuery();
//				return result;
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		try {
			PreparedStatement statement = connection.prepareStatement("select * from leave_summary where user_id = ?");
			statement.setInt(1, userId);
			result = statement.executeQuery();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
