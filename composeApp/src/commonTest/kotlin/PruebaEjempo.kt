import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.runComposeUiTest
import org.juljimgar.project.App
import kotlin.test.Test

class PruebaEjempo {
    @OptIn(ExperimentalTestApi::class)
    @Test
    fun pruebaEejemplo() = runComposeUiTest {
        setContent {
            App()
        }
//se busca el campo de texto por tag y se comprueba que tenga el texto "Ejemplo", tiene que dar fallo.
        onNodeWithTag("metroscubicos").assertTextEquals("Ejemplo")

    }
}