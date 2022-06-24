package com.example.daggerlogin.login

class LoginActivityPresenter(private val model: LoginActivityMVP.Model) : LoginActivityMVP.Presenter {
    private var view: LoginActivityMVP.View? = null
    override fun setView(view: LoginActivityMVP.View) {
        this.view = view
    }

    override fun loginButtonClicked() {
        view?.let { view ->
            val name = view.getName().trim()
            val lastName = view.getLastName().trim()
            if (name.isEmpty() || lastName.isEmpty()) view.showInputError()
            else {
                model.createUser(name, lastName)
                view.showUserSaved()
            }
        }
    }

    override fun getCurrentUser() {
        model.getUser()?.let { user ->
            view?.setName(user.name)
            view?.setLastName(user.lastName)
        } ?: run { view?.showUserNotAvailable() }
    }
}