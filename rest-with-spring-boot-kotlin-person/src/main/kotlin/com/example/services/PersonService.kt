package com.example.services

import com.example.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    private val counter: AtomicLong = AtomicLong()

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findById(id: Long): Person {
        logger.info("Finding one person!")

        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Leandro"
        person.lastName = "Schillreff"
        person.address = "Roraima"
        person.gender = "Male"

        return person
    }

    fun findAll(): List<Person> {

        logger.info("Finding all people!")

        val persons: MutableList<Person> = ArrayList()

        for (i in 0..7) {
            val person = mockPerson()
            persons.add(person)
        }

        return persons
    }

    private fun mockPerson(): Person {

        person.id = counter.incrementAndGet()
        person.firstName = "Leandro"
        person.lastName = "Schillreff"
        person.address = "Roraima"
        person.gender = "Male"
    }

}