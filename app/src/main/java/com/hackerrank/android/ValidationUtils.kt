package com.hackerrank.android

object ValidationUtils {
    fun isUsernameValid(text: String): Boolean {
        //Replace the code in this method with the actual validation logic

        return text.isNotEmpty()
    }

    fun isPasswordValid(text: String): Boolean {
        //Replace the code in this method with the actual validation logic

        return text.length >= 4
    }
}