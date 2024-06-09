package com.rslakra.hellokafka;

/**
 * @author: Rohtash Lakra (rlakra)
 * @since: 10/30/19 5:37 PM
 */
public interface Consumer {

    enum AutoOffsetReset {
        EARLIEST("earliest"), LATEST("latest"), NONE("none");


        private AutoOffsetReset(final String value) {
            this.value = value;
        }

        private final String value;

        @Override
        public String toString() {
            return value;
        }
    }

    void consume();
}
