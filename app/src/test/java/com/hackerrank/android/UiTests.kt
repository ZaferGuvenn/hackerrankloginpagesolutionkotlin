package com.hackerrank.android

import android.content.pm.ApplicationInfo
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.text.InputType
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.hackerrank.android.TestConstants.TEST_TITLE
import junit.framework.Assert.assertNull
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowToast

@RunWith(RobolectricTestRunner::class)
class UiTests {

    private lateinit var activity: MainActivity
    private lateinit var rootLayout: ConstraintLayout
    private lateinit var imageCard: CardView
    private lateinit var loginContainer: View
    private lateinit var loginButton: Button
    private lateinit var titleView: TextView
    private lateinit var usernameView: EditText
    private lateinit var pwdView: EditText
    private lateinit var constraintSet: ConstraintSet

    @Before
    @Throws(Exception::class)
    fun setUp() {
        activity = Robolectric.buildActivity(MainActivity::class.java)
            .create()
            .resume()
            .get()
        rootLayout = activity.findViewById(R.id.root)
        imageCard = activity.findViewById(R.id.image_card)
        loginContainer = activity.findViewById(R.id.login_container)
        loginButton = activity.findViewById(R.id.login_btn)
        titleView = activity.findViewById(R.id.title)
        usernameView = activity.findViewById(R.id.username)
        pwdView = activity.findViewById(R.id.password)

        constraintSet = ConstraintSet()
        constraintSet.clone(rootLayout)
    }

    @Test
    @Throws(Exception::class)
    fun `validate root layout`() {
        try {
            val bgColor = (rootLayout.background as ColorDrawable).color
            assertEquals("$TEST_TITLE Testing if background color of root layout is secondary color defined in theme. Result: ",Color.parseColor(activity.resources.getString(R.color.secondary)), bgColor)
        } catch (e: Exception) {
            Assert.fail("Exception while accessing the background color of root_layout : $e")
        }
    }

    @Test
    @Throws(Exception::class)
    fun `validate logo radius`() {
        try {
            val imageCardRadius = imageCard.radius
            assertEquals("$TEST_TITLE Testing if radius of the cardview that wraps the logo is correct. Result: ", 100.0f, imageCardRadius)
        } catch (e: Exception) {
            Assert.fail("Exception while accessing radius of the cardview : $e")
        }
    }

    @Test
    fun validateLogoTopConstraint() {
        val topConstraint = constraintSet.getConstraint(R.id.image_card).layout.topToTop
        assertEquals("$TEST_TITLE Testing top constraint of cardview. Result: ", ConstraintSet.PARENT_ID, topConstraint)
    }

    @Test
    @Throws(Exception::class)
    fun `validate logo width`() {
        val width = imageCard.layoutParams.width
        assertEquals("$TEST_TITLE Testing width of cardview is equal to 100. Result: ", 100, width)
    }

    @Test
    @Throws(Exception::class)
    fun `validate logo height`() {
        val height = imageCard.layoutParams.height
        assertEquals("$TEST_TITLE Testing height of cardview is equal to 100. Result: ", 100, height)
    }

    @Test
    @Throws(Exception::class)
    fun `validate login container background color`() {
        try {
            val bgColor = (loginContainer.background as GradientDrawable).color?.defaultColor
            assertEquals("$TEST_TITLE Testing background color of login_container is equal to R.color.white. Result: ", Color.parseColor(activity.resources.getString(R.color.white)), bgColor)
        }
        catch (e: Exception) {
            Assert.fail("Exception while accessing background color of login container : $e")
        }
    }

    @Test
    @Throws(Exception::class)
    fun `validate login container top left radius`() {
        try {
            val topLeftRadius = (loginContainer.background as GradientDrawable).cornerRadii?.get(0)
            assertEquals("$TEST_TITLE Testing top left radius of login_container is equal to 30. Result: ", 30.0f, topLeftRadius)
        } catch (e: Exception) {
            Assert.fail("Exception while accessing background of login_container : $e")
        }
    }

    @Test
    @Throws(Exception::class)
    fun `validate login container top right radius`() {
        try {
            val topRightRadius = (loginContainer.background as GradientDrawable).cornerRadii?.get(1)
            assertEquals("$TEST_TITLE Testing top right radius of login_container  is equal to 30. Result: ", 30.0f, topRightRadius)
        } catch (e: Exception) {
            Assert.fail("Exception while accessing background of login_container : $e")
        }
    }

