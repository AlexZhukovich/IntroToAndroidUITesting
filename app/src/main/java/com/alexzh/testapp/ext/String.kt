package com.alexzh.testapp.ext

import android.util.Patterns

fun String.isValidEmail(): Boolean {
    val matcher = Patterns.EMAIL_ADDRESS.matcher(this)
    return matcher.matches()
}

fun String.isNotValidEmail(): Boolean {
    return !this.isValidEmail()
}