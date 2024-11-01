package au.com.shaneraiteri.junit5nestedannotationtests;

import java.math.BigDecimal;

public class Calculator {

    public BigDecimal add(final BigDecimal a,
                          final BigDecimal b) {
        return a.add(b);
    }

    public BigDecimal subtract(final BigDecimal a,
                               final BigDecimal b) {
        return a.subtract(b);
    }
}
