package com.example.kotlin2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin2.MemoRoom.MemoActivity
import com.example.kotlin2.MemoRoom.MemoDatabase
import com.example.kotlin2.MemoRoom.MemoEntity
import com.example.kotlin2.MemoRoom.deletelistener
import com.example.kotlin2.MemoRoom.updatelistener
import com.example.kotlin2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var memoList = listOf<MemoEntity>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.memoFl.setOnClickListener {
            intent = Intent(this,MemoActivity::class.java)
            startActivity(intent)
        }
    }

}