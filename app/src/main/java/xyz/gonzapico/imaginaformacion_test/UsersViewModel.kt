package xyz.gonzapico.imaginaformacion_test

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UsersViewModel : ViewModel() {

    val usersModel = MutableLiveData<List<UserModel>>()

    fun getUsers() {
        viewModelScope.launch {
            usersModel.value = DataNetwork.retrofit.getUsers()
        }
    }
}