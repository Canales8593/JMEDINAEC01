package pe.edu.idat.medina_continua1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.runtime.Composable

import pe.edu.idat.medina_continua1.ui.theme.Medina_Continua1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Medina_Continua1Theme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var screen by remember { mutableStateOf("main") }

    when (screen) {
        "main" -> MainMenu { screen = it }
        "alcohol" -> ControlAlcoholemia { screen = "main" }
        "numeros" -> OperacionesNumeros { screen = "main" }
        "mes" -> MostrarMes { screen = "main" }
        "suma" -> SumaDigitos { screen = "main" }
    }
}

@Composable
fun MainMenu(navigateTo: (String) -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { navigateTo("alcohol") }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EA))) {
            Text("Control de Alcoholemia")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navigateTo("numeros") }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EA))) {
            Text("Operaciones con Números")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navigateTo("mes") }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EA))) {
            Text("Mostrar Mes")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navigateTo("suma") }, colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EA))) {
            Text("Suma de Dígitos")
        }
    }
}