package com.example.kotlin2

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),deletelistener,updatelistener {
    lateinit var db : MemoDatabase
    private lateinit var binding : ActivityMainBinding
    var memoList = listOf<MemoEntity>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        db = MemoDatabase.getInstance(this)!!
        setContentView(binding.root)
        binding.Buttonadd.setOnClickListener {
            val memo = MemoEntity(null,binding.editMemo.text.toString())
            insertMemo(memo)
            binding.editMemo.setText("")
        }
        binding.MemoRecyclerView.layoutManager = LinearLayoutManager(this)
        getAllMemos()
    }

    fun insertMemo(memo : MemoEntity){
        val insertTask = object : AsyncTask<Unit,Unit,Unit>(){
            override fun doInBackground(vararg p0: Unit?) {
                db.memoDao().insert(memo)
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)
                getAllMemos()
            }

        }
        insertTask.execute()
    }

    fun getAllMemos(){
        val getTask = (object : AsyncTask<Unit,Unit,Unit>(){
            override fun doInBackground(vararg p0: Unit?) {
                memoList = db.memoDao().getAll()
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)
                setRecyclerView(memoList)
            }

        })
            getTask.execute()
    }

    fun deleteMemo(memo : MemoEntity){
        val deleteTask = object :  AsyncTask<Unit,Unit,Unit>() {
            override fun doInBackground(vararg p0: Unit?) {
                db.memoDao().delete(memo)
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)
                getAllMemos()
            }
        }
        deleteTask.execute()
    }

    fun updateMemo(memo : MemoEntity){
        val updateTask = object :  AsyncTask<Unit,Unit,Unit>() {
            override fun doInBackground(vararg p0: Unit?) {
                db.memoDao().update(memo)
            }

            override fun onPostExecute(result: Unit?) {
                super.onPostExecute(result)
                getAllMemos()
            }
        }
        updateTask.execute()
    }
    fun setRecyclerView(memolist : List<MemoEntity>){
        val adapter = MyAdapter(memolist,this,this)

        binding.MemoRecyclerView.adapter = adapter
    }

    override fun onDeleteListener(memoEntity: MemoEntity) {
        deleteMemo(memoEntity)
    }

    override fun onupdateListener(memoEntity: MemoEntity) {
        updateMemo(memoEntity)
    }
}