package org.scesi.tacita.ui.screens.tasks

import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Shape
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment.Companion.Rectangle
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.scesi.tacita.TacitaApp
import org.scesi.tacita.data.TasksRepository
import org.scesi.tacita.data.model.Task

@Composable
fun MainTaskScreen() {
    Column {
        MenuChips()
        TasksScreen()
    }
}

@Composable
fun TasksScreen() {
    var tasksState by remember { mutableStateOf(emptyList<Task>()) }

    LaunchedEffect(Unit) {
        tasksState = TasksRepository.getTasks()
    }

    TaskScreen(tasks = tasksState)
}

@Composable
fun TaskScreen(tasks: List<Task>) {
    LazyColumn(
        contentPadding = PaddingValues(4.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(tasks) {
            TaskItem(task = it)
        }
    }
}

@Composable
fun TaskItem(task: Task, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxSize(),
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row {
            RectangleShapeDemo()
            Column(modifier = Modifier.padding(5.dp, 10.dp)) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = task.name,
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold,

                        )
//                    Icon(imageVector = Icons.Default.Phone, contentDescription = "")
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Sin concluir",
                        color = Color.Red
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Text(
                        text = task.description.take(15),

                        )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Hora entrega: 20:00"
                    )
                }


            }
        }
    }
}

@Composable
fun RectangleShapeDemo() {
    ExampleBox(shape = RectangleShape)
}

@Composable
fun ExampleBox(shape: Shape) {
    Column(
        modifier = Modifier
    ) {
        Box(
            modifier = Modifier
                .height(70.dp)
                .width(8.dp)
                .clip(shape)
                .background(Color.Red)
        )
    }
}

@Preview
@Composable
fun TaskScreenPreview() {
    val tasks = (1..10).map {
        Task(
            id = it,
            name = "Name $it ",
            "Description",
            subject = "Intro",
            status = "Completed"
        )
    }
    TacitaApp {
        TaskScreen(tasks = tasks)
    }


}