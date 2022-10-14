package com.example.prueba_compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest


@Composable

fun BScreen(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.DarkGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally  ){

        Box(modifier = Modifier
            .height(250.dp)
            .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ){
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://loremflickr.com/320/240?lock=5")
                    .crossfade(2000)
                    .build(),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .fillMaxSize()
                    .background(Color.Red),
                contentScale = ContentScale.Crop
            )
            Icon(imageVector =Icons.Default.PlayCircleOutline ,
                contentDescription = null ,
                tint = Color.White ,
                modifier = Modifier
                    .size(92.dp)
            )

        }
        Icon(painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null ,
            tint = Color.Green
        )

        Text(text = "B" , fontSize = 30.sp , color = Color.White)
        Spacer(modifier = Modifier.size(30.dp))
        Button(onClick = { navController
            .navigate("C")
        }) {
            Text(text = "Go To C")
        }
    }
}

