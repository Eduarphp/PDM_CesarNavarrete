package com.example.CENCCUATRO

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.CENCCUATRO.ui.theme.Labo2PDMTheme
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.border
import androidx.compose.ui.graphics.Color

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Labo2PDMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {

    var texto by remember { mutableStateOf("") }
    var lista by remember { mutableStateOf(listOf<String>()) }

    Column(modifier = modifier.padding(16.dp)) {

        OutlinedTextField(
            value = texto,
            onValueChange = { texto = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = {
                if (texto.isNotEmpty()) {
                    lista = lista + texto
                    texto = ""
                }
            }) {
                Text("Guardar")
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text("Listado de nombres y \nposición en la lista")

            Button(onClick = {
                lista = emptyList()
            }) {
                Text("Limpiar")
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .border(2.dp, androidx.compose.ui.graphics.Color.Blue)
                .padding(10.dp)
        ) {
            Column {
                lista.forEachIndexed { index, nombre ->
                    Text("$nombre     ${index + 1}")
                }
            }
        }
    }
}
