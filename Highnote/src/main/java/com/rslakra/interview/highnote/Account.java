package com.rslakra.interview.highnote;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @since 12/07/2023 12:19 PM
 */
@Getter
@Setter
@NoArgsConstructor
public class Account {

    private BigInteger accountNumber;
    private BigDecimal balance;

    public Account(BigInteger accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     *
     * @param transactionCode
     * @param amount
     */
    public void updateBalance(TransactionCode transactionCode, BigDecimal amount) {
        switch (transactionCode) {
            case DEPOSIT:
                break;
            case WITHDRAW:
                break;
            default:
                System.out.println("Invalid Transaction!");
                break;
        }
    }


    provate

}
