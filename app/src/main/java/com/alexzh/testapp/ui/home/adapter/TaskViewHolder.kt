package com.alexzh.testapp.ui.home.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.alexzh.testapp.R
import com.alexzh.testapp.model.Task
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_task.view.*

class TaskViewHolder(
    private val view: View,
    val favouriteClick: (Task) -> Unit
) : RecyclerView.ViewHolder(view) {

    fun bind(task: Task) {
        itemView.titleTextView.text = task.title
        Glide.with(view.context)
            .load(if (task.isFavourite) R.drawable.ic_favorite_black_24dp else R.drawable.ic_favorite_border_black_24dp)
            .into(itemView.favouriteImageView)
        itemView.favouriteImageView.setOnClickListener { favouriteClick(task) }
    }
}