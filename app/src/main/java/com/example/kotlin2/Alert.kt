package com.example.kotlin2

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin2.databinding.AlertBinding

class Alert : AppCompatActivity() {
    // view
    private lateinit var bind : AlertBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = AlertBinding.inflate(layoutInflater)
        setContentView(bind.root)


        // 기본 형태의 다이얼로그
        bind.alertDialogButton.setOnClickListener {
            // 다이얼로그를 생성하기 위해 Builder 클래스 생성자를 이용해 줍니다.
            val builder = AlertDialog.Builder(this)
            builder.setTitle("타이틀 입니다.")
                .setMessage("메세지 내용 부분 입니다.")
                .setPositiveButton("확인",
                    DialogInterface.OnClickListener { dialog, id ->
                        bind.resultText.text = "확인 클릭"
                    })
                .setNegativeButton("취소",
                    DialogInterface.OnClickListener { dialog, id ->
                        bind.resultText.text = "취소 클릭"
                    })
            // 다이얼로그를 띄워주기
            builder.show()
        }

        // 리스트 형태의 다이얼로그
        var colorArray: Array<String> = arrayOf("빨강", "주황", "초록", "파랑") // 리스트에 들어갈 Array
        bind.listDialogButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("컬러 선택하기")
                .setItems(colorArray,
                    DialogInterface.OnClickListener { dialog, which ->
                        // 여기서 인자 'which'는 배열의 position을 나타냅니다.
                        bind.resultText.text = colorArray[which]
                    })
            // 다이얼로그를 띄워주기
            builder.show()
        }
    }
}