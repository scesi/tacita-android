package com.example.prueba_compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prueba_compose.ui.theme.ChipGroupCompose

@Composable

fun AScreen(navController: NavController){
    Column(modifier = Modifier.fillMaxSize()) {
    ChipGroupCompose()
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Blue),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally  ){
        Text(text = "A" , fontSize = 30.sp , color = Color.White)
        Spacer(modifier = Modifier.size(30.dp))
        Button(onClick = { navController.navigate("B") }) {
            Text(text = "Go To B")
        }
    }
    }
}