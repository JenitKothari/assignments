package com.aurionpro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.aurionpro.database.DBConnector;
import com.aurionpro.model.Beneficiary;
import com.aurionpro.model.BeneficiaryPayment;

public class BeneficiaryDao {

	private Connection connection = null;
	
	public BeneficiaryDao() {
		connection = DBConnector.connect();
	}

	public int addBeneficiary(Beneficiary beneficiary, String accountNumber, String ifsc, int accountId) {
		int rows = 0;
		int beneficiaryId = checkAccountExists(accountNumber,ifsc);
		if(beneficiaryId ==-1)
		{
			return rows;
		}
		String sql = "insert into beneficiaries values (?,?,?,?)";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, accountId);
			statement.setInt(2, beneficiaryId);
			statement.setString(3, beneficiary.getBankName());
			statement.setString(4, beneficiary.getBeneficiaryName());
			rows = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows;
	}

	private int checkAccountExists(String accountNumber, String ifsc) {
		int beneficiaryId = -1;
		String sql = "select account_id from account_details where account_number = ? and ifsc = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, accountNumber);
			statement.setString(2, ifsc);
			ResultSet result = statement.executeQuery();
			while(result.next())
			{
				beneficiaryId = result.getInt("account_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return beneficiaryId;
	}
	
	public ResultSet getBeneficiaries(int accountId)
	{
		List<Integer> beneficiaryIds = getBeneficiaryIds(accountId);
		ResultSet result = null;
		
		if (beneficiaryIds.isEmpty()) {
		    return result;
		}

		// Create placeholders (?, ?, ?, ...)
		String placeholders = String.join(",", Collections.nCopies(beneficiaryIds.size(), "?"));

		String sql = "select b.beneficiary_id, b.beneficiary_name, a.account_number, a.ifsc from account_details a inner join beneficiaries b on a.account_id = b.beneficiary_id where b.account_id=?";

		try {
		    
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, accountId);
		    result = statement.executeQuery();
		} catch (SQLException e) {
		    e.printStackTrace();
		}

		return result;

	}

	private List<Integer> getBeneficiaryIds(int accountId) {
		List<Integer> beneficiaryIds = new ArrayList<Integer>();
		try {
			PreparedStatement statement = connection.prepareStatement("select beneficiary_id from beneficiaries where account_id=? ");
			statement.setInt(1, accountId);
			ResultSet result = statement.executeQuery();
			while(result.next())
			{
				int beneficiaryId = result.getInt("beneficiary_id");
				beneficiaryIds.add(beneficiaryId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return beneficiaryIds;
	}
}
