////package com.aurionpro.dao;
////
////import java.sql.Connection;
////import java.sql.PreparedStatement;
////import java.sql.ResultSet;
////import java.sql.SQLException;
////
////import com.aurionpro.database.DBConnector;
////
////public class TransactionDao {
////
////	private Connection connection = null;
////	
////	public TransactionDao() {
////		connection = DBConnector.connect();
////	}
////	
////	public ResultSet getAllTransaction(int accountId, int userId)
////	{
////		ResultSet result = null;
////		boolean isAdmin = checkIsAdmin(userId);
////		if(isAdmin)
////		{
////			try {
////				PreparedStatement statement = connection.prepareStatement("select * from transactions");
////				result = statement.executeQuery();
////			} catch (SQLException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////			return result;
////		}
////		try {
////			PreparedStatement statement = connection.prepareStatement("select * from transactions where account_id=?");
////			statement.setInt(1, accountId);
////			result = statement.executeQuery();
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		return result;
////		
////	}
////
////	private boolean checkIsAdmin(int userId) {
////		boolean isAdmin = false;
////		ResultSet result = null;
////		String sql = "select is_admin from users where user_id=?";
////		try {
////			PreparedStatement statement = connection.prepareStatement(sql);
////			statement.setInt(1, userId);
////			result = statement.executeQuery();
////			while(result.next())
////			{
////				isAdmin = result.getBoolean("is_admin");
////			}
////		} catch (SQLException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		return isAdmin;
////	}
////}
//
//
//package com.aurionpro.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import com.aurionpro.database.DBConnector;
//
//public class TransactionDao {
//
//    private Connection connection = null;
//
//    public TransactionDao() {
//        connection = DBConnector.connect();
//    }
//
//    /**
//     * Returns ResultSet of transactions filtered by optional parameters.
//     * Behavior:
//     *  - If user is not admin => forced filter account_id = accountId (their own account)
//     *  - If user is admin and filterAccountIdStr provided => filter by that account_id
//     *  - Optional date filters: fromDate (yyyy-MM-dd) and toDate (yyyy-MM-dd) included in range
//     *  - Optional min/max amount filters
//     *  - Optional type filter ("CREDIT" / "DEBIT")
//     *
//     * NOTE: This method returns a ResultSet and leaves the PreparedStatement open (same pattern as original code).
//     * Make sure you handle DB resource cleanup appropriately in your app.
//     */
////    public ResultSet getFilteredTransactions(int accountId, int userId,
////            String fromDate, String toDate,
////            String minAmountStr, String maxAmountStr,
////            String type, String filterAccountIdStr) {
////
////        ResultSet result = null;
////        boolean isAdmin = checkIsAdmin(userId);
////
////        StringBuilder sql = new StringBuilder("SELECT * FROM transactions WHERE 1=1 ");
////
////        // account filtering
////        if (!isAdmin) {
////            sql.append(" AND account_id = ? ");
////        } else {
////            if (filterAccountIdStr != null && !filterAccountIdStr.trim().isEmpty()) {
////                sql.append(" AND account_id = ? ");
////            }
////        }
////
////        // date filters (txn_date)
////        if (fromDate != null && !fromDate.trim().isEmpty()) {
////            sql.append(" AND txn_date >= ? ");
////        }
////        if (toDate != null && !toDate.trim().isEmpty()) {
////            sql.append(" AND txn_date <= ? ");
////        }
////
////        // amount range
////        if (minAmountStr != null && !minAmountStr.trim().isEmpty()) {
////            sql.append(" AND amount >= ? ");
////        }
////        if (maxAmountStr != null && !maxAmountStr.trim().isEmpty()) {
////            sql.append(" AND amount <= ? ");
////        }
////
////        // type filter
////        if (type != null && !type.trim().isEmpty()) {
////            sql.append(" AND type = ? ");
////        }
////
////        try {
////            PreparedStatement statement = connection.prepareStatement(sql.toString());
////            int idx = 1;
////
////            // bind account param
////            if (!isAdmin) {
////                statement.setInt(idx++, accountId);
////            } else if (filterAccountIdStr != null && !filterAccountIdStr.trim().isEmpty()) {
////                try {
////                    int fAcc = Integer.parseInt(filterAccountIdStr.trim());
////                    statement.setInt(idx++, fAcc);
////                } catch (NumberFormatException nfe) {
////                    // invalid filter account id - bind nothing and leave query (it won't match)
////                    statement.setInt(idx++, -1);
////                }
////            }
////
////            // bind date params - append time to include whole day
////            if (fromDate != null && !fromDate.trim().isEmpty()) {
////                // bind as string "yyyy-MM-dd 00:00:00" - MySQL will parse
////                statement.setString(idx++, fromDate.trim() + " 00:00:00");
////            }
////            if (toDate != null && !toDate.trim().isEmpty()) {
////                statement.setString(idx++, toDate.trim() + " 23:59:59");
////            }
////
////            // bind amount params
////            if (minAmountStr != null && !minAmountStr.trim().isEmpty()) {
////                try {
////                    double minAmount = Double.parseDouble(minAmountStr.trim());
////                    statement.setDouble(idx++, minAmount);
////                } catch (NumberFormatException nfe) {
////                    statement.setDouble(idx++, Double.NEGATIVE_INFINITY);
////                }
////            }
////            if (maxAmountStr != null && !maxAmountStr.trim().isEmpty()) {
////                try {
////                    double maxAmount = Double.parseDouble(maxAmountStr.trim());
////                    statement.setDouble(idx++, maxAmount);
////                } catch (NumberFormatException nfe) {
////                    statement.setDouble(idx++, Double.POSITIVE_INFINITY);
////                }
////            }
////
////            // bind type
////            if (type != null && !type.trim().isEmpty()) {
////                statement.setString(idx++, type.trim());
////            }
////
////            result = statement.executeQuery();
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////
////        return result;
////    }
//
//    
//    public ResultSet getFilteredTransactions(
//            int userId,
//            Integer accountId,
//            Date fromDate,
//            Date toDate,
//            Double minAmount,
//            Double maxAmount,
//            String type) {
//
//        ResultSet result = null;
//        boolean isAdmin = checkIsAdmin(userId);
//
//        StringBuilder query = new StringBuilder("SELECT * FROM transactions WHERE 1=1");
//
//        if (!isAdmin) {
//            query.append(" AND account_id = ?");
//        }
//
//        if (fromDate != null && toDate != null) {
//            query.append(" AND txn_date BETWEEN ? AND ?");
//        }
//        if (minAmount != null) {
//            query.append(" AND amount >= ?");
//        }
//        if (maxAmount != null) {
//            query.append(" AND amount <= ?");
//        }
//        if (type != null && !type.isEmpty()) {
//            query.append(" AND type = ?");
//        }
//
//        try {
//            PreparedStatement statement = connection.prepareStatement(query.toString());
//            int idx = 1;
//
//            if (!isAdmin) {
//                statement.setInt(idx++, accountId);
//            }
//            if (fromDate != null && toDate != null) {
//                statement.setDate(idx++, fromDate);
//                statement.setDate(idx++, toDate);
//            }
//            if (minAmount != null) {
//                statement.setDouble(idx++, minAmount);
//            }
//            if (maxAmount != null) {
//                statement.setDouble(idx++, maxAmount);
//            }
//            if (type != null && !type.isEmpty()) {
//                statement.setString(idx++, type);
//            }
//
//            result = statement.executeQuery();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return result;
//    }
//
//    
//    // Existing method preserved (calls the filter method with null filters)
//    public ResultSet getAllTransaction(int accountId, int userId) {
//        return getFilteredTransactions(accountId, userId, null, null, null, null, null, null);
//    }
//
//    private boolean checkIsAdmin(int userId) {
//        boolean isAdmin = false;
//        ResultSet result = null;
//        String sql = "select is_admin from users where user_id=?";
//        try {
//            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setInt(1, userId);
//            result = statement.executeQuery();
//            while (result.next()) {
//                isAdmin = result.getBoolean("is_admin");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return isAdmin;
//    }
//}


