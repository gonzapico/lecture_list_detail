package xyz.gonzapico.imaginaformacion_test

import java.util.*

class UserPresenter(val userView: UserView) {

    init {
        userView.showLoading()
        getUsers()
    }

    fun getUsers(){
        val usersList = createGroupOfUsers()
        userView.loadUsers(usersList)
        userView.hideLoading()
    }

    private fun createGroupOfUsers() = listOf(
        UserModel("Ana", "Fernández", 1996),
        UserModel("Paco", "López", 2000),
        UserModel("Luis", "Antunez", 1980)
    )
}