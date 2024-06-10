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

        binding.loginBtn.setOnClickListener {

            val usr=binding.username.text.toString()
            val pass=binding.password.text.toString()

            if (!isUsernameValid(usr)){
                binding.username.error =
                    getString(R.string.main_activity_username_edittext_isemty_error_message)
                binding.password.requestFocus()
                return@setOnClickListener
            }

            if (!isPasswordValid(pass)){
                binding.password.error =
                    getString(R.string.main_activity_password_edittext_lessthan4digit_error_message)
                binding.password.requestFocus()
                return@setOnClickListener
            }


            Toast.makeText(this,
                getString(R.string.main_activity_success_toastmessage),Toast.LENGTH_SHORT).show()
        }
    }

}