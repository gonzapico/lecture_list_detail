package xyz.gonzapico.imaginaformacion_test

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import xyz.gonzapico.imaginaformacion_test.databinding.ActivityDetailBinding
import xyz.gonzapico.imaginaformacion_test.placeholder.PlaceholderContent

class DetailActivity : AppCompatActivity() {

    companion object {
        val EXTRA_ID = "DetailActivity:name"
        val INDEX = "DetailActivity:id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var index = intent.extras?.getInt(INDEX, 0) ?: 0
        if (index > 0)
            index--
        val item = PlaceholderContent.ITEMS[index]
        binding.tvName.text = item.content

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // If the screen is now in landscape mode, we can show the
            // dialog in-line with the list so we don't need this activity.
            finish()
            return
        }

        if (savedInstanceState == null) {
            // During initial setup, plug in the details fragment.
            val details = DetailsFragment()
            details.arguments = intent.extras
            supportFragmentManager.beginTransaction().add(android.R.id.content, details).commit()
        }
    }
}