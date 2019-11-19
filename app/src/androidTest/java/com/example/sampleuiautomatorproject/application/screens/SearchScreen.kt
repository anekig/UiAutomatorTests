package com.example.sampleuiautomatorproject.application.screens

import com.example.sampleuiautomatorproject.util.byStringRes
import com.example.sampleuiautomatorproject.util.ext.waitFindObject
import com.example.sampleuiautomatorproject.util.ext.waitHasObject

class SearchScreen {

    private val searchInputSelector = byStringRes("ru.ozon.app.android:id/search_src_text")
    private val productTitleSelector = byStringRes("ru.ozon.app.android:id/titleTv")
    private val productPriceSelector = byStringRes("ru.ozon.app.android:id/priceTv")
    private val productImageSelector = byStringRes("ru.ozon.app.android:id/productIv")

    fun typeToSearch(text: String) {
        searchInputSelector.waitFindObject().text = text
    }

    fun clickTitle() {
        productImageSelector.waitFindObject().click()
    }

    fun checkProductTitle(productTitle: String): Boolean {
        Thread.sleep(1000)
        return productTitleSelector.waitFindObject().text.toLowerCase() == productTitle.toLowerCase()
    }

    fun checkProductPrice(price: String): Boolean {
        return productPriceSelector.waitFindObject().text == price
    }

}