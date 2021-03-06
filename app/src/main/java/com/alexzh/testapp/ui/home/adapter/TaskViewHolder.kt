package com.alexzh.testapp.ui.home.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alexzh.testapp.R
import com.alexzh.testapp.model.Task
import kotlinx.android.synthetic.main.item_task.view.*

class TaskViewHolder(
    view: View,
    private val favouriteIconClick: ((Task) -> Unit)?,
    private val itemClick: ((Task) -> Unit)?
) : RecyclerView.ViewHolder(view) {

    fun bind(task: Task) {
        val drawableId = if (task.isFavourite) {
            R.drawable.ic_favorite_black_24dp
        } else {
            R.drawable.ic_favorite_border_black_24dp
        }

        itemView.titleTextView.text = task.title
        itemView.favouriteImageView.setImageResource(drawableId)
        itemView.favouriteImageView.tag = drawableId

        if (favouriteIconClick != null) {
            itemView.favouriteImageView.setOnClickListener { favouriteIconClick.invoke(task) }
        }

        if (itemClick != null) {
            itemView.setOnClickListener { itemClick.invoke(task) }
        }
    }
}
