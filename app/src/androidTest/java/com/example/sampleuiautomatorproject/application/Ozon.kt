package com.example.sampleuiautomatorproject.application

import com.example.sampleuiautomatorproject.application.screens.*

class Ozon : AbstractApplication("ru.ozon.app.android") {

    val mainScreen = MainScreen()
    val searchScreen = SearchScreen()
    val favoritesScreen = FavoritesScreen()
    val productScreen = ProductScreen()
    var loginByPhoneScreen = LoginByPhoneScreen()
    var loginByEmailScreen = LoginByEmailScreen()

}
