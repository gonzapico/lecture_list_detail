package xyz.gonzapico.imaginaformacion_test

interface UserView {
    fun showLoading()
    fun loadUsers(listOfUserModels: List<UserModel>)
    fun hideLoading()
}