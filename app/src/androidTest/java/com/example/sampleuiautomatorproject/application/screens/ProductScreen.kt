package com.example.sampleuiautomatorproject.application.screens

import androidx.test.uiautomator.*
import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.ext.*

class ProductScreen {

    private val favoritesIconSelector = byStringRes("ru.ozon.app.android:id/favoritesIv")
    private val productNameSelector = byStringRes("ru.ozon.app.android:id/nameTv")
    private val writeReviewButton = byStringRes("ru.ozon.app.android:id/writeReviewBtn")

    fun addToFavorites() {
        productNameSelector.waitFindObject()
        favoritesIconSelector.waitFindObject().click()
    }

    fun writeReviewButtonClick() {
        writeReviewButton.waitFindObject().click()
    }

    fun scrollToWriteReviewButton(){
        Thread.sleep(500)
        val scrollview = UiScrollable(UiSelector().scrollable(true))
        scrollview.scrollTextIntoView("Написать отзыв")
    }

}