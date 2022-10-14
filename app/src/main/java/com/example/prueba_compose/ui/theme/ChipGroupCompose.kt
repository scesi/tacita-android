package com.example.prueba_compose.ui.theme

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ChipGroupCompose(){

    val chipList : List<String> = listOf(
        "Spent",
        "Add bunds",
        "Savings",
        "Agregar",
        "Lunes",
        "Martes",
        "Miercoles"
    )

    var selected by remember { mutableStateOf("")}
    val scrollState = rememberScrollState()
    Row(
        modifier = Modifier
            .padding(top = 25.dp, bottom = 25.dp)
            .fillMaxWidth()
            .horizontalScroll(scrollState)
    ){
        chipList.forEach{
        Chip(
            title = it ,
            selected = selected ,
            onSelected = {
                selected = it
            }
            )
        }
    }
}

@Composable
fun Chip(
    title:String,
    selected:String,
    onSelected:(String) -> Unit
){
    val isselected = selected == title
    val background = if(isselected) Color.Magenta else Color.Blue
    val contentColor = if(isselected) Color.DarkGray else Color.White

    Box(modifier = Modifier
        .padding(end = 18.dp)
        .height(35.dp)
        .clip(RoundedCornerShape(13.dp))
        .background(background)
        .clickable(onClick = {
            onSelected(title)
        })
    ) {
        Row(
            modifier = Modifier.padding(start = 10.dp,end=10.dp,top = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            AnimatedVisibility(visible = isselected) {
                Icon(
                    imageVector = Icons.Filled.Check ,
                    contentDescription = "Check" , 
                    tint = Color.White)
            }
        Text(text = title , color = contentColor, fontSize = 16.sp)
        }
    }
}
