import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.runComposeUiTest
import org.juljimgar.project.App
import kotlin.test.Test
import kotlin.test.assertEquals

class PruebaEjempo {
    @OptIn(ExperimentalTestApi::class)
    @Test
    fun pruebaTextFields() = runComposeUiTest {
        setContent {
            App()
        }
//se busca el campo de texto por tag y se comprueba que tenga el texto "Ejemplo", tiene que dar fallo.
        onNodeWithTag("metroscubicos").assertExists()
        onNodeWithTag("gramos").assertExists()
        onNodeWithTag("ph").assertExists()

    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun pruebaPositivos() = runComposeUiTest {
        setContent {
            App()
        }

        onNodeWithTag("metroscubicos").performTextInput("1")
        onNodeWithTag("ph").performTextInput("7.2")
        onNodeWithTag("gramos").performTextInput("5")

        val valorEsperado = ((7.4 - 7.2) * 10 * 1 * 5).toString()

        onNodeWithTag("resultado").assertTextEquals(valorEsperado)
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun pruebaNegativo() = runComposeUiTest {
        setContent {
            App()
        }

        onNodeWithTag("metroscubicos").performTextInput("1")
        onNodeWithTag("ph").performTextInput("7.5")
        onNodeWithTag("gramos").performTextInput("5")


        onNodeWithTag("resultado").assertTextContains("-", substring = true)

    }

}