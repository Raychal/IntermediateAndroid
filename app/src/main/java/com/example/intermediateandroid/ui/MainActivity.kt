package com.example.intermediateandroid.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.intermediateandroid.adapter.QuoteListAdapter
import com.example.intermediateandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels {
        ViewModelFactory(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvQuote.layoutManager = LinearLayoutManager(this)

        getData()
    }

    private fun getData() {
        val adapter = QuoteListAdapter()
        binding.rvQuote.adapter = adapter
        mainViewModel.quote.observe(this) {
            adapter.submitData(lifecycle, it)
        }
    }
}