package com.example.daggerlogin.login

import java.util.*

data class User(val id: UUID = UUID.randomUUID(), val name: String, val lastName: String)
