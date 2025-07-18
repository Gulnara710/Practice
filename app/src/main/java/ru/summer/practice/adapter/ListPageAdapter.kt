package ru.summer.practice.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.summer.practice.R
import ru.summer.practice.model.ListPageItemModel
import ru.summer.practice.viewholder.ListPageViewHolder

class ListPageAdapter(
    private val items: MutableList<ListPageItemModel>,
    private val onItemClick: (Int) -> Unit,
    private val onImageClick: (Int) -> Unit
) : RecyclerView.Adapter<ListPageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListPageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list_page, parent, false)
        return ListPageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListPageViewHolder, position: Int) {
        holder.bind(items[position], onItemClick, onImageClick)
    }

    override fun getItemCount(): Int = items.size

    fun updateItem(position: Int, newModel: ListPageItemModel) {
        items[position] = newModel
        notifyItemChanged(position)
    }
}