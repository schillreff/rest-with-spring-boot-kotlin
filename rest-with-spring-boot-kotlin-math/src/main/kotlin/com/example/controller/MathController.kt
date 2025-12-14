package com.example.controller

import com.example.converters.NumberConverter
import com.example.exceptions.UnsupportedMathOperationException
import com.example.math.SimpleMath
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MathController {

    companion object {
        const val UNSUPPORTED_MATH_OPERATION_EXCEPTION_MESSAGE = "Please set a numeric value!"
    }

    private val math: SimpleMath = SimpleMath()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(
        @PathVariable(value = "numberOne") numberOne: String, @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw UnsupportedMathOperationException(UNSUPPORTED_MATH_OPERATION_EXCEPTION_MESSAGE)
        }
        return math.sum(
            NumberConverter.convertDouble(numberOne), NumberConverter.convertDouble(numberTwo)
        )
    }

    @RequestMapping(value = ["/subtraction/{numberOne}/{numberTwo}"])
    fun subtraction(
        @PathVariable(value = "numberOne") numberOne: String, @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw UnsupportedMathOperationException(UNSUPPORTED_MATH_OPERATION_EXCEPTION_MESSAGE)
        }
        return math.subtraction(NumberConverter.convertDouble(numberOne), NumberConverter.convertDouble(numberTwo))
    }

    @RequestMapping(value = ["/multiplication/{numberOne}/{numberTwo}"])
    fun multiplication(
        @PathVariable(value = "numberOne") numberOne: String, @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || NumberConverter.isNumeric(numberTwo)) {
            throw UnsupportedMathOperationException(UNSUPPORTED_MATH_OPERATION_EXCEPTION_MESSAGE)
        }
        return math.multiplication(NumberConverter.convertDouble(numberOne), NumberConverter.convertDouble(numberTwo))
    }

    @RequestMapping(value = ["/division/{numberOne}/{numberTwo}"])
    fun division(
        @PathVariable(value = "numberOne") numberOne: String, @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw UnsupportedMathOperationException(UNSUPPORTED_MATH_OPERATION_EXCEPTION_MESSAGE)
        }
        return math.division(NumberConverter.convertDouble(numberOne), NumberConverter.convertDouble(numberTwo))
    }
}