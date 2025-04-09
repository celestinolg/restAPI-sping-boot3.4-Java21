package com.celestinolg.restAPI_sping_boot.controllers;

import com.celestinolg.restAPI_sping_boot.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedOperationException("please enter a valid number");
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedOperationException("please enter a valid number");
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping("/mult/{numberOne}/{numberTwo}")
    public Double mult(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new ResourceNotFoundException("por favor, adicione o número válido");
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo){
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    @RequestMapping("/raiz/{number}")
    public Double raiz(@PathVariable("number") String number) throws Exception{
        if (!isNumeric(number)) throw new ResourceNotFoundException("Invalid number");
        return Math.sqrt(convertToDouble(number));
    }

    private boolean isNumeric (String strNumber) {
        if(strNumber == null || strNumber.isEmpty()) return false;
        String number = strNumber.replace(",",".");
        return (number.matches("[-+]?[0-9]*\\.?[0-9]+"));
    }

    private Double convertToDouble(String strNumber) throws IllegalArgumentException {
        if(strNumber == null || strNumber.isEmpty())
            throw new UnsupportedOperationException("please enter a valid number");
        String number = strNumber.replace(",",".");
        return Double.parseDouble(number);
    }
}
