package com.alexzh.testapp.ui.login

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.fail
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Test suite for checking the LoginActivity class from a UI perspective.
 *
 * Note: This class can be run without any pre-requirements.
 */
@RunWith(AndroidJUnit4::class)
class LoginActivityTest {

    @Rule
    @JvmField
    val activity = ActivityTestRule(LoginActivity::class.java)

    /**
     * Test case:
     *  - the "Email Input" view is enabled
     *  - the "Password Input" view is enabled
     *  - the "I agree" checkbox is enabled
     *  - the "LOG IN" button is enabled
     *
     * Notes:
     *  - the "Email Input" view has ID: emailEditText (R.id.emailEditText)
     *  - the "Password Input" view has ID: passwordEditText (R.id.passwordEditText)
     *  - the "I agree" checkbox has ID: agreeCheckBox (R.id.agreeCheckBox)
     *  - the "LOG IN" button has ID: loginButton (R.id.loginButton)
     */
    @Test
    fun shouldBeEnabledAllViews() {
        fail()
    }

    /**
     * Test case:
     *  - the "Email Input" has the "Email" hint
     *  - the "Password Input" has the "Password" hint
     *
     * Notes:
     *  - the "Email Input" view has ID: emailEditText (R.id.emailEditText)
     *  - the "Password Input" view has ID: passwordEditText (R.id.passwordEditText)
     *  - the "Email" string can be found in strings.xml file as hint_email const (R.string.hint_email)
     *  - the "Password" string can be found in strings.xml file as hint_password const (R.string.hint_password)
     */
    @Test
    fun shouldEmailAndPasswordFieldsDisplayHint() {
        fail()
    }

    /**
     * Test case:
     *  - the "Email Input" is blank
     *  - the "Password Input" is blank
     *  - the error message with "Email and password are blank" text should be displayed
     *  after click on "LOG IN" button
     *
     * Notes:
     *  - the "Email Input" view has ID: emailEditText (R.id.emailEditText)
     *  - the "Password Input" view has ID: passwordEditText (R.id.passwordEditText)
     *  - the "LOG IN" button has ID: loginButton (R.id.loginButton)
     *  - the "Email and password are blank" string can be found in strings.xml file as
     *  email_and_password_are_blank const (R.string.email_and_password_are_blank)
     *  - the Snackbar view has error message
     *  - the Snackbar text message view has ID: snackbar_text
     *  (com.google.android.material.R.id.snackbar_text)
     *
     * Hint(s):
     *  - error text can be found by text on screen or by text in view
     */
    @Test
    fun shouldDisplayErrorWhenEmailAndPasswordAreBlank() {
        fail()
    }

    /**
     * Test case:
     *  - the "Email Input" is blank
     *  - the "Password Input" is NOT blank
     *  - the error message with "Email is blank" text should be displayed
     *  after click on "LOG IN" button
     *
     * Notes:
     *  - the "Email Input" view has ID: emailEditText (R.id.emailEditText)
     *  - the "Password Input" view has ID: passwordEditText (R.id.passwordEditText)
     *  - the "LOG IN" button has ID: loginButton (R.id.loginButton)
     *  - the "Email is blank" string can be found in strings.xml file as
     *  email_is_blank const (R.string.email_is_blank)
     *  - the Snackbar view has error message
     *  - the Snackbar text message view has ID: snackbar_text
     *  (com.google.android.material.R.id.snackbar_text)
     *
     * Hint(s):
     *  - error text can be found by text on screen or by text in view
     */
    @Test
    fun shouldDisplayErrorWhenEmailIsBlank() {
        fail()
    }

    /**
     * Test case:
     *  - the "Email Input" is NOT blank
     *  - the "Password Input" is blank
     *  - the error message with "Password is blank" text should be displayed
     *  after click on "LOG IN" button
     *
     * Notes:
     *  - the "Email Input" view has ID: emailEditText (R.id.emailEditText)
     *  - the "Password Input" view has ID: passwordEditText (R.id.passwordEditText)
     *  - the "LOG IN" button has ID: loginButton (R.id.loginButton)
     *  - the "Password is blank" string can be found in strings.xml file as
     *  password_is_blank const (R.string.password_is_blank)
     *  - the Snackbar view has error message
     *  - the Snackbar text message view has ID: snackbar_text
     *  (com.google.android.material.R.id.snackbar_text)
     *
     * Hint(s):
     *  - error text can be found by text on screen or by text in view
     */
    @Test
    fun shouldDisplayErrorWhenPasswordIsBlank() {
        fail()
    }

    /**
     * Test case:
     *  - the "Email Input" doesn't match with email template "TEXT@TEXT.TEXT"
     *  - the "Password Input" is NOT blank
     *  - the error message with "Text is not email" text should be displayed
     *  after click on "LOG IN" button
     *
     * Notes:
     *  - the "Email Input" view has ID: emailEditText (R.id.emailEditText)
     *  - the "Password Input" view has ID: passwordEditText (R.id.passwordEditText)
     *  - the "LOG IN" button has ID: loginButton (R.id.loginButton)
     *  - the "Text is not email" string can be found in strings.xml file as
     *  text_is_not_email const (R.string.text_is_not_email)
     *  - the Snackbar view has error message
     *  - the Snackbar text message view has ID: snackbar_text
     *  (com.google.android.material.R.id.snackbar_text)
     *
     * Hint(s):
     *  - error text can be found by text on screen or by text in view
     */
    @Test
    fun shouldDisplayErrorWhenEmailTextIsNotEmail() {
        fail()
    }

