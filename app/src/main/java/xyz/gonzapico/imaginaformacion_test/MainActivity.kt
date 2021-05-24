package xyz.gonzapico.imaginaformacion_test

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import xyz.gonzapico.imaginaformacion_test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), UserView {

    private lateinit var binding: ActivityMainBinding
    private lateinit var userPresenter: UserPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        userPresenter = UserPresenter(this)

    }

    override fun showLoading() {
        binding.pbUsers.visibility = View.VISIBLE
        binding.rvListOfElements.visibility = View.GONE
    }

    override fun loadUsers(listOfUsers: List<UserModel>) {
        // RecyclerView
        val rvListOfElements = binding.rvListOfElements
        // Adapter
        rvListOfElements.adapter = UsersAdapter(listOfUsers)
        rvListOfElements.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvListOfElements.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.pbUsers.visibility = View.GONE
    }
}