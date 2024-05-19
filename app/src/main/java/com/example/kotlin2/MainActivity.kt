package com.example.kotlin2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin2.Coroutine.CoroutineStudyActivity
import com.example.kotlin2.MemoRoom.MemoActivity
import com.example.kotlin2.MemoRoom.MemoDatabase
import com.example.kotlin2.MemoRoom.MemoEntity
import com.example.kotlin2.MemoRoom.deletelistener
import com.example.kotlin2.MemoRoom.updatelistener
import com.example.kotlin2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    var memoList = listOf<MemoEntity>()
    var intent1 = Intent()
    lateinit var context: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this
        binding.memoFl.setOnClickListener {
            intent1 = Intent(context,MemoActivity::class.java)
            startActivity(intent1)
        }
        binding.coroutineFl.setOnClickListener {
            intent1 = Intent(context,CoroutineStudyActivity::class.java)
            startActivity(intent1)
        }
    }

}