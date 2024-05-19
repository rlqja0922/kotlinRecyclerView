package com.example.kotlin2.MVVM

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin2.databinding.ActivityMvvmBinding

class MvvmActivity(private val viewModel: MainViewModel) : AppCompatActivity() {
    private lateinit var binding : ActivityMvvmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvvmBinding.inflate(layoutInflater)
    }
}