package com.hiking.example.recyclerviewcontextmenu

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.list_item_main.view.*

class MainAdapter(private val context: Context) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val mockData = (0 until 100).map {
        val title = context.getString(R.string.title_format, it)
        val content = context.getString(R.string.content_format, it)
        SampleData(title, content)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.titleTextView
        val contentTextView: TextView = itemView.contentTextView

        init {
            this.itemView.isLongClickable = true
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_main, parent, false))

    override fun getItemCount() = mockData.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = mockData[position]
        holder.apply {
            itemView.tag = data
            titleTextView.text = data.title
            contentTextView.text = data.content
        }
    }
}