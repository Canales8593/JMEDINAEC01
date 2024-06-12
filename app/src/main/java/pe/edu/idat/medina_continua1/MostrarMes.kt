package pe.edu.idat.medina_continua1


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun MostrarMes(onBack: () -> Unit) {
    var numeroMes by remember { mutableStateOf("") }
    var nombreMes by remember { mutableStateOf("") }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        val (inputMes, button, result, backButton) = createRefs()

        BasicTextField(
            value = numeroMes,
            onValueChange = { numeroMes = it },
            modifier = Modifier
                .padding(top = 60.dp)
                .background(Color.White, RectangleShape)
                .constrainAs(inputMes) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                },
            decorationBox = { innerTextField ->
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .background(Color.White, shape = RoundedCornerShape(8.dp))
                        .padding(16.dp)
                ) {
                    if (numeroMes.isEmpty()) {
                        Text("Número del Mes")
                    }
                    innerTextField()
                }
            }
        )

        Button(
            onClick = {
                nombreMes = when (numeroMes.toIntOrNull()) {
                    1 -> "Enero"
                    2 -> "Febrero"
                    3 -> "Marzo"
                    4 -> "Abril"
                    5 -> "Mayo"
                    6 -> "Junio"
                    7 -> "Julio"
                    8 -> "Agosto"
                    9 -> "Septiembre"
                    10 -> "Octubre"
                    11 -> "Noviembre"
                    12 -> "Diciembre"
                    else -> "Número de mes no válido"
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EA)),
            modifier = Modifier.constrainAs(button) {
                top.linkTo(inputMes.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Text("Mostrar Mes")
        }

        Text("Mes: $nombreMes", modifier = Modifier.constrainAs(result) {
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
