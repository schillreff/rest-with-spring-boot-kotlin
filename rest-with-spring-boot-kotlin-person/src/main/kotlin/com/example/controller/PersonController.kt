package com.example.controller

import com.example.converters.NumberConverter
import com.example.exceptions.UnsupportedMathOperationException
import com.example.math.SimpleMath
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PersonController {

    companion object {
        const val UNSUPPORTED_MATH_OPERATION_EXCEPTION_MESSAGE = "Please set a numeric value!"
    }

    @Autowired
    private lateinit var service: PersonService

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
}