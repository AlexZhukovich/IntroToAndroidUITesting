package com.alexzh.testapp.data

import com.alexzh.testapp.model.Task

object DummyData {
    private const val TASK_COUNT = 45
    const val EMAIL = "t@t.t"
    const val PASSWORD = "t"

    fun getTasks(): List<Task> {
        return mutableListOf<Task>().apply {
            repeat(TASK_COUNT) {
                this.add(
                    Task(
                        title = "Test item ${it + 1}",
                        isFavourite = it % 2 == 0
                    )
                )
            }
        }
    }
}
