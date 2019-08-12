package com.alexzh.testapp.ui.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alexzh.testapp.R
import com.alexzh.testapp.data.DummyData
import com.alexzh.testapp.model.Task
import com.alexzh.testapp.ui.home.adapter.TaskAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    companion object {

        fun start(context: Context) {
            context.startActivity(Intent(context, HomeActivity::class.java))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        setSupportActionBar(toolbar)

        val adapter = TaskAdapter { displayMessage(it) }
        adapter.setTasks(DummyData.getTasks())

        val layoutManager = LinearLayoutManager(this)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, layoutManager.orientation))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.general_menu, menu)
        return true
    }

    private fun displayMessage(task: Task) {
        val text = if (task.isFavourite)
                getString(R.string.formatted_favourite_task, task.title)
            else
                getString(R.string.formatted_not_favourite_task, task.title)

        Snackbar.make(root, text, Snackbar.LENGTH_LONG).show()
    }
}
