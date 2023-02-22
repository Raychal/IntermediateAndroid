package com.example.intermediateandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.intermediateandroid.databinding.ActivityHeroBinding
import com.example.intermediateandroid.model.Hero

class HeroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupData()
    }

    private fun setupData() {
        val hero = intent.getParcelableExtra<Hero>("Hero") as Hero
        Glide.with(applicationContext)
            .load(hero.photo)
            .circleCrop()
            .into(binding.profileImageView)

        binding.nameTextView.text = hero.name
        binding.descTextView.text = hero.description
    }
}