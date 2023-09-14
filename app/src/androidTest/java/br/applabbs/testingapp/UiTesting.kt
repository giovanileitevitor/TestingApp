package br.applabbs.testingapp

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import br.applabbs.testingapp.ui.theme.TestingAppTheme
import br.applabbs.testingapp.ui.theme.examples.reusecomps.CustomButton
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UiComposeTest {

    @get: Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setup(){
        composeTestRule.setContent {
            TestingAppTheme {
                CustomButton(text = "Compartilhar", modifier = Modifier.fillMaxWidth().testTag("BtnCompartilhar")) {
                }
            }
        }
    }

    @Test
    fun verifyAllViewsExists(){
        composeTestRule.onNodeWithTag("BtnCompartilhar").assertExists()
    }

    @Test
    fun verifyIfAllViewsIsDisplayed(){
        composeTestRule.onNodeWithTag("BtnCompartilhar").assertExists().assertIsDisplayed()
    }

    @Test
    fun verifyIfHasClickAction(){
        composeTestRule.onNodeWithTag("BtnCompartilhar").performClick()
    }


}