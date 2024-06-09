package com.rslakra.interview.highnote;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @since 12/07/2023 12:29 PM
 */
public class AccountManager {
    private static final BigDecimal DEPOSIT_LIMIT = new BigDecimal(1000);
    private static final BigDecimal WITHDRAWAL_LIMIT = new BigDecimal(500);
    private static final BigDecimal WITHDRAWAL_ONE_TIME = new BigDecimal(200);
    private Map<BigInteger, Account> accounts;

    AccountManager() {
        accounts = new HashMap<>();
    }

    /**
     * Create account.
     *
     * @param account
     */
    public void create(Account account) {
        if (!accounts.containsKey(account.getAccountNumber())) {
            accounts.put(account.getAccountNumber(), account);
        }
    }

    /**
     * @param accountNumber
     * @return
     */
    public boolean exists(BigInteger accountNumber) {
        return accounts.containsKey(accountNumber);
    }

    /**
     * @param accountNumber
     * @return
     */
    public Account find(BigInteger accountNumber) {
        return accounts.get(accountNumber);
    }

    /**
     * @param transaction
     */
    public void deposit(Transaction transaction) {
        Account account = null;
        if (TransactionCode.DEPOSIT != transaction.getTxCode()) {
            throw new RuntimeException("Invalid transaction code");
        }

        if (!accounts.containsKey(transaction.getAccountNumber())) {
            account = new Account(transaction.getAccountNumber());
            accounts.put(transaction.getAccountNumber(), account);
        }
        account = accounts.get(transaction.getAccountNumber());
        // validations
        if (DEPOSIT_LIMIT.compareTo(transaction.getAmount()) > 0) {
            account.updateBalance(transaction.getTxCode(), transaction.getAmount());
        } else {
            System.out.println("Decline Deposit!");
        }
    }

    /**
     * @param transaction
     */
    public void withdrawal(Transaction transaction) {
        if (TransactionCode.WITHDRAW != transaction.getTxCode()) {
            throw new RuntimeException("Invalid transaction code");
        }

        if (accounts.containsKey(transaction.getAccountNumber())) {
            // TODO
            if (WITHDRAWAL_LIMIT.compareTo(transaction.getAmount()) > 0) {
                Account account = accounts.get(transaction.getAccountNumber());
                account.updateBalance(transaction.getTxCode(), transaction.getAmount());
            }

            if (WITHDRAWAL_ONE_TIME.compareTo(transaction.getAmount()) > 0) {
                Account account = accounts.get(transaction.getAccountNumber());
                account.updateBalance(transaction.getTxCode(), transaction.getAmount());
            }
        } else {
            System.out.println("Decline Withdrawal!");
        }
    }


}
