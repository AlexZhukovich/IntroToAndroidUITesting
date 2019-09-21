package com.alexzh.testapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexzh.testapp.R
import com.alexzh.testapp.model.Task

class TaskAdapter : RecyclerView.Adapter<TaskViewHolder>() {
    private var itemClick: ((Task) -> Unit)? = null
    private var favouriteIconClick: ((Task) -> Unit)? = null
    private val tasks = mutableListOf<Task>()

    fun setTasks(tasks: List<Task>) {
        this.tasks.clear()
        this.tasks.addAll(tasks)
        notifyDataSetChanged()
    }

    fun setOnItemClick(itemClick: (Task) -> Unit) {
        this.itemClick = itemClick
    }

    fun setOnFavouriteIconClick(favouriteIconClick: (Task) -> Unit) {
        this.favouriteIconClick = favouriteIconClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false),
            favouriteIconClick,
            itemClick
        )
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(tasks[position])
    }

    override fun getItemCount(): Int = tasks.size
}
