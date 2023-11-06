package com.example.kotlin2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin2.databinding.ItemMemoBinding

class MyAdapter( var list : List<MemoEntity>,val deletelistener: deletelistener) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: ItemMemoBinding ) : RecyclerView.ViewHolder(binding.root){
        val memo = binding.memoText
        val remove = binding.memoRemove
        val root = binding.root
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemVIew  = ItemMemoBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return MyViewHolder(itemVIew)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val memo = list[position]

        holder.memo.text = memo.memo
        holder.remove.setOnClickListener { deletelistener.onDeleteListener(memo) }
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