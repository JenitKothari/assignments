package com.aurionpro.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.dao.BeneficiaryDao;
import com.aurionpro.model.Beneficiary;
import com.aurionpro.model.BeneficiaryPayment;

public class BeneficiaryService {

	private BeneficiaryDao beneficiaryDao = null;
	
	public BeneficiaryService() {
		beneficiaryDao = new BeneficiaryDao();
	}

	public boolean addBeneficiary(Beneficiary beneficiary, String accountNumber, String ifsc, int accountId) {
		boolean added = false;
		int rows = beneficiaryDao.addBeneficiary(beneficiary,accountNumber,ifsc, accountId);
		if(rows>0)
		{
			added = true;
		}
		return added;
	}
	
	public List<BeneficiaryPayment> getBeneficiaries(int accountId)
	{
		List<BeneficiaryPayment> beneficiariesPayment = new ArrayList<>();
		ResultSet result = beneficiaryDao.getBeneficiaries(accountId);
		if(result==null)
		{
			return null;
		}
		try {
			while(result.next())
			{
			    	int accId = result.getInt("beneficiary_id");
			    	String name = result.getString("beneficiary_name");
			    	String accountNumber = result.getString("account_number");
			    	String ifsc = result.getString("ifsc");
			    	
			        BeneficiaryPayment bp = new BeneficiaryPayment(accId, name, accountNumber, ifsc);
			        beneficiariesPayment.add(bp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return beneficiariesPayment;
	}
}

