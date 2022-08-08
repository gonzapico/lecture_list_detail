package xyz.gonzapico.imaginaformacion_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import xyz.gonzapico.imaginaformacion_test.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_detail)
        //setContentView(binding.root)

        binding.textView2.text = intent.extras?.getString("nombre", "")
        binding.textView3.text = intent.extras?.getString("apellidos", "")
        binding.textView4.text = intent.extras?.getString("sexo", "H")
                binding.textView5.text = intent.extras?.getInt("edad", 0).toString()
    }
}