package xyz.gonzapico.imaginaformacion_test

data class UserModel(val name: String, val surname: String, val birthYear: Int){
    override fun toString(): String {
        return "$name $surname - $birthYear"
    }
}