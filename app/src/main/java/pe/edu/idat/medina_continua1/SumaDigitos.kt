package pe.edu.idat.medina_continua1


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun SumaDigitos(onBack: () -> Unit) {
    var sumaResultado by remember { mutableStateOf("") }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        val (button, result, backButton) = createRefs()

        Button(
            onClick = {
                val suma = (23..99).sumOf { it.toString().map { char -> char.digitToInt() }.sum() }
                sumaResultado = suma.toString()
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EA)),
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 60.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Text("Calcular Suma de Dígitos")
        }

        Text("Resultado: $sumaResultado", modifier = Modifier.constrainAs(result) {
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
