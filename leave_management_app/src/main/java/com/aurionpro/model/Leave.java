package com.aurionpro.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Leave {

	private int leaveId;
	private int userId;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String reason;
	private LeaveStatus status;
	private LocalDateTime appliedAt;
	private String employeeName;

	public Leave(int userId, LocalDate fromDate, LocalDate toDate, String reason, LeaveStatus status) {
		super();
		this.userId = userId;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.reason = reason;
		this.status = status;
	}

	public int getUserId() {
		return userId;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public String getReason() {
		return reason;
	}

	public LeaveStatus getStatus() {
		return status;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setStatus(LeaveStatus status) {
		this.status = status;
	}

	public LocalDateTime getAppliedAt() {
		return appliedAt;
	}

	public void setAppliedAt(LocalDateTime appliedAt) {
		this.appliedAt = appliedAt;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public long getNoOfDays() {
		return ChronoUnit.DAYS.between(fromDate, toDate) + 1;
	}

}
