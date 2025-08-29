//package com.aurionpro.service;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Timestamp;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.aurionpro.dao.TransactionDao;
//import com.aurionpro.model.Transaction;
//import com.aurionpro.model.TransactionType;
//
//public class TransactionService {
//
//	private TransactionDao transactionDao = null;
//	
//	public TransactionService() {
//		transactionDao = new TransactionDao();
//	}
//	
//	public List<Transaction> getAllTransaction(int accountId, int userId)
//	{
//		ResultSet result = transactionDao.getAllTransaction(accountId,userId);
//		List<Transaction> transactions = new ArrayList<Transaction>();
//		if(result==null)
//		{
//			return null;
//		}
//		try {
//			while(result.next())
//			{
//				int transactionId = result.getInt("transaction_id");
//				int accId = result.getInt("account_id");
//				Timestamp txnDate = result.getTimestamp("txn_date");
//				int otherAccountId = result.getInt("other_account_id");
//				TransactionType type = TransactionType.valueOf(result.getString("type"));
//				double amount = result.getDouble("amount");
//				
//				Transaction transaction = new Transaction(transactionId, accountId, txnDate, otherAccountId, type, amount);
//				transactions.add(transaction);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return transactions;
//	}
//}

package com.aurionpro.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.aurionpro.dao.TransactionDao;
import com.aurionpro.model.Transaction;
import com.aurionpro.model.TransactionType;

public class TransactionService {

    private final TransactionDao transactionDao = new TransactionDao();

    /**
     * Returns a list of Transaction objects using provided filters.
     *
     * sessionAccountId may be null. DAO will handle mapping to an account for non-admin users if needed.
     * fromDate/toDate expected in "yyyy-MM-dd" format or null/empty.
     * minAmount/maxAmount are string values; DAO parses them.
     * type is "CREDIT" or "DEBIT" or null/empty.
     */
    public List<Transaction> getFilteredTransactions(int userId,
            Integer sessionAccountId,
            String fromDate, String toDate,
            String minAmountStr, String maxAmountStr,
            String type, String filterAccountIdStr) {

        ResultSet rs = transactionDao.getFilteredTransactions(
                userId,
                sessionAccountId,
                fromDate, toDate,
                minAmountStr, maxAmountStr,
                type, filterAccountIdStr
        );

        List<Transaction> list = new ArrayList<>();
        if (rs == null) return list;

        try {
            while (rs.next()) {
                int transactionId = rs.getInt("transaction_id");
                int accountId = rs.getInt("account_id");
                Timestamp txnDate = rs.getTimestamp("txn_date");
                int otherAccountId = 0;
                try {
                    otherAccountId = rs.getInt("other_account_id");
                    if (rs.wasNull()) otherAccountId = 0;
                } catch (SQLException ignore) {
                    otherAccountId = 0;
                }
                TransactionType txnType = null;
                String t = rs.getString("type");
                if (t != null && !t.isEmpty()) {
                    try {
                        txnType = TransactionType.valueOf(t);
                    } catch (IllegalArgumentException iae) {
                        txnType = null;
                    }
                }
                double amount = rs.getDouble("amount");

                Transaction txn = new Transaction(transactionId, accountId, txnDate, otherAccountId, txnType, amount);
                list.add(txn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Note: Because original DB pattern returned ResultSet directly, the statement/connection cleanup is tricky.
            // The DB connection/statement will be closed where your DBConnector or DAO manages it.
        }
        return list;
    }

    // keep legacy convenience method
    public List<Transaction> getAllTransaction(int accountId, int userId) {
        return getFilteredTransactions(userId, accountId, null, null, null, null, null, null);
    }
}

