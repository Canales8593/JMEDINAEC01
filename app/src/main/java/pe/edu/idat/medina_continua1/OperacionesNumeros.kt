package pe.edu.idat.medina_continua1

import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
fun OperacionesNumeros(onBack: () -> Unit) {
    var numero1 by remember { mutableStateOf("") }
    var numero2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
    ) {
        val (inputNumero1, inputNumero2, button, result, backButton) = createRefs()

        BasicTextField(
            value = numero1,
            onValueChange = { numero1 = it },
            modifier = Modifier
                .padding(top = 60.dp)
                .background(Color.White, RectangleShape)
                .constrainAs(inputNumero1) {
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
                    if (numero1.isEmpty()) {
                        Text("Número 1")
                    }
                    innerTextField()
                }
            }
        )

        BasicTextField(
            value = numero2,
            onValueChange = { numero2 = it },
            modifier = Modifier
                .padding(top = 16.dp)
                .background(Color.White, RectangleShape)
                .constrainAs(inputNumero2) {
                    top.linkTo(inputNumero1.bottom, margin = 16.dp)
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
                    if (numero2.isEmpty()) {
                        Text("Número 2")
                    }
                    innerTextField()
                }
            }
        )

        Button(
            onClick = {
                val num1 = numero1.toIntOrNull() ?: 0
                val num2 = numero2.toIntOrNull() ?: 0
                resultado = when {
                    num1 == num2 -> (num1 * num2).toString()
                    num1 > num2 -> (num1 - num2).toString()
                    else -> (num1 + num2).toString()
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EA)),
            modifier = Modifier.constrainAs(button) {
                top.linkTo(inputNumero2.bottom, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Text("Calcular")
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
