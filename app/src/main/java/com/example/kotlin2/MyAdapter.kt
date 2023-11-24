package com.example.kotlin2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
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

        val context = parent.context
        return MyViewHolder(itemVIew)
    }

    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val memo = list[position]

        val context = holder.root.context
        holder.memo.text = memo.memo
        holder.remove.setOnClickListener {
            val dlg = MyAlert(context, deletelistener)
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