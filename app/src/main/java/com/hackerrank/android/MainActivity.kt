package com.hackerrank.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hackerrank.android.databinding.ActivityMainBinding
import android.widget.Toast
import com.hackerrank.android.ValidationUtils.isPasswordValid
import com.hackerrank.android.ValidationUtils.isUsernameValid

/**
 * The solution code must be started in [executeSolution] method.
 * Validation logic must be written in [ValidationUtils] object.
 * More methods can be added if necessary.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the view hierarchy and bind the object to it
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Set the view hierarchy as the current layout for the activity
        setContentView(binding.root)

        executeSolution()
    }

    private fun executeSolution() {
        //Write your logic here
    }

}