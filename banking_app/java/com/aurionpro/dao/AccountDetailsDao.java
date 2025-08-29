package com.aurionpro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.aurionpro.database.DBConnector;
import com.aurionpro.model.AccountDetails;
import com.aurionpro.model.ActionStatus;
import com.aurionpro.model.Profile;
import com.aurionpro.model.TransactionType;

public class AccountDetailsDao {

	private Connection connection;
	
	public AccountDetailsDao() {
		connection = DBConnector.connect();
	}
	
	public ResultSet fetchAllAccounts(int userId)
	{
		ResultSet result = null;
		String sql = "select * from account_details where user_id=?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, userId);
			result = statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public int addAccountDetails(AccountDetails accountDetails) {
		String accountNumber = "temp";
	    String insertSql = "INSERT INTO account_details (user_id, name, account_number, ifsc, mobile_number, address, balance) VALUES (?,?,?,?,?,?,?)";
	    int rows = 0;
	    try {
	        // Step 1: Insert with a temporary placeholder for account_number
	        PreparedStatement insertStmt = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
	        insertStmt.setInt(1, accountDetails.getUserId());
	        insertStmt.setString(2, accountDetails.getName());
	        insertStmt.setString(3, accountDetails.getAccountNumber()); // temporary account number
	        insertStmt.setString(4, accountDetails.getIfsc());
	        insertStmt.setString(5, accountDetails.getMobileNumber());
	        insertStmt.setString(6, accountDetails.getAddress());
	        insertStmt.setDouble(7, accountDetails.getBalance());

	        rows = insertStmt.executeUpdate();

	        if (rows > 0) {
	            // Step 2: Get the generated account_id
	            ResultSet rs = insertStmt.getGeneratedKeys();
	            if (rs.next()) {
	                int accountId = rs.getInt(1);

	                // Step 3: Generate the real account number
	                accountNumber = "SBI" + String.format("%07d", accountId);


	                // Step 4: Update the record with the generated account number
	                String updateSql = "UPDATE account_details SET account_number = ? WHERE account_id = ?";
	                PreparedStatement updateStmt = connection.prepareStatement(updateSql);
	                updateStmt.setString(1, accountNumber);
	                updateStmt.setInt(2, accountId);
	                rows = updateStmt.executeUpdate();

	                updateStmt.close();
	            }
	            rs.close();
	        }

	        insertStmt.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return rows; // return the generated account number
	}

	public ResultSet getProfile(int accountId) {
		
		ResultSet result = null;
		String sql = "select name, mobile_number, address from account_details where account_id=?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, accountId);
			result = statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public ResultSet getAccountInfo(int accountId) {
		ResultSet result = null;
		String sql = "select account_number, ifsc, balance from account_details where account_id=?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, accountId);
			result = statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int makePayment(int senderAccountId, int receiverAccountId, double amount) throws SQLException {
	    int rows = 0;
	    boolean hasBalance = checkBalance(senderAccountId, amount);
	    if (!hasBalance) {
	        return -1; // insufficient balance
	    }

	    try {
	        connection.setAutoCommit(false); // start transaction

	        // 1. Deduct from sender
	        String deductSql = "UPDATE account_details SET balance = balance - ? WHERE account_id = ?";
	        int r1;
	        try (PreparedStatement ps = connection.prepareStatement(deductSql)) {
	            ps.setDouble(1, amount);
	            ps.setInt(2, senderAccountId);
	            r1 = ps.executeUpdate();
	        }

	        // 2. Credit receiver
	        String creditSql = "UPDATE account_details SET balance = balance + ? WHERE account_id = ?";
	        int r2;
	        try (PreparedStatement ps = connection.prepareStatement(creditSql)) {
	            ps.setDouble(1, amount);
	            ps.setInt(2, receiverAccountId);
	            r2 = ps.executeUpdate();
	        }

	        // 3. Optional: insert transactions for both accounts
	        String txnSql = "INSERT INTO transactions (account_id, other_account_id, type, amount) VALUES (?, ?, ?, ?)";
	        try (PreparedStatement ps = connection.prepareStatement(txnSql)) {
	            // sender transaction
	            ps.setInt(1, senderAccountId); // or fetch user_id from account
	            ps.setInt(2, receiverAccountId);
	            ps.setString(3, TransactionType.DEBIT.name());
	            ps.setDouble(4, amount);
	            ps.executeUpdate();

	            // receiver transaction
	            ps.setInt(1, receiverAccountId);
	            ps.setInt(2, senderAccountId);
	            ps.setString(3, TransactionType.CREDIT.name());
	            ps.setDouble(4, amount);
	            ps.executeUpdate();
	        }

	        connection.commit(); // commit all updates
	        rows = r1 + r2;
	    } catch (Exception e) {
	        try {
	            connection.rollback(); // rollback on any failure
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	        throw new SQLException("Payment failed: " + e.getMessage());
	    } finally {
	        connection.setAutoCommit(true);
	    }

	    return rows;
	}


	private boolean checkBalance(int senderAccountId, double amount) {
		boolean hasBalance = false;
		ResultSet result = null;
		String sql = "select balance from account_details where account_id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, senderAccountId);
			result = statement.executeQuery();
			while(result.next())
			{
				double balance = result.getDouble("balance");
				if(balance >= amount)
				{
					hasBalance=true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hasBalance;
	}

//	public ResultSet getAllBankAccounts() {
//		ResultSet result = null;
//		String sql = "select * from account_details";
//		try {
//			PreparedStatement statement = connection.prepareStatement(sql);
//			result = statement.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return result;
//	}
	
	
	public ResultSet getFilteredBankAccounts(String accountNumber, Double minBalance, Double maxBalance) {
	    ResultSet result = null;
	    StringBuilder sql = new StringBuilder("SELECT * FROM account_details WHERE 1=1");

	    if (accountNumber != null && !accountNumber.isEmpty()) {
	        sql.append(" AND account_number = ?");
	    }
	    if (minBalance != null) {
	        sql.append(" AND balance >= ?");
	    }
	    if (maxBalance != null) {
	        sql.append(" AND balance <= ?");
	    }

	    try {
	        PreparedStatement statement = connection.prepareStatement(sql.toString());

	        int index = 1;
	        if (accountNumber != null && !accountNumber.isEmpty()) {
	            statement.setString(index++, accountNumber);
	        }
	        if (minBalance != null) {
	            statement.setDouble(index++, minBalance);
	        }
	        if (maxBalance != null) {
	            statement.setDouble(index++, maxBalance);
	        }

	        result = statement.executeQuery();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}

	
	

	public int addPendingAccounts(AccountDetails accountDetails) {
		String insertSql = "INSERT INTO pending_accounts (user_id, name, ifsc, mobile_number, address, balance) VALUES (?,?,?,?,?,?)";
	    int rows = 0;
	    try {
	        // Step 1: Insert with a temporary placeholder for account_number
	        PreparedStatement insertStmt = connection.prepareStatement(insertSql);
	        insertStmt.setInt(1, accountDetails.getUserId());
	        insertStmt.setString(2, accountDetails.getName());
	        insertStmt.setString(3, accountDetails.getIfsc());
	        insertStmt.setString(4, accountDetails.getMobileNumber());
	        insertStmt.setString(5, accountDetails.getAddress());
	        insertStmt.setDouble(6, accountDetails.getBalance());

	        rows = insertStmt.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return rows; 
	}

//	public ResultSet getPendingAccounts() {
//		ResultSet result = null;
//		String sql = "select * from pending_accounts";
//		try {
//			PreparedStatement statement = connection.prepareStatement(sql);
//			result = statement.executeQuery();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return result;
//	}
	
	public ResultSet getPendingAccounts(String statusFilter) {
	    ResultSet result = null;
	    try {
	        String sql = "SELECT * FROM pending_accounts";
	        if (statusFilter != null && !statusFilter.isEmpty()) {
	            sql += " WHERE status = ?";
	        }
	        PreparedStatement statement = connection.prepareStatement(sql);
	        
	        if (statusFilter != null && !statusFilter.isEmpty()) {
	            statement.setString(1, statusFilter);
	        }
	        
	        result = statement.executeQuery();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}

	
	public int updateStatus(ActionStatus approved, int pendingAccountId) {
		String insertSql = "update pending_accounts set status = ? where pending_id = ?";
	    int rows = 0;
	    try {
	        PreparedStatement statement = connection.prepareStatement(insertSql);
	        statement.setString(1,approved.name());
	        statement.setInt(2, pendingAccountId);
	        rows = statement.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return rows; 
	}
	
	public ResultSet getPendingAccount(int pendingAccountId) {
		ResultSet result = null;
		String sql = "select * from pending_accounts where pending_id = ?";
		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, pendingAccountId);
			result = statement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
