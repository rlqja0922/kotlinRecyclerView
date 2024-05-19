package com.example.kotlin2.CoustomeAlert

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.view.Window
import android.widget.EditText
import android.widget.TextView
import com.example.kotlin2.MemoRoom.MemoEntity
import com.example.kotlin2.R
import com.example.kotlin2.databinding.ActivityMyAlertBinding
import com.example.kotlin2.MemoRoom.deletelistener
import com.example.kotlin2.MemoRoom.updatelistener

class MyAlert(val context : Context, val deletelistener: deletelistener, val updatelistener: updatelistener, val alertint : Int,val position : Int){
    private lateinit var binding: ActivityMyAlertBinding
    private lateinit var btnOK : TextView
    private lateinit var btnCancel : TextView
    private lateinit var alerttext : TextView
    private lateinit var editupdate : EditText
    private val dlg = Dialog(context)
    fun show(memo: MemoEntity) {
        val layout = R.layout.activity_my_alert
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE)   //타이틀바 제거
        dlg.setContentView(R.layout.activity_my_alert)     //다이얼로그에 사용할 xml 파일을 불러옴
        dlg.setCancelable(false)    //다이얼로그의 바깥 화면을 눌렀을 때 다이얼로그가 닫히지 않도록 함
        dlg.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        btnOK = dlg.findViewById(R.id.alert1)
        btnCancel = dlg.findViewById(R.id.alert2)
        editupdate = dlg.findViewById(R.id.editmemo)
        alerttext = dlg.findViewById(R.id.alerttext)

        if (alertint==0){
            editupdate.visibility = View.GONE
            alerttext.visibility= View.VISIBLE

            //ok 버튼 동작
            btnOK.setOnClickListener {

                //TODO: 부모 액티비티로 내용을 돌려주기 위해 작성할 코드

                deletelistener.onDeleteListener(memo,position)
                dlg.dismiss()
            }
        }else{
            alerttext.visibility = View.GONE
            editupdate.visibility= View.VISIBLE

            //ok 버튼 동작
            btnOK.setOnClickListener {

                //TODO: 부모 액티비티로 내용을 돌려주기 위해 작성할 코드
                memo.memo = editupdate.text.toString()
                updatelistener.onupdateListener(memo,position)
                dlg.dismiss()
            }

        }


        //cancel 버튼 동작
        btnCancel.setOnClickListener {
            dlg.dismiss()
        }

        dlg.show()
    }
}