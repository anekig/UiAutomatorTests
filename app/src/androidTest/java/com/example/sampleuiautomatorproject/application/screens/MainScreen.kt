package com.example.sampleuiautomatorproject.application.screens

import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.ext.waitFindObject
import com.example.sampleuiautomatorproject.util.ext.waitIsClickable

class MainScreen {

    private val searchSelector = byStringRes("ru.ozon.app.android:id/searchTv")
    private val favoritesTabSelector = byStringRes("ru.ozon.app.android:id/menu_favorites")
    private val profileTabSelector = byStringRes("ru.ozon.app.android:id/menu_profile")

    fun clickSearch() {
        searchSelector.waitFindObject().click()
    }

    fun goToFavorites() {
        favoritesTabSelector.waitFindObject().click()
    }

    fun goToProfile() {
        profileTabSelector.waitFindObject().click()
    }

}