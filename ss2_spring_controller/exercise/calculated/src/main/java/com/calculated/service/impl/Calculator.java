package com.calculated.service.impl;

import com.calculated.service.ICalculator;
import org.springframework.stereotype.Service;

@Service
public class Calculator implements ICalculator {
    @Override
    public String calculate(double numberOne, double numberTwo , String calculation) {
        String result = "";
        String check = "Không thể chia cho 0";

        switch (calculation){
            case "Addition(+)":
                result = numberOne + numberTwo + "";
                break;
            case "Subtraction(-)":
                result = numberOne - numberTwo + "";
                break;
            case "Multiplication(*)":
                result = numberOne * numberTwo + "";
                break;
            case "Division(/)":
                if (numberTwo == 0){
                    result = check;
                }else {
                    result = numberOne / numberTwo + "";
                }
                break;

        }
        return result;
    }
}
