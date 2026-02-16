package com.github.BrunoFontenele.controllers.math;

import com.github.BrunoFontenele.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.BrunoFontenele.auxiliary.converters.Converters;
import com.github.BrunoFontenele.auxiliary.verifications.NumberVerifications;

@RestController
@RequestMapping("/math")
public class MathController {
    private final Converters numberConverter = new Converters();
    private final NumberVerifications numberVerifications = new NumberVerifications();
    private final MathOperations mathOperations = new MathOperations();

    //http://localhost:8080/math/sum/3/5
    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ){
        if(!numberVerifications.isNumeric(numberOne) || !numberVerifications.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return mathOperations.sum(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));
    }

    //http://localhost:8080/math/subtraction/3/5
    @RequestMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ){
        if(!numberVerifications.isNumeric(numberOne) || !numberVerifications.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return mathOperations.sub(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));
    }

    //http://localhost:8080/math/multiplication/3/5
    @RequestMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ){
        if(!numberVerifications.isNumeric(numberOne) || !numberVerifications.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return mathOperations.mul(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));
    }

    //http://localhost:8080/math/division/3/5
    @RequestMapping("/division/{numberOne}/{numberTwo}")
    public Double division(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ){
        if(!numberVerifications.isNumeric(numberOne) || !numberVerifications.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        if(numberTwo.equals("0"))
            throw new UnsupportedMathOperationException("Division by zero!");
        return mathOperations.div(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));
    }

    //http://localhost:8080/math/mean/3/5
    @RequestMapping("/mean/{numberOne}/{numberTwo}")
    public Double mean(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ){
        return mathOperations.mean(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));
    }

    //http://localhost:8080/math/root/3/5
    @RequestMapping("/root/{numberOne}/{numberTwo}")
    public Double root(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo
    ){
        if(!numberVerifications.isNumeric(numberOne) || !numberVerifications.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        Double numOne = numberConverter.convertToDouble(numberOne);
        if(numOne < 0)
            throw new UnsupportedMathOperationException("Please set a not negative radicand!");
        if(numberTwo.equals("0"))
            throw new UnsupportedMathOperationException("Index equals 0!");
        return mathOperations.root(numberConverter.convertToDouble(numberOne), numberConverter.convertToDouble(numberTwo));
    }
}
