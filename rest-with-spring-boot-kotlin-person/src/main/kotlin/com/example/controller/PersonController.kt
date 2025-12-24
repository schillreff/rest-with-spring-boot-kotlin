package com.example.controller

import com.example.converters.NumberConverter
import com.example.exceptions.UnsupportedMathOperationException
import com.example.services.PersonService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMethod

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    private lateinit var service: PersonService


    @RequestMapping(value = ["/{id}"], method = [(RequestMethod.GET)])
    fun sum(
        @PathVariable(value = "numberOne") numberOne: String, @PathVariable(value = "numberTwo") numberTwo: String
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw UnsupportedMathOperationException("Please set a numeric value!")
        }
        return 1.0;
    }
}