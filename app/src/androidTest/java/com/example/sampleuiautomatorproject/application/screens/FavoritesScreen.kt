package com.example.sampleuiautomatorproject.application.screens

import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.ext.waitFindObject

class FavoritesScreen {

    private val toolBarHeader = byStringRes("ru.ozon.app.android:id/toolbarTb")
    private val productTitleSelector = byStringRes("ru.ozon.app.android:id/titleTv")

    fun checkProductInFavorites(productName: String): Boolean {
        return productTitleSelector.waitFindObject().text.toLowerCase() == productName.toLowerCase()
    }

    fun checkToolbarHeader(text: String): Boolean {
        val headerText = toolBarHeader.waitFindObject().children[0].text
        return headerText == text
    }

}