package com.aurionpro.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.aurionpro.database.DBConnector;

public class TransactionDao {

    private final Connection connection;

    public TransactionDao() {
        connection = DBConnector.connect();
    }

    /**
     * Filtered transactions query.
     *
     * userId: the current user's id (used to check admin)
     * sessionAccountId: optionally provided accountId from session (may be null)
     * fromDate/toDate: strings "yyyy-MM-dd" or null
     * minAmountStr/maxAmountStr: numeric strings or null
     * type: "CREDIT"/"DEBIT" or null
     * filterAccountIdStr: admin-specified accountId (string) or null
     *
     * Returns ResultSet (same style as your original code). Caller is responsible for reading it.
     */
    public ResultSet getFilteredTransactions(int userId,
            Integer sessionAccountId,
            String fromDate, String toDate,
            String minAmountStr, String maxAmountStr,
            String type, String filterAccountIdStr) {

        ResultSet rs = null;
        boolean isAdmin = checkIsAdmin(userId);

        StringBuilder sql = new StringBuilder("SELECT * FROM transactions WHERE 1=1 ");

        // account restriction: non-admin -> force account; admin may optionally filter by filterAccountIdStr
        if (!isAdmin) {
            sql.append(" AND account_id = ? ");
        } else {
            if (filterAccountIdStr != null && !filterAccountIdStr.trim().isEmpty()) {
                sql.append(" AND account_id = ? ");
            }
        }

        // date filters (txn_date column assumed TIMESTAMP or DATETIME)
        if (fromDate != null && !fromDate.trim().isEmpty()) sql.append(" AND txn_date >= ? ");
        if (toDate != null && !toDate.trim().isEmpty()) sql.append(" AND txn_date <= ? ");

        // amount filters
        if (minAmountStr != null && !minAmountStr.trim().isEmpty()) sql.append(" AND amount >= ? ");
        if (maxAmountStr != null && !maxAmountStr.trim().isEmpty()) sql.append(" AND amount <= ? ");

        // type filter
        if (type != null && !type.trim().isEmpty()) sql.append(" AND type = ? ");

        try {
            PreparedStatement ps = connection.prepareStatement(sql.toString());
            int idx = 1;

            // bind account param
            if (!isAdmin) {
                int acct = -1;
                if (sessionAccountId != null && sessionAccountId > 0) {
                    acct = sessionAccountId;
                } else {
                    // find first account for this user (if any)
                    acct = findFirstAccountIdForUser(userId);
                }
                ps.setInt(idx++, acct);
            } else if (filterAccountIdStr != null && !filterAccountIdStr.trim().isEmpty()) {
                try {
                    ps.setInt(idx++, Integer.parseInt(filterAccountIdStr.trim()));
                } catch (NumberFormatException nfe) {
                    ps.setInt(idx++, -1); // will match nothing
                }
            }

            // bind date params -> use full day bounds if only dates provided
            if (fromDate != null && !fromDate.trim().isEmpty()) {
                // convert to Timestamp at start of day
                Timestamp fromTs = Timestamp.valueOf(fromDate.trim() + " 00:00:00");
                ps.setTimestamp(idx++, fromTs);
            }
            if (toDate != null && !toDate.trim().isEmpty()) {
                Timestamp toTs = Timestamp.valueOf(toDate.trim() + " 23:59:59");
                ps.setTimestamp(idx++, toTs);
            }

            // bind amounts
            if (minAmountStr != null && !minAmountStr.trim().isEmpty()) {
                try {
                    double min = Double.parseDouble(minAmountStr.trim());
                    ps.setDouble(idx++, min);
                } catch (NumberFormatException nfe) {
                    ps.setDouble(idx++, Double.NEGATIVE_INFINITY);
                }
            }
            if (maxAmountStr != null && !maxAmountStr.trim().isEmpty()) {
                try {
                    double max = Double.parseDouble(maxAmountStr.trim());
                    ps.setDouble(idx++, max);
                } catch (NumberFormatException nfe) {
                    ps.setDouble(idx++, Double.POSITIVE_INFINITY);
                }
            }

            // bind type
            if (type != null && !type.trim().isEmpty()) {
                ps.setString(idx++, type.trim());
            }

            rs = ps.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    /**
     * If user has one or more accounts, return the first account_id found (for customers without session accountId).
     */
    private int findFirstAccountIdForUser(int userId) {
        int accountId = -1;
        String sql = "SELECT account_id FROM account_details WHERE user_id = ? LIMIT 1";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                accountId = rs.getInt("account_id");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accountId;
    }

    public ResultSet getAllTransaction(int accountId, int userId) {
        return getFilteredTransactions(userId, accountId, null, null, null, null, null, null);
    }

    private boolean checkIsAdmin(int userId) {
        boolean isAdmin = false;
        String sql = "SELECT is_admin FROM users WHERE user_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                isAdmin = rs.getBoolean("is_admin");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdmin;
    }
}

