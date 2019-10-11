package com.verifone.training

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.element_item.view.*

class ListAdapter(val items: List<MenuItem>) : RecyclerView.Adapter<StringViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        val elementItem = LayoutInflater.from(parent.context).inflate(R.layout.element_item, parent, false)
        val viewHolder = StringViewHolder(elementItem)
        return viewHolder
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        val element = items[position]
        holder.itemView.element_name.text = element.title
    }
}