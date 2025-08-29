package com.aurionpro.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.dao.AccountDetailsDao;
import com.aurionpro.model.AccountDetails;
import com.aurionpro.model.AccountInfo;
import com.aurionpro.model.ActionStatus;
import com.aurionpro.model.Profile;
import com.aurionpro.model.User;

public class AccountDetailsService {

	private AccountDetailsDao accountDetailsDao = null;
	
	public AccountDetailsService() {
		accountDetailsDao = new AccountDetailsDao();
	}
	
	public List<AccountDetails> fetchAllAccounts(int userId)
	{
		ResultSet result = accountDetailsDao.fetchAllAccounts(userId);
		List<AccountDetails> customerAccounts = new ArrayList<AccountDetails>();
		if(result==null)
		{
			return null;
		}
		
		try {
			while(result.next())
			{
				int accountId = result.getInt("account_id");
				String name = result.getString("name");
				String accountNumber = result.getString("account_number");
				String ifsc = result.getString("ifsc");
				String mobileNumber = result.getString("mobile_number");
				String address = result.getString("address");
				double balance = result.getDouble("balance");
				
				AccountDetails accountDetails = new AccountDetails(accountId, userId, name, accountNumber, ifsc, mobileNumber, address, balance);
				customerAccounts.add(accountDetails);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customerAccounts;
	}

	public boolean addAccountDetails(AccountDetails accountDetails) {
		boolean added = false;
		if(accountDetailsDao.addAccountDetails(accountDetails)>0)
		{
			added = true;
		}
		return added;
	}

	public Profile getProfile(int accountId) {
		Profile profile = null;
		ResultSet result = accountDetailsDao.getProfile(accountId);
		try {
			while(result.next())
			{

				String name = result.getString("name");
				String mobileNumber = result.getString("mobile_number");
				String address = result.getString("address");
				profile = new Profile(name, mobileNumber, address);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return profile;
	}

	public AccountInfo getAccountInfo(int accountId) {
		AccountInfo accountInfo = null;
		ResultSet result = accountDetailsDao.getAccountInfo(accountId);
		try {
			while(result.next())
			{
				String accountNumber = result.getString("account_number");
				String ifsc = result.getString("ifsc");
				Double balance = result.getDouble("balance");
				accountInfo = new AccountInfo(accountNumber, ifsc, balance);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return accountInfo;
	}

	public boolean makePayment(int senderAccountId, int recieverAccountId, double amount)
	{
		int rows = 0;
		try {
			rows = accountDetailsDao.makePayment(senderAccountId, recieverAccountId, amount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(rows==2)
		{
			return true; 
		}
		return false;
	}

//	public List<AccountDetails> getAllBankAccounts() {
//		List<AccountDetails> accounts = new ArrayList<AccountDetails>();
//		ResultSet result = accountDetailsDao.getAllBankAccounts();
//		if(result==null)
//		{
//			return null;
//		}
//		try {
//			while(result.next())
//			{
//				int accountId = result.getInt("account_id");
//				int userId = result.getInt("user_id");
//				String name = result.getString("name");
//				String accountNumber = result.getString("account_number");
//				String ifsc = result.getString("ifsc");
//				String mobileNumber = result.getString("mobile_number");
//				String address = result.getString("address");
//				double balance = result.getDouble("balance");
//				
//				AccountDetails account = new AccountDetails(userId, name, accountNumber, ifsc, mobileNumber, address, balance);
//				accounts.add(account);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return accounts;
//	}

	
	
	public List<AccountDetails> getFilteredBankAccounts(String accountNumber, Double minBalance, Double maxBalance) {
	    List<AccountDetails> accounts = new ArrayList<>();
	    ResultSet result = accountDetailsDao.getFilteredBankAccounts(accountNumber, minBalance, maxBalance);

	    if (result == null) {
	        return null;
	    }
	    try {
	        while (result.next()) {
	            int userId = result.getInt("user_id");
	            String name = result.getString("name");
	            String accNumber = result.getString("account_number");
	            String ifsc = result.getString("ifsc");
	            String mobileNumber = result.getString("mobile_number");
	            String address = result.getString("address");
	            double balance = result.getDouble("balance");

	            AccountDetails account = new AccountDetails(userId, name, accNumber, ifsc, mobileNumber, address, balance);
	            accounts.add(account);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return accounts;
	}

	
	
	public boolean addPendingAccounts(AccountDetails accountDetails) {
		boolean added = false;
		if(accountDetailsDao.addPendingAccounts(accountDetails)>0)
		{
			added = true;
		}
		return added;
	}

//	public List<AccountDetails> getPendingAccounts() {
//		List<AccountDetails> accounts = new ArrayList<AccountDetails>();
//		ResultSet result = accountDetailsDao.getPendingAccounts();
//		if(result==null)
//		{
//			return null;
//		}
//		try {
//			while(result.next())
//			{
//				int accountId = result.getInt("pending_id");
//				int userId = result.getInt("user_id");
//				String name = result.getString("name");
//				String ifsc = result.getString("ifsc");
//				String mobileNumber = result.getString("mobile_number");
//				String address = result.getString("address");
//				double balance = result.getDouble("balance");
//				ActionStatus status = ActionStatus.valueOf(result.getString("status"));
//				
//				AccountDetails account = new AccountDetails(accountId, userId, name, ifsc, mobileNumber, address, balance, status);
//				accounts.add(account);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return accounts;
//	}
	
	public List<AccountDetails> getPendingAccounts(String statusFilter) {
	    List<AccountDetails> accounts = new ArrayList<>();
	    ResultSet result = accountDetailsDao.getPendingAccounts(statusFilter);
	    if (result == null) {
	        return null;
	    }
	    try {
	        while (result.next()) {
	            int accountId = result.getInt("pending_id");
	            int userId = result.getInt("user_id");
	            String name = result.getString("name");
	            String ifsc = result.getString("ifsc");
	            String mobileNumber = result.getString("mobile_number");
	            String address = result.getString("address");
	            double balance = result.getDouble("balance");
	            ActionStatus status = ActionStatus.valueOf(result.getString("status"));
	            
	            AccountDetails account = new AccountDetails(accountId, userId, name, ifsc, mobileNumber, address, balance, status);
	            accounts.add(account);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return accounts;
	}


	public boolean updateStatus(ActionStatus approved, int pendingAccountId) {
		boolean updated = false;
		if(accountDetailsDao.updateStatus(approved, pendingAccountId)>0)
		{
			updated = true;
		}
		return updated;
	}
	
	public AccountDetails getPendingAccount(int pendingAccountId) {
		AccountDetails account = null;
		ResultSet result = accountDetailsDao.getPendingAccount(pendingAccountId);
		if(result==null)
		{
			return null;
		}
		try {
			while(result.next())
			{
//				int accountId = result.getInt("pending_id");
				int userId = result.getInt("user_id");
				String name = result.getString("name");
				String ifsc = result.getString("ifsc");
				String mobileNumber = result.getString("mobile_number");
				String address = result.getString("address");
				double balance = result.getDouble("balance");
//				ActionStatus status = ActionStatus.valueOf(result.getString("status"));
				
				account = new AccountDetails(userId, name, ifsc, mobileNumber, address, balance);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}

}
