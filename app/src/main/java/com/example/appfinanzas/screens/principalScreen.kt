package com.example.appfinanzas.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun FinanceHomeScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFF5F5F5))) {

        // HEADER
        HeaderSection()

        // BODY
        BodySection(modifier = Modifier
            .weight(1f)
            .padding(16.dp))

        // FOOTER
        FooterSection()
    }
}

@Composable
fun HeaderSection() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1976D2))
            .padding(24.dp)
    ) {
        Text(
            text = "Mi Finanzas",
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Composable
fun BodySection(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("Resumen mensual", style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Ingresos: $4,000")
                Text("Gastos: $2,500")
                Text("Balance: $1,500")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Aquí puedes poner una lista de transacciones
        Text("Últimas transacciones", style = MaterialTheme.typography.titleMedium)
        // ...
    }
}

@Composable
fun FooterSection() {
    BottomAppBar(containerColor = Color(0xFF1976D2)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            IconButton(onClick = { /* TODO: Navegar */ }) {
                Icon(Icons.Default.Home, contentDescription = "Inicio", tint = Color.White)
            }
            IconButton(onClick = { /* TODO: Agregar gasto */ }) {
                Icon(Icons.Default.AddCircle, contentDescription = "Agregar", tint = Color.White)
            }
            IconButton(onClick = { /* TODO: Ver perfil */ }) {
                Icon(Icons.Default.Person, contentDescription = "Perfil", tint = Color.White)
            }
        }
    }
}
