package com.github.BrunoFontenele.auxiliary.converters;


import com.github.BrunoFontenele.exception.UnsupportedMathOperationException;

public class Converters {
    public Double convertToDouble(String strNumber) {
        if (strNumber == null || strNumber.isEmpty())
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }
}
