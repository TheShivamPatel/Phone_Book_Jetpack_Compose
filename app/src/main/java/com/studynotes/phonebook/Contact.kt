package com.studynotes.phonebook

import java.io.Serializable

data class Contact(
    val firstName : String,
    val lastName : String,
    val phone : String
) : Serializable
