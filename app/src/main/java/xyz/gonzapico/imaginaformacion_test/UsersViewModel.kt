package xyz.gonzapico.imaginaformacion_test

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UsersViewModel : ViewModel() {

    val userModel = MutableLiveData<UserListModel>()

    fun getUsers() {
        val usersList = createGroupOfUsers()
        val userListModel = UserListModel(usersList)
        userModel.postValue(userListModel)
    }

    private fun createGroupOfUsers() = listOf(
        UserModel("Ana", "Fernández", 1996),
        UserModel("Paco", "López", 2000),
        UserModel("Luis", "Antunez", 1980)
    )
}