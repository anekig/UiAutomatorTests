package com.example.sampleuiautomatorproject.test

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.sampleuiautomatorproject.application.Ozon
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class OzonTest: AbstractApplicationTest<Ozon>(Ozon()) {

    @Test
    fun checkSuggestion() = with(app) {
        open()
        mainScreen.clickSearch()
        val productName = "философия java"
        searchScreen.typeToSearch(productName)
        assertTrue("Неазвание товара неверное", searchScreen.checkProductTitle(productName))
        assertTrue("Цена неверная", searchScreen.checkProductPrice("1 499 \u20BD"))
    }

    @Test
    fun addProductToFavorites() = with(app) {
        open()
        mainScreen.clickSearch()
        val productName = "философия java"

        searchScreen.typeToSearch(productName)
        searchScreen.clickTitle()
        productScreen.addToFavorites()
        mainScreen.goToFavorites()
        assertTrue("Не перешли в Избранное", favoritesScreen.checkToolbarHeader("Избранное"))
        assertTrue("Нет товара в Избранном", favoritesScreen.checkProductInFavorites(productName))
    }

    @Test
    fun checkEmailValidation() = with(app) {
        Thread.sleep(10_000) // без этого открывается другой экран логина (с крестиком справа и другими отличиями)
        open()
        Thread.sleep(10_000) // без этого открывается другой экран логина (с крестиком справа и другими отличиями)
        mainScreen.goToProfile()
        loginByPhoneScreen.waitForAppearance()
        loginByPhoneScreen.clickEnterByMail()
        loginByEmailScreen.typeToEnter("aaaaa")
        loginByEmailScreen.clickSubmitButton()
        assertTrue("Подсказка не появилась", loginByEmailScreen.checkTextInputErrorSelector())
        loginByEmailScreen.typeToEnter("aaaaa@aa.ru")
        loginByEmailScreen.clickSubmitButton()
        assertFalse("Подсказка не исчезла", loginByEmailScreen.checkTextInputErrorSelector())
    }

    @Test
    fun checkLoginBeforeReview() = with(app) {
        open()
        mainScreen.clickSearch()
        searchScreen.typeToSearch("философия java")
        searchScreen.clickTitle()
        productScreen.scrollToWriteReviewButton()
        productScreen.writeReviewButtonClick()
        assertTrue("Не выполнен переход на экран логина", loginByPhoneScreen.waitForAppearance())
    }
}
