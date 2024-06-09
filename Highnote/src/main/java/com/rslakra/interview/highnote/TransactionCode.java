package com.rslakra.interview.highnote;

import java.util.Arrays;

/**
 * @author Rohtash Lakra (rslakra.work@gmail.com)
 * @version 1.0.0
 * @since 12/07/2023 12:20 PM
 */
public enum TransactionCode {

    DEPOSIT("1010"),
    WITHDRAW("1020");

    private String code;

    TransactionCode(String code) {
        this.code = code;
    }

    /**
     * Code to object.
     *
     * @param code
     * @return
     */
    public static TransactionCode ofString(String code) {
        return Arrays.stream(TransactionCode.values()).filter(entry -> entry.code.compareTo(code) == 0).findFirst().orElse(null);
    }

}