    /**
     * Test case:
     *  - the "Email Input" has text which not matches with
     *  [com.alexzh.testapp.data.DummyData.LOGIN] const
     *  - the "Password Input" has text which not matches with
     *  [com.alexzh.testapp.data.DummyData.PASSWORD] const
     *  - the error message with "Check email and password" text should be displayed
     *  after click on "LOG IN" button
     *
     * Notes:
     *  - the "Email Input" view has ID: emailEditText (R.id.emailEditText)
     *  - the "Password Input" view has ID: passwordEditText (R.id.passwordEditText)
     *  - the "LOG IN" button has ID: loginButton (R.id.loginButton)
     *  - the "Check email and password" string can be found in strings.xml file as
     *  check_email_and_password const (R.string.check_email_and_password)
     *  - the Snackbar view has error message
     *  - the Snackbar text message view has ID: snackbar_text
     *  (com.google.android.material.R.id.snackbar_text)
     *
     * Hint(s):
     *  - error text can be found by text on screen or by text in view
     */
    @Test
    fun shouldDisplayErrorWhenEmailAndPasswordAreIncorrect() {
        fail()
    }

    /**
     * Test case:
     *  - the "Email Input" has text which not matches with
     *  [com.alexzh.testapp.data.DummyData.LOGIN] const
     *  - the "Password Input" has text which matches with
     *  [com.alexzh.testapp.data.DummyData.PASSWORD] const
     *  - the error message with "Check email and password" text should be displayed
     *  after click on "LOG IN" button
     *
     * Notes:
     *  - the "Email Input" view has ID: emailEditText (R.id.emailEditText)
     *  - the "Password Input" view has ID: passwordEditText (R.id.passwordEditText)
     *  - the "LOG IN" button has ID: loginButton (R.id.loginButton)
     *  - the "Check email and password" string can be found in strings.xml file as
     *  check_email_and_password const (R.string.check_email_and_password)
     *  - the Snackbar view has error message
     *  - the Snackbar text message view has ID: snackbar_text
     *  (com.google.android.material.R.id.snackbar_text)
     *
     * Hint(s):
     *  - error text can be found by text on screen or by text in view
     */
    @Test
    fun shouldDisplayErrorWhenEmailIsIncorrect() {
        fail()
    }

    /**
     * Test case:
     *  - the "Email Input" has text which  matches with
     *  [com.alexzh.testapp.data.DummyData.LOGIN] const
     *  - the "Password Input" has text which not matches with
     *  [com.alexzh.testapp.data.DummyData.PASSWORD] const
     *  - the error message with "Check email and password" text should be displayed
     *  after click on "LOG IN" button
     *
     * Notes:
     *  - the "Email Input" view has ID: emailEditText (R.id.emailEditText)
     *  - the "Password Input" view has ID: passwordEditText (R.id.passwordEditText)
     *  - the "LOG IN" button has ID: loginButton (R.id.loginButton)
     *  - the "Check email and password" string can be found in strings.xml file as
     *  check_email_and_password const (R.string.check_email_and_password)
     *  - the Snackbar view has error message
     *  - the Snackbar text message view has ID: snackbar_text
     *  (com.google.android.material.R.id.snackbar_text)
     *
     * Hint(s):
     *  - error text can be found by text on screen or by text in view
     */
    @Test
    fun shouldDisplayErrorWhenPasswordIsIncorrect() {
        fail()
    }

    /**
     * Test case:
     *  - the "Email Input" has text which matches with
     *  [com.alexzh.testapp.data.DummyData.LOGIN] const
     *  - the "Password Input" has text which matches with
     *  [com.alexzh.testapp.data.DummyData.PASSWORD] const
     *  - the "I agree" checkbox is checked
     *  - the error message with "Check email and password" text should be displayed
     *  after click on "LOG IN" button
     *
     * Notes:
     *  - the "Email Input" view has ID: emailEditText (R.id.emailEditText)
     *  - the "Password Input" view has ID: passwordEditText (R.id.passwordEditText)
     *  - the "LOG IN" button has ID: loginButton (R.id.loginButton)
     *  - the "I agree" checkbox has ID: i_agree (R.id.i_agree)
     *  - the "I agree" string can be found in strings.xml file as i_agree const (R.string.i_agree)
     *  - the "Check email and password" string can be found in strings.xml file as
     *  check_email_and_password const (R.string.check_email_and_password)
     *  - the Snackbar view has error message
     *  - the Snackbar text message view has ID: snackbar_text
     *  (com.google.android.material.R.id.snackbar_text)
     *
     * Hint(s):
     *  - error text can be found by text on screen or by text in view
     */
    @Test
    fun shouldOpenHomeScreenWhenEmailAndPasswordAreCorrectAndAgreeCheckboxIsChecked() {
        fail()
    }
}
