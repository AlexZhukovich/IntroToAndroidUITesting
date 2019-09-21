package com.alexzh.testapp.data

import com.alexzh.testapp.model.Task

object DummyData {

    const val LOGIN = "test-account@test.test"
    const val PASSWORD = "test"

    fun getTasks(): List<Task> {
        return listOf(
            Task("Test item 1", true),
            Task("Test item 2", true),
            Task("Test item 3", true),
            Task("Test item 4", true),
            Task("Test item 5", true),
            Task("Test item 6", false),
            Task("Test item 7", false),
            Task("Test item 8", false),
            Task("Test item 9", false),
            Task("Test item 10", false),
            Task("Test item 11", false),
            Task("Test item 12", false),
            Task("Test item 13", false),
            Task("Test item 14", false),
            Task("Test item 15", false)
        )
    }
}
