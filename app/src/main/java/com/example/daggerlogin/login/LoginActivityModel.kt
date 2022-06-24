package com.example.daggerlogin.login

class LoginActivityModel(private val repository: LoginRepository) : LoginActivityMVP.Model {
    override fun createUser(name: String, lastName: String) =
        repository.saveUser(User(name = name, lastName = lastName))

    override fun getUser(): User? = repository.getUser()
}