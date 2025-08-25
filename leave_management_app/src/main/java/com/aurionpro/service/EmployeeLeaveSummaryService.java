package com.aurionpro.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.dao.EmployeeLeaveSummaryDao;
import com.aurionpro.model.Leave;
import com.aurionpro.model.LeaveStatus;

public class EmployeeLeaveSummaryService {
	private EmployeeLeaveSummaryDao employeeLeaveSummaryDao = null;

	public EmployeeLeaveSummaryService() {
		super();
		employeeLeaveSummaryDao = new EmployeeLeaveSummaryDao();
	}

	public boolean addLeave(Leave leave) {
		LocalDate fromDate = leave.getFromDate();
		LocalDate toDate = leave.getToDate();
		if(fromDate.isAfter(toDate))
		{
			return false;
		}
		return employeeLeaveSummaryDao.addLeave(leave);
	}
	
	public List<Leave> getAllLeaves(int userId)
	{
		ResultSet result = employeeLeaveSummaryDao.getAllLeaves(userId);
		List<Leave> leaves = new ArrayList<Leave>();
		if(result==null)
		{
			return null;
		}
		try {
			while(result.next())
			{
				LocalDate fromDate = result.getDate("from_date").toLocalDate();
				LocalDate toDate = result.getDate("to_date").toLocalDate();
				String reason = result.getString("reason");
				LeaveStatus status =  LeaveStatus.valueOf(result.getString("status"));
				LocalDateTime appliedAt = result.getTimestamp("applied_at").toLocalDateTime();
				Leave leave = new Leave(userId,fromDate,toDate,reason,status);
				leave.setAppliedAt(appliedAt);
				leaves.add(leave);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return leaves;
	}

}
