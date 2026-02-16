package com.github.BrunoFontenele.controllers.math;

public class MathOperations{
    public Double sum(Double a, Double b){
        return a+b;
    }

    public Double sub(Double a, Double b){
        return a-b;
    }

    public Double mul(Double a, Double b){
        return a*b;
    }

    public Double div(Double a, Double b){
        return a/b;
    }

    public Double mean(Double a, Double b){
        return a*b/2;
    }

    public Double root(Double a, Double b){
        return Math.pow(a, 1 / b);
    }
}
