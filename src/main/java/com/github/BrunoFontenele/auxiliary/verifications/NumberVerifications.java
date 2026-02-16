package com.github.BrunoFontenele.auxiliary.verifications;

public class NumberVerifications {
    public boolean isNumeric(String strNumber) {

        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",", "."); //some currencies use comma
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
