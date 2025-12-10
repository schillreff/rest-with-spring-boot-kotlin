package com.example

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MathController {

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(
        @PathVariable(value = "numberOne") numberOne: String,
        @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if (!isNumeric(numberOne) && !isNumeric(numberTwo)) {
            throw IllegalArgumentException("Please set a numeric value!")
        }
        return convertDouble(numberOne) + convertDouble(numberTwo)
    }

    private fun convertDouble(number: String): Double {
        return 0.0
    }

    private fun isNumeric(number: String): Boolean {
        return false
    }
}