package xyz.gonzapico.imaginaformacion_test

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import xyz.gonzapico.imaginaformacion_test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val p1=Persona("Ana","Ramos",'H',30)
        val p2=Persona("Manuel","Gonzalez",'M',42)
        val p3=Persona("Tomasa","Brosa",'H',22)
        val lisper = arrayOf<Persona>(p1,p2,p3)


        // Contenido
        val listOfPeople = ElementsAdapter(lisper)

        // RecyclerView
        val rvListOfElements = binding.rvListOfElements
        // Adapter
        rvListOfElements.adapter = listOfPeople
        rvListOfElements.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    private fun goToDetailActivity(parper: Persona) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("nombre", parper.nombre)
        intent.putExtra("apellidos", parper.apellidos)
        intent.putExtra("edad", parper.edad)
        intent.putExtra("sexo", parper.sexo)
        startActivity(intent)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}