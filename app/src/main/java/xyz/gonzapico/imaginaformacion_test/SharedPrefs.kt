package xyz.gonzapico.imaginaformacion_test

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.room.Room
import xyz.gonzapico.imaginaformacion_test.data.AppDB

class SharedPrefs (context: Context) {
    val PREFS_NAME = "imagina_formacion"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)

    // Crearemos una variable para cada valor
    /* NAME */
    val SHARED_NAME = "shared_name"
    var name: String
        get() = prefs.getString(SHARED_NAME, "") ?: ""
        set(value) = prefs.edit().putString(SHARED_NAME, value).apply()

    /* SURNAME */
    val SHARED_SURNAME = "shared_surname"
    var surname: String
        get() = prefs.getString(SHARED_SURNAME, "") ?: ""
        set(value) = prefs.edit().putString(SHARED_SURNAME, value).apply()
}

class Application : Application(){
    val db = Room.databaseBuilder(
        applicationContext,
        AppDB::class.java, "database-name"
    ).enableMultiInstanceInvalidation().build()

    companion object {
        lateinit var prefs: SharedPrefs
    }

    override fun onCreate() {
        super.onCreate()
        prefs = SharedPrefs(this)
        prefs.name = "Imagina"
        prefs.surname = "Formación"
        Log.d("Application", "Name ${prefs.name} -- Apellido ${prefs.surname}")
    }
}