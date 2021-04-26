package com.example.androidpractice.adapter

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidpractice.R
import com.example.androidpractice.model.NewsModel

class RecyclerAdapter(var context: Context, var newsList: ArrayList<NewsModel>) :
    RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>() {

    companion object{
        val ITEM_TYPE_ONE = 1
        val ITEM_TYPE_TWO = 2
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById<TextView>(R.id.txt_title)
        var desc: TextView = itemView.findViewById<TextView>(R.id.txt_desc)
        var date: TextView = itemView.findViewById<TextView>(R.id.txt_date)
        var image: ImageView = itemView.findViewById<ImageView>(R.id.imageView)


    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.animated_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val newsItem = newsList[position]
        holder.title.text = newsItem.title
        holder.date.text = newsItem.date
        holder.desc.text = newsItem.description
        holder.image.setImageResource(newsItem.image)
    }

    override fun getItemCount() = newsList.size

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }
}