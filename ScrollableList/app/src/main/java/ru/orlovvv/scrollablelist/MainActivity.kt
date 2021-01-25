package ru.orlovvv.scrollablelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.orlovvv.scrollablelist.adapter.ItemAdapter
import ru.orlovvv.scrollablelist.data.Datasource
import ru.orlovvv.scrollablelist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val myDataSet = Datasource().loadAffirmations()
        val recyclerView = binding.recyclerView
        recyclerView.adapter = ItemAdapter(this, myDataSet)
        recyclerView.setHasFixedSize(true)
    }
}