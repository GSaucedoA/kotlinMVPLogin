package com.example.daggerlogin.login

import dagger.Module
import dagger.Provides

@Module
class LoginModule {
    @Provides
    fun providesLoginActivityPresenter(model: LoginActivityMVP.Model): LoginActivityMVP.Presenter =
        LoginActivityPresenter(model)

    @Provides
    fun providesLoginActivityModel(repository: LoginRepository): LoginActivityMVP.Model =
        LoginActivityModel(repository)

    @Provides
    fun providesLoginRepository(): LoginRepository = MemoryRepository()
}