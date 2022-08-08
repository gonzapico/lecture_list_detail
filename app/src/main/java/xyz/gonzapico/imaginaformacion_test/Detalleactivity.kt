package xyz.gonzapico.imaginaformacion_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import xyz.gonzapico.imaginaformacion_test.databinding.ActivityDetalleactivityBinding

class Detalleactivity : AppCompatActivity() {
    companion object{
        val PNOMBRE="DetailActivity:name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityDetalleactivityBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_detalleactivity)
        setContentView(binding.root)
        binding.nombre.text=intent.extras?.getString(PNOMBRE,"sin nombre")
    }
}