package xyz.gonzapico.imaginaformacion_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import xyz.gonzapico.imaginaformacion_test.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        val EXTRA_ID = "DetailActivity:name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvName.text = intent.extras?.getString(EXTRA_ID, "")
    }
}