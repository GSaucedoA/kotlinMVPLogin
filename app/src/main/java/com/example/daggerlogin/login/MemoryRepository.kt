package com.example.daggerlogin.login

class MemoryRepository : LoginRepository {
    private var user: User? = null
    override fun saveUser(user: User) {
        this.user = user
    }

    override fun getUser(): User? = this.user
}