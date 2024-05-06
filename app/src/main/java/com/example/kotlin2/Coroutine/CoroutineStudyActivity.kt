package com.example.kotlin2.Coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.kotlin2.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.LocalDateTime

class CoroutineStudyActivity : AppCompatActivity() {

    private val job = GlobalScope.launch(start = CoroutineStart.LAZY) {
        logging("2",5)
    }
    lateinit var cort1_bt: Button
    lateinit var cort2_bt: Button
    lateinit var cort3_bt: Button
    lateinit var cort4_bt: Button
    lateinit var cort5_bt: Button

    lateinit var coroutine_tx1_1: TextView
    lateinit var coroutine_tx1_2: TextView
    lateinit var coroutine_tx2_1: TextView
    lateinit var coroutine_tx2_2: TextView
    lateinit var coroutine_tx3_1: TextView
    lateinit var coroutine_tx3_2: TextView
    lateinit var coroutine_tx4_1: TextView
    lateinit var coroutine_tx4_2: TextView
    lateinit var coroutine_tx5_1: TextView
    lateinit var coroutine_tx5_2: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_study)
        cort1_bt = findViewById(R.id.cort1_bt)
        cort2_bt = findViewById(R.id.cort2_bt)
        cort3_bt = findViewById(R.id.cort3_bt)
        cort4_bt = findViewById(R.id.cort4_bt)
        cort5_bt = findViewById(R.id.cort5_bt)
        coroutine_tx1_1 = findViewById(R.id.coroutine_tx1_1)
        coroutine_tx1_2 = findViewById(R.id.coroutine_tx1_2)
        coroutine_tx2_1 = findViewById(R.id.coroutine_tx2_1)
        coroutine_tx2_2 = findViewById(R.id.coroutine_tx2_2)
        coroutine_tx3_1 = findViewById(R.id.coroutine_tx3_1)
        coroutine_tx3_2 = findViewById(R.id.coroutine_tx3_2)
        coroutine_tx4_1 = findViewById(R.id.coroutine_tx4_1)
        coroutine_tx4_2 = findViewById(R.id.coroutine_tx4_2)
        coroutine_tx5_1 = findViewById(R.id.coroutine_tx5_1)
        coroutine_tx5_2 = findViewById(R.id.coroutine_tx5_2)
    }

    fun logging(msg: String, i: Int) {

        runBlocking { question1() }
        when (i) {
            1 -> {
                coroutine_tx1_1.setText("runBlocking : ${java.lang.Thread.currentThread().name}")
            }

            2 -> {
                coroutine_tx2_1.setText("runBlocking : ${java.lang.Thread.currentThread().name}")
            }

            3 -> {
                coroutine_tx3_1.setText("runBlocking : ${java.lang.Thread.currentThread().name}")
            }

            4 -> {
                coroutine_tx4_1.setText("runBlocking : ${java.lang.Thread.currentThread().name}")
            }

            5 -> {
                coroutine_tx5_1.setText("runBlocking : ${java.lang.Thread.currentThread().name}")
            }
        }
    }

    fun question1() {
        var text = "runBlocking before"
        logging("1",1)
        coroutine_tx1_2.setText(text)
        runBlocking {
            logging("2",1)
            text = "runBlocking running"
            coroutine_tx1_2.setText(text)
        }
        text = "runBlocking after"
        coroutine_tx1_2.setText(text)
        logging("3",1)
    }

    fun question2() {
        logging("1",2)
        question2_2()
        logging("3",2)
    }

    fun question2_2() {
        runBlocking {
            logging("2",2)
        }
    }

    suspend fun question3() {
        logging("1",3)
        CoroutineScope(Dispatchers.IO).launch {
            logging("2",3)
            delay(2000)
            logging("3",3)
        }
        logging("4",3)
        delay(2500)
    }

    //join() / await()를 사용하면 해당 코루틴이 종료될때 까지 대기합니다.
    suspend fun question4() {
        logging("1",4)
        GlobalScope.async {
            logging("2",4)
            delay(1000)
            logging("3",4)
        }
        logging("4",4)

        delay(1500)
    }

    suspend fun question5() {
        logging("1",5)
        delay(200)
        logging("3",5)
        job.start()
    }
}