    @Test
    fun validateLoginContainerTopConstraint() {
        val topConstraint = constraintSet.getConstraint(R.id.login_container).layout.topToBottom
        assertEquals("$TEST_TITLE Testing top constraint of login_container. Result: ", R.id.image_card, topConstraint)
    }

    @Test
    fun validateLoginContainerBottomConstraint() {
        val bottomConstraint = constraintSet.getConstraint(R.id.login_container).layout.bottomToBottom
        assertEquals("$TEST_TITLE Testing bottom constraint of login_container. Result: ", ConstraintSet.PARENT_ID, bottomConstraint)
    }

    @Test
    @Throws(Exception::class)
    fun `validate title text`() {
        val titleText = titleView.text
        assertEquals("$TEST_TITLE Testing text of the title. Result: ", "Login", titleText)

    }

    @Test
    @Throws(Exception::class)
    fun `validate title text size`() {
        val titleSize = titleView.textSize
        assertEquals("$TEST_TITLE Testing size of the text of the title is equal to 24. Result: ", 24.0f, titleSize)
    }

    @Test
    @Throws(Exception::class)
    fun `validate title font`() {
        val titleStyle = titleView.typeface.style
        assertEquals("$TEST_TITLE Testing fontstyle of the text of the title is BOLD. Result: ", Typeface.BOLD, titleStyle)
    }

    @Test
    @Throws(Exception::class)
    fun `validate title text color`() {
        val titleColor = titleView.currentTextColor
        assertEquals("$TEST_TITLE Testing color of the text of the title is equal to the primary color defined in theme. Result: ", Color.parseColor(activity.resources.getString(R.color.primary)), titleColor)
    }

    @Test
    fun validateTitleVerticalChainStyle() {
        val chainStyle = constraintSet.getConstraint(R.id.title).layout.verticalChainStyle
        assertEquals("$TEST_TITLE Testing vertical chain style of title. Result: ", ConstraintSet.CHAIN_PACKED, chainStyle)
    }

    @Test
    fun validateTitleTopConstraint() {
        val topConstraint = constraintSet.getConstraint(R.id.title).layout.topToTop
        assertEquals("$TEST_TITLE Testing top constraint of title. Result: ", R.id.login_container, topConstraint)
    }

    @Test
    fun validateTitleBottomConstraint() {
        val bottomConstraint = constraintSet.getConstraint(R.id.title).layout.bottomToTop
        assertEquals("$TEST_TITLE Testing bottom constraint of title. Result: ", R.id.username, bottomConstraint)
    }

    @Test
    @Throws(Exception::class)
    fun `validate username hint`() {
        val usernameHint = usernameView.hint
        assertEquals("$TEST_TITLE Testing hint of the username EditText. Result: ","Username", usernameHint)
    }

    @Test
    @Throws(Exception::class)
    fun `validate username ems`() {
        val usernameEms = usernameView.minEms
        assertEquals("$TEST_TITLE Testing ems of the username EditText. Result: ",15, usernameEms)
    }

    @Test
    fun validateUsernameTopConstraint() {
        val topConstraint = constraintSet.getConstraint(R.id.username).layout.topToBottom
        assertEquals("$TEST_TITLE Testing top constraint of username. Result: ", R.id.title, topConstraint)
    }

    @Test
    fun validateUsernameBottomConstraint() {
        val bottomConstraint = constraintSet.getConstraint(R.id.username).layout.bottomToTop
        assertEquals("$TEST_TITLE Testing bottom constraint of username. Result: ", R.id.password, bottomConstraint)
    }

    @Test
    @Throws(Exception::class)
    fun `validate password hint`() {
        val pwdHint = pwdView.hint
        assertEquals("$TEST_TITLE Testing hint of the password EditText. Result: ","Password", pwdHint)
    }

    @Test
    @Throws(Exception::class)
    fun `validate password ems`() {
        val pwdEms = pwdView.minEms
        assertEquals("$TEST_TITLE Testing ems of the password EditText. Result: ",15, pwdEms)
    }

    @Test
    fun validatePasswordMargin() {
        val topMargin = (pwdView.layoutParams as ConstraintLayout.LayoutParams).topMargin
        assertEquals("$TEST_TITLE Testing top margin of the password. Result: ", 10, topMargin.toLong())
    }

    @Test
    fun validatePasswordTopConstraint() {
        val topConstraint = constraintSet.getConstraint(R.id.password).layout.topToBottom
        assertEquals("$TEST_TITLE Testing top constraint of password. Result: ", R.id.username, topConstraint)
    }

    @Test
    fun validatePasswordBottomConstraint() {
        val bottomConstraint = constraintSet.getConstraint(R.id.password).layout.bottomToTop
        assertEquals("$TEST_TITLE Testing bottom constraint of password. Result: ", R.id.login_btn, bottomConstraint)
    }

    @Test
    @Throws(Exception::class)
    fun `validate password input type`() {
        val inputType = pwdView.inputType
        assertEquals("$TEST_TITLE Testing input type of the password EditText. Result: ",InputType.TYPE_TEXT_VARIATION_PASSWORD, inputType - 1)
    }

    @Test
    @Throws(Exception::class)
    fun `validate button text`() {
        val btnText = loginButton.text
        assertEquals("$TEST_TITLE Testing text of the login_btn Button. Result: ","LOG IN", btnText)
    }

    @Test
    @Throws(Exception::class)
    fun `validate button color`() {
        try {
            val btnColor = (loginButton.background as ColorDrawable).color
            assertEquals("$TEST_TITLE Testing if color of the login_btn Button is equal to primary color defined in the theme. Result: ",Color.parseColor(activity.resources.getString(R.color.primary)), btnColor)
        } catch (e: Exception) {
            Assert.fail("Exception while accessing background color of login_btn : $e")
        }
    }

    @Test
    fun validateButtonTopConstraint() {
        val topConstraint = constraintSet.getConstraint(R.id.login_btn).layout.topToBottom
        assertEquals("$TEST_TITLE Testing top constraint of login_btn. Result: ", R.id.password, topConstraint)
    }

    @Test
    fun validateButtonBottomConstraint() {
        val bottomConstraint = constraintSet.getConstraint(R.id.login_btn).layout.bottomToBottom
        assertEquals("$TEST_TITLE Testing bottom constraint of login_btn. Result: ", ConstraintSet.PARENT_ID, bottomConstraint)
    }

    @Test
    @Throws(Exception::class)
    fun `test Login with invalid username`() {
        val btnView = activity.findViewById<Button>(R.id.login_btn)
        val usernameView = activity.findViewById<EditText>(R.id.username)
        val pwdView = activity.findViewById<EditText>(R.id.password)
        pwdView.setText("abcd")
        btnView.performClick()
        assertNull("$TEST_TITLE Testing that no error should be shown on password EditText when only username is invalid. ",pwdView.error)
        assertEquals("$TEST_TITLE Testing error of the username EditText when it's text invalid. Result: ","Username is required", usernameView.error)
    }

    @Test
    @Throws(Exception::class)
    fun `test Login with invalid password`() {
        val btnView = activity.findViewById<Button>(R.id.login_btn)
        val usernameView = activity.findViewById<EditText>(R.id.username)
        val pwdView = activity.findViewById<EditText>(R.id.password)
        usernameView.setText("abc")
        btnView.performClick()
        assertNull("$TEST_TITLE Testing that no error should be shown on username EditText when only password is invalid. ", usernameView.error)
        assertEquals("$TEST_TITLE Testing error of the password EditText when it's text is invalid. Result: ","Password must have minimum 4 characters", pwdView.error)
    }

    @Test
    @Throws(Exception::class)
    fun `test Login with invalid input`() {
        val btnView = activity.findViewById<Button>(R.id.login_btn)
        val usernameView = activity.findViewById<EditText>(R.id.username)
        val pwdView = activity.findViewById<EditText>(R.id.password)
        btnView.performClick()
        assertEquals("$TEST_TITLE Testing error of the username EditText when it's text is invalid. Result: ", "Username is required", usernameView.error)
        assertEquals("$TEST_TITLE Testing error of the password EditText when it's text is invalid. Result: ","Password must have minimum 4 characters", pwdView.error)
    }

    @Test
    @Throws(Exception::class)
    fun `test Login with valid input`() {
        val btnView = activity.findViewById<Button>(R.id.login_btn)
        val usernameView = activity.findViewById<EditText>(R.id.username)
        val pwdView = activity.findViewById<EditText>(R.id.password)
        usernameView.setText("abc")
        pwdView.setText("defg")
        btnView.performClick()
        assertEquals("$TEST_TITLE Testing if Toast is shown with correct message. Result: ","Success", ShadowToast.getTextOfLatestToast())
    }

}