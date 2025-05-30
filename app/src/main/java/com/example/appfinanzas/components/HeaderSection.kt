package com.example.appfinanzas.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HeaderSection(userName: String, userSalary: Double) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1976D2))
            .padding(24.dp)
    ) {
        Column {
            Text("Hola, $userName 👋", color = Color.White, style = MaterialTheme.typography.headlineSmall)
            Text("Sueldo mensual: $${"%.2f".format(userSalary)}", color = Color.White)
        }
    }
}
