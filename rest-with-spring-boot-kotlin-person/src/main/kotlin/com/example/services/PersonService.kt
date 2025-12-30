package com.example.services

import com.example.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    private val counter: AtomicLong = AtomicLong()

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findAll(): List<Person> {

        logger.info("Finding all people!")

        val persons: MutableList<Person> = ArrayList()

        for (i in 0..7) {
            val person = mockPerson("Leandro")
            persons.add(person)
        }

        return persons
    }

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

    fun create(person: Person) = person

    fun update(person: Person) = person

    fun delete(id: Long) {

    }


    private fun mockPerson(name: String): Person {
        val person = Person()
        person.id = counter.incrementAndGet()
        person.firstName = "Person Name: ${name}"
        person.lastName = "Schillreff"
        person.address = "Roraima"
        person.gender = "Male"

        return person
    }

}