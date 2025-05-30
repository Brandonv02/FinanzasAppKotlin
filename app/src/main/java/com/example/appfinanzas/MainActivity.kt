package com.example.appfinanzas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appfinanzas.screens.FinanceHomeScreen
import com.example.appfinanzas.screens.LoginScreen
import com.example.appfinanzas.ui.theme.AppFinanzasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                var isLoggedIn by remember { mutableStateOf(false) }
                var userName by remember { mutableStateOf("") }
                var userSalary by remember { mutableStateOf(0.0) }

                if (!isLoggedIn) {
                    LoginScreen { name, salary ->
                        userName = name
                        userSalary = salary
                        isLoggedIn = true
                    }
                } else {
                    // Ya validado, mostrar pantalla principal
                    FinanceHomeScreen()
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
    AppFinanzasTheme {
        Greeting("Android")
    }
}