package com.example.sampleuiautomatorproject.application.screens

import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.byText
import com.example.sampleuiautomatorproject.util.ext.*

class LoginByPhoneScreen {

    private val titleHeaderSelector = byStringRes("ru.ozon.app.android:id/titleTv")
    private val enterByMailButtonSelector = byText("Войти по почте")

    fun clickEnterByMail() {
        enterByMailButtonSelector.waitFindObject().click()
    }

    fun waitForAppearance(): Boolean {
        return titleHeaderSelector.waitFindObject().text == "Вход или регистрация"
    }

}