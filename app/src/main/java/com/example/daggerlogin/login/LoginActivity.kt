package com.example.daggerlogin.login

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.daggerlogin.databinding.ActivityMainBinding
import com.example.daggerlogin.root.Application
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginActivityMVP.View {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var presenter: LoginActivityMVP.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        (application as Application).getComponent().inject(this)
        setUpListeners()
    }

    private fun setUpListeners() = binding.run {
        buttonLogin.setOnClickListener { presenter.loginButtonClicked() }
    }

    private fun String.toast(context: Context) =
        Toast.makeText(context, this, Toast.LENGTH_SHORT).show()

    override fun getName() = binding.editTextName.text.toString()

    override fun getLastName() = binding.editTextLastName.text.toString()

    override fun showUserNotAvailable() = "Error, el usuario no está disponible".toast(this)

    override fun showInputError() =
        "Error, el nombre ni el apellido pueden estar vacíos".toast(this)

    override fun showUserSaved() = "Usuario guardado correctamente".toast(this)

    override fun setName(name: String) = binding.editTextName.setText(name)

    override fun setLastName(lastName: String) = binding.editTextLastName.setText(lastName)


    override fun onResume() {
        super.onResume()
        presenter.setView(this)
        presenter.getCurrentUser()
    }
}