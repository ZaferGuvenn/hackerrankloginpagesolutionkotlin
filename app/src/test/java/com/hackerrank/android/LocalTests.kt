package com.hackerrank.android

import com.hackerrank.android.ValidationUtils.isPasswordValid
import com.hackerrank.android.ValidationUtils.isUsernameValid
import org.junit.Assert
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.lang.Exception

@RunWith(Enclosed::class)
class LocalTests {

    @RunWith(Parameterized::class)
    class ValidUsernameUnitTests(private val validUsername: String) {

        companion object {
            @JvmStatic
            @Parameterized.Parameters
            fun validUsernames(): Collection<String> {
                return listOf("a", "ab")
            }
        }

        @Test
        @Throws(Exception::class)
        fun `test valid Username`() {
            Assert.assertNotNull("FAILED TEST: Testing if username validation is correct for valid usernames",isUsernameValid(validUsername))
            isUsernameValid(validUsername)?.let { Assert.assertTrue("FAILED TEST: Testing if username validation is correct for valid usernames", it) }
        }
    }

    @RunWith(Parameterized::class)
    class InvalidUsernameUnitTests(private val invalidUsername: String) {

        companion object {
            @JvmStatic
            @Parameterized.Parameters
            fun invalidUsernames(): Collection<String> {
                return listOf("")
            }
        }

        @Test
        @Throws(Exception::class)
        fun `test invalid Username`() {
            Assert.assertNotNull("FAILED TEST: Testing if username validation is correct for invalid usernames", isUsernameValid(invalidUsername))
            isUsernameValid(invalidUsername)?.let { Assert.assertFalse("FAILED TEST: Testing if username validation is correct for invalid usernames", it) }
        }
    }


    @RunWith(Parameterized::class)
    class ValidPasswordUnitTests(private val validPwd: String) {

        companion object {
            @JvmStatic
            @Parameterized.Parameters
            fun validPwds(): Collection<String> {
                return listOf("abcd", "abcde")
            }
        }

        @Test
        @Throws(Exception::class)
        fun `test valid Password`() {
            Assert.assertNotNull("FAILED TEST: Testing if password validation is correct for valid passwords", isPasswordValid(validPwd))
            isPasswordValid(validPwd)?.let { Assert.assertTrue("FAILED TEST: Testing if password validation is correct for valid passwords", it) }
        }
    }

    @RunWith(Parameterized::class)
    class InvalidPasswordUnitTests(private val invalidPwd: String) {

        companion object {
            @JvmStatic
            @Parameterized.Parameters
            fun invalidPwds(): Collection<String> {
                return listOf("", "a", "ab", "abc")
            }
        }

        @Test
        @Throws(Exception::class)
        fun `test invalid Password`() {
            Assert.assertNotNull("FAILED TEST: Testing if password validation is correct for invalid passwords", isPasswordValid(invalidPwd))
            isPasswordValid(invalidPwd)?.let { Assert.assertFalse("FAILED TEST: Testing if password validation is correct for invalid passwords", it) }
        }
    }
}