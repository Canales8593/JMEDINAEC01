package pe.edu.idat.medina_continua1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun ControlAlcoholemia(onBack: () -> Unit) {
    var tipoVehiculo by remember { mutableStateOf(TextFieldValue("")) }
    var tasaAlcohol by remember { mutableStateOf(TextFieldValue("")) }
    var resultado by remember { mutableStateOf("") }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        val (inputVehiculo, inputTasa, button, result, backButton) = createRefs()

        BasicTextField(
            value = tipoVehiculo,
            onValueChange = { tipoVehiculo = it },
            modifier = Modifier
                .padding(top = 60.dp)
                .background(Color.White, RoundedCornerShape(8.dp))
                .constrainAs(inputVehiculo) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .background(Color.White, RoundedCornerShape(8.dp))
                        .padding(16.dp)
                ) {
                    if (tipoVehiculo.text.isEmpty()) {
                        Text("Indicador de Vehículo")
                    }
                    innerTextField()
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp).constrainAs(createRef()) {
            top.linkTo(inputVehiculo.bottom)
        })

        BasicTextField(
            value = tasaAlcohol,
            onValueChange = { tasaAlcohol = it },
            modifier = Modifier
                .background(Color.White, RoundedCornerShape(8.dp))
                .constrainAs(inputTasa) {
                    top.linkTo(inputVehiculo.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .background(Color.White, RoundedCornerShape(8.dp))
                        .padding(16.dp)
                ) {
                    if (tasaAlcohol.text.isEmpty()) {
                        Text("Tasa de Alcohol")
                    }
                    innerTextField()
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp).constrainAs(createRef()) {
            top.linkTo(inputTasa.bottom)
        })

        Button(
            onClick = {
                val tasaMaxima = when (tipoVehiculo.text.uppercase()) {
                    "C" -> 0.3
                    "A" -> 0.3
                    "T" -> 0.5
                    "M" -> 0.3
                    else -> -1.0
                }

                resultado = if (tasaMaxima == -1.0) {
                    "Indicador de vehículo no válido"
                } else {
                    val tasa = tasaAlcohol.text.toDoubleOrNull()
                    if (tasa == null) {
                        "Tasa de alcohol no válida"
                    } else {
                        if (tasa <= tasaMaxima) "Negativo" else "Positivo"
                    }
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EA)),
            modifier = Modifier.constrainAs(button) {
                top.linkTo(inputTasa.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Text("Verificar")
        }

        Text("Resultado: $resultado", modifier = Modifier.constrainAs(result) {
            top.linkTo(button.bottom, margin = 16.dp)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })

        Button(
            onClick = onBack,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EA)),
            modifier = Modifier.constrainAs(backButton) {
                top.linkTo(result.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Text("Volver")
        }
    }
}
