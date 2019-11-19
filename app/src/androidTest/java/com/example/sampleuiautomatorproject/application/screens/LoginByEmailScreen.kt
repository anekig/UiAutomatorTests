package com.example.sampleuiautomatorproject.application.screens

import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.ext.*

class LoginByEmailScreen {

    private val enterEmailInputSelector = byStringRes("ru.ozon.app.android:id/emailEt")
    private val textInputErrorSelector = byStringRes("ru.ozon.app.android:id/textinput_error")
    private val submitButtonSelector = byStringRes("ru.ozon.app.android:id/submitBtn")

    fun typeToEnter(text: String) {
        enterEmailInputSelector.waitFindObject().text = text
    }

    fun clickSubmitButton() {
        submitButtonSelector.waitFindObject().click()
    }

    fun checkTextInputErrorSelector(): Boolean {
        return textInputErrorSelector.waitFindObject().text == "Некорректный формат почты"
    }

}