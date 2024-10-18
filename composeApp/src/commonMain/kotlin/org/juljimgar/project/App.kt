package org.juljimgar.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import poolkmpjjg.composeapp.generated.resources.Res
import poolkmpjjg.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App(modifier: Modifier = Modifier) {


        var metrosCubicos by remember { mutableStateOf("") }
        var ph by remember { mutableStateOf("") }
        var gramos by remember { mutableStateOf("") }
        var resultado by remember { mutableStateOf("") }

        val idealPh = 7.4

        Column(modifier = Modifier.fillMaxSize().padding(64.dp)) {
            Row(Modifier.fillMaxWidth(1.0f)) {
                TextField(
                    modifier = Modifier.fillMaxWidth().testTag("metroscubicos"),
                    value = metrosCubicos,
                    label = { Text("Metros cúbicos") },
                    onValueChange = {
                        metrosCubicos = it
                        resultado = calcularResultado(metrosCubicos, ph, gramos)
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }

            Row(Modifier.fillMaxWidth(1.0f)) {
                TextField(
                    modifier = Modifier.fillMaxWidth().testTag("ph"),
                    value = ph,
                    label = { Text("pH") },
                    onValueChange = {
                        ph = it
                        resultado = calcularResultado(metrosCubicos, ph, gramos)
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }

            Row(Modifier.fillMaxWidth(1.0f)) {
                TextField(
                    modifier = Modifier.fillMaxWidth().testTag("gramos"),
                    value = gramos,
                    label = { Text("Gramos por metro cúbico") },
                    onValueChange = {
                        gramos = it
                        resultado = calcularResultado(metrosCubicos, ph, gramos)
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            Row(Modifier.fillMaxWidth(1.0f)) {
                Text(
                    if( metrosCubicos.isNotEmpty() && ph.isNotEmpty() && gramos.isNotEmpty()){
                        calcularResultado(metrosCubicos.toString(), ph.toString(),gramos.toString())
                    }else{
                        "VACIo"
                    },
                    modifier = Modifier.background(Color.Red).padding(50.dp).testTag("resultado")
                )
            }
        }
    }


    fun calcularResultado(metrosCubicos: String, ph: String, gramos: String): String {

        return try {
            val mCubicos = metrosCubicos.toDouble()
            val phValue = ph.toDouble()
            val gramosValue = gramos.toDouble()

            val operacion = (7.4 - phValue) * 10 * mCubicos * gramosValue
            operacion.toString()
        } catch (e: NumberFormatException) {
            "Error en los datos de entrada"
        }
    }


