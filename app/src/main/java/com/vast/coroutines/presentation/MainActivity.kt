package com.vast.coroutines.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vast.coroutines.databinding.ActivityMainBinding
import com.vast.coroutines.presentation.animals.list.AnimalListFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(binding.animalListFragment.id, AnimalListFragment.newInstance())
            .commit()
    }
}