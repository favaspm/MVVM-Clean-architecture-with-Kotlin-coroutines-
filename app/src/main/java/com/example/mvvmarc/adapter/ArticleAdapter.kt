package com.example.mvvmarc.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmarc.databinding.ItemArticleBinding
import com.example.mvvmarc.model.response.ArticleData

class ArticleAdapter() : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    private val list=ArrayList<ArticleData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            ItemArticleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(list: List<ArticleData>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class ViewHolder internal constructor(var binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ArticleData) {
//            Log.e("url",data.primaryImage)
            binding.data=data
            binding.executePendingBindings()
        }

    }
}