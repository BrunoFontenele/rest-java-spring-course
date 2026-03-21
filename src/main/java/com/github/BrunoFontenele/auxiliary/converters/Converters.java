package com.github.BrunoFontenele.auxiliary.converters;


import com.github.BrunoFontenele.exception.ResourceNotFoundException;
import org.springframework.web.client.ResourceAccessException;

public class Converters {
    public Double convertToDouble(String strNumber) {
        if (strNumber == null || strNumber.isEmpty())
            throw new ResourceAccessException("Please set a numeric value!");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }
}
