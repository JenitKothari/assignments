package com.aurionpro.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.dao.AdminLeaveSummaryDao;
import com.aurionpro.model.Leave;
import com.aurionpro.model.LeaveStatus;

public class AdminLeaveSummaryService {
	private AdminLeaveSummaryDao adminLeaveSummaryDao = null;

	public AdminLeaveSummaryService() {
		adminLeaveSummaryDao = new AdminLeaveSummaryDao();
	}
	
	public List<Leave> getAllLeaves()
	{
		ResultSet result = adminLeaveSummaryDao.getAllLeaves();
		List<Leave> leaves = new ArrayList<Leave>();
		if(result==null)
		{
			return null;
		}
		try {
			while(result.next())
			{
				int leaveId = result.getInt("leave_id");
				int userId = result.getInt("user_id");
				LocalDate fromDate = result.getDate("from_date").toLocalDate();
				LocalDate toDate = result.getDate("to_date").toLocalDate();
				String reason = result.getString("reason");
				LeaveStatus status =  LeaveStatus.valueOf(result.getString("status"));
				String employeeName = result.getString("name");
				Leave leave = new Leave(userId,fromDate,toDate,reason,status);
				leave.setLeaveId(leaveId);
				leave.setEmployeeName(employeeName);
				leaves.add(leave);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return leaves;
	}
	
	public boolean updateStatus(int leaveId, String status)
	{
		boolean updated = false;
		if(adminLeaveSummaryDao.updateStatus(leaveId, status)>0)
		{
			updated = true;
		}
		return updated;
	}
	
}
