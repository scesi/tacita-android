package com.example.prueba_compose

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable

fun CScreen(navController: NavController){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally  ,
        verticalArrangement = Arrangement.SpaceAround
    ){
        Button(onClick = { navController.navigate("A"){
            popUpTo("A"){inclusive = true}
        }
        }) {
            Text(text = "Go To A")
        }
        Text(text = "C" , fontSize = 30.sp , color = Color.White)
        Spacer(modifier = Modifier.size(30.dp))
        Greetings()
        Spacer(modifier = Modifier.size(30.dp))


    }
}

@Composable
private fun Greetings(names: List<String> = List(10) { "Tarea chingona $it"} ) {
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)) {
        items(items = names) { name ->
            Greeting(name = name)
        }
    }
}

@Composable
fun Greeting(name: String , modifier: Modifier = Modifier) {
    Card(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
        elevation = 14.dp,
        shape = RoundedCornerShape(12)

    ) {
        CardContent(name)
    }
}

@Composable
private fun CardContent(name: String) {
    val expanded by remember { mutableStateOf(false) }
    val aux = "Sin Concluir"
    Divider(
        color = Color.Red,
        modifier = Modifier
            .width(4.dp)
            .height(100.dp),

        )
    Row(
        modifier = Modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            modifier = Modifier
                .weight(3f)
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.subtitle1.copy(
                    fontWeight = FontWeight.SemiBold
                )
            )
            Row(
                verticalAlignment = Alignment.CenterVertically

            ) {

                Text(
                    text = "Materia...",
                    style = MaterialTheme.typography.overline.copy(
                        fontWeight = FontWeight.Thin
                    )

                )
                Text(
                    text = "15:45 - 17:00",
                    style = MaterialTheme.typography.overline.copy(
                        fontWeight = FontWeight.Thin
                    )

                )

            }

            if (expanded) {
                Text(
                    text = ("Composem ipsum color sit lazy, " +
                            "padding theme elit, sed do bouncy. ").repeat(4),
                )
            }
        }
        TextButton(onClick = { /*TODO*/ } , Modifier.weight(1f)) {
            Text(
                text = aux,
                style = MaterialTheme.typography.overline.copy(
                    fontWeight = FontWeight.Medium ,

                    ),
                color = Color.Red,

                )
        }


    }
}
