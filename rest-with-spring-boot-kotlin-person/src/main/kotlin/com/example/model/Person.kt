package com.example.model

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table
data class Person(
    var id: Long = 0,
    var firstName: String = "",
    var lastName: String = "",
    var address: String = "",
    var gender: String = ""
)