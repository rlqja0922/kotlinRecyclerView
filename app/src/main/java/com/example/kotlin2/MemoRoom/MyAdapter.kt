package com.example.kotlin2.MemoRoom

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin2.CoustomeAlert.MyAlert
import com.example.kotlin2.databinding.ItemMemoBinding

class MyAdapter(var list : List<MemoEntity>, val deletelistener: deletelistener, val updatelistener1 : updatelistener) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: ItemMemoBinding ) : RecyclerView.ViewHolder(binding.root){
        val memo = binding.memoText
        val remove = binding.memoRemove
        val root = binding.root
        val update = binding.memoUpdate
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemVIew  = ItemMemoBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        val context = parent.context
        return MyViewHolder(itemVIew)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val memo = list[position]

        val context = holder.root.context
        holder.memo.text = memo.memo
        holder.remove.setOnClickListener {
            val dlg = MyAlert(context, deletelistener,updatelistener1,0)
            dlg.show(memo)
        }
        holder.update.setOnClickListener {
            val dlg = MyAlert(context, deletelistener,updatelistener1,1)
            dlg.show(memo)
        }
//        holder.root.setOnLongClickListener(object : View.OnLongClickListener{
//            override fun onLongClick(v: View?): Boolean {
//                    deletelistener.onDeleteListener(memo)
//                return true
//            }
//        })
    }

    override fun getItemCount(): Int {
        return list.size
    }
}