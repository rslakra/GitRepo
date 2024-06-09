package com.rslakra.interview.highnote;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @since 12/07/2023 12:20 PM
 */
@Getter
@Setter
public class Transaction {
    private TransactionCode txCode;
    private transient int accountNumberLength;
    private BigInteger accountNumber;
    private BigDecimal amount;
}
