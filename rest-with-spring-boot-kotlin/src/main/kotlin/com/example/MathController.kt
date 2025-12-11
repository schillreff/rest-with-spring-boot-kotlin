package com.example

import com.example.exceptions.UnsupportedMathOperationException
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MathController {

    companion object {
        const val UNSUPPORTED_MATH_OPERATION_EXCEPTION_MESSAGE = "Please set a numeric value!"
    }

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(
        @PathVariable(value = "numberOne") numberOne: String, @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw UnsupportedMathOperationException(UNSUPPORTED_MATH_OPERATION_EXCEPTION_MESSAGE)
        }
        return convertDouble(numberOne) + convertDouble(numberTwo)
    }

    @RequestMapping(value = ["/subtraction/{numberOne}/{numberTwo}"])
    fun subtraction(
        @PathVariable(value = "numberOne") numberOne: String, @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw UnsupportedMathOperationException(UNSUPPORTED_MATH_OPERATION_EXCEPTION_MESSAGE)
        }
        return convertDouble(numberOne) - convertDouble(numberTwo)
    }

    @RequestMapping(value = ["/multiplication/{numberOne}/{numberTwo}"])
    fun multiplication(
        @PathVariable(value = "numberOne") numberOne: String, @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if (!isNumeric(numberOne) || isNumeric(numberTwo)) {
            throw UnsupportedMathOperationException(UNSUPPORTED_MATH_OPERATION_EXCEPTION_MESSAGE)
        }
        return convertDouble(numberOne) * convertDouble(numberTwo)
    }

    @RequestMapping(value = ["/division/{numberOne}/{numberTwo}"])
    fun division(
        @PathVariable(value = "numberOne") numberOne: String, @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw UnsupportedMathOperationException(UNSUPPORTED_MATH_OPERATION_EXCEPTION_MESSAGE)
        }
        return convertDouble(numberOne) / convertDouble(numberTwo)
    }

    private fun convertDouble(strNumber: String): Double {
        if (strNumber.isNullOrBlank()) return 0.0
        val number = strNumber.replace(",".toRegex(), ".")
        return if (isNumeric(number)) number.toDouble() else 0.0
    }

    private fun isNumeric(strNumber: String): Boolean {
        if (strNumber.isNullOrBlank()) return false
        val number = strNumber.replace(",".toRegex(), ".")
        return number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }
}