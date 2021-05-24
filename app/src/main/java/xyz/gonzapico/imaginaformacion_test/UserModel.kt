package xyz.gonzapico.imaginaformacion_test

data class UserModel(val name: String,
                     val username: String,
                     val phone: String){
    override fun toString(): String {
        return "$name ($username) - $phone"
    }
}