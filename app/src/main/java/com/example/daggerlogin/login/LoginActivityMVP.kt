package com.example.daggerlogin.login

interface LoginActivityMVP {
    interface Model {
        fun createUser(name: String, lastName: String)
        fun getUser(): User?
    }

    interface View {
        fun getName(): String
        fun getLastName(): String

        fun showUserNotAvailable()
        fun showInputError()
        fun showUserSaved()

        fun setName(name: String)
        fun setLastName(lastName: String)
    }

    interface Presenter {
        fun setView(view: View)

        fun loginButtonClicked()

        fun getCurrentUser()
    }
}