package com.example.pdm_cesarchavarria

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pdm_cesarchavarria.ui.theme.PDMCesarChavarriaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val pc = Computadora(8, 256, "Windows 10")

        pc.encender()

        pc.agregarPrograma("Notion 2026")
        pc.agregarPrograma("Facebook 2024")
        pc.agregarPrograma("VSCode 2026")

        val resultado = pc.programasDeEsteAnio()

        Log.d("INFO", "Programas de este año:")
        Log.d("INFO", resultado.toString())

        pc.apagar()

        setContent {
            PDMCesarChavarriaTheme {
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
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PDMCesarChavarriaTheme {
        Greeting("Android")
    }
}