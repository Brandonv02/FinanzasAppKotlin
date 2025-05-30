package com.example.appfinanzas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.appfinanzas.data.UserPreferences
import com.example.appfinanzas.screens.FinanceHomeScreen
import com.example.appfinanzas.screens.LoginScreen
import com.example.appfinanzas.ui.theme.AppFinanzasTheme
import com.example.appfinanzas.viewmodel.FinanceViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val financeViewModel = viewModel<FinanceViewModel>()
            MaterialTheme {
                var isLoading by remember { mutableStateOf(true) }
                var isLoggedIn by remember { mutableStateOf(false) }
                var userName by remember { mutableStateOf("") }
                var userSalary by remember { mutableStateOf(0.0) }

                LaunchedEffect(Unit) {
                    val (name, salary) = UserPreferences.getUserData(applicationContext)
                    if (!name.isNullOrBlank() && salary != null) {
                        userName = name
                        userSalary = salary
                        isLoggedIn = true
                    }
                    isLoading = false
                }

                if (isLoading) {
                    CircularProgressIndicator(modifier = Modifier.fillMaxSize())
                } else if (!isLoggedIn) {
                    LoginScreen { name, salary ->
                        userName = name
                        userSalary = salary
                        isLoggedIn = true
                        CoroutineScope(Dispatchers.IO).launch {
                            UserPreferences.saveUserData(applicationContext, name, salary)
                        }
                    }
                } else {
                    FinanceHomeScreen(userName, userSalary, financeViewModel)
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

@Composable
fun GreetingPreview() {
    AppFinanzasTheme {
        Greeting("Android")
    }
}