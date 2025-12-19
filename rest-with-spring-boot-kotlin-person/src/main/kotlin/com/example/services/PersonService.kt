package com.example.services

import org.springframework.stereotype.Service

@Service
class PersonService {

    private val counter: AtomicLong = AtomicLong()

    private val logger = Logger.getLogger(PersonService::class)

}