package org.scesi.tacita.ui.screens.tasks

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Preview
@Composable
fun MenuChips() {
    MenuChips(list = listOf("Tareas", "Examen", "Proyectos", "Clases", "Recordatorios"))
}

@Composable
fun MenuChips(list: List<String>) {
    LazyRow(contentPadding = PaddingValues(4.dp),
    horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        items(list){
            MenuItemChip(title = it)

        }
    }

}

@Composable
fun MenuItemChip(title : String) {
    Chip(label = title, contentDescription = "")
}


@Composable
fun Chip(
    startIcon: () -> ImageVector? = { null },
    isStartIconEnabled: Boolean = false,
    startIconTint: Color = Color.Unspecified,
    onStartIconClicked: () -> Unit = { },
    endIcon: () -> ImageVector? = { null },
    isEndIconEnabled: Boolean = false,
    endIconTint: Color = Color.Unspecified,
    onEndIconClicked: () -> Unit = { },
    color: Color =  MaterialTheme.colors.surface,
    contentDescription: String,
    label: String,
    isClickable: Boolean = false,
    onClick: () -> Unit = { }
) {
    Surface(
        modifier = Modifier.clickable(
            enabled = isClickable,
            onClick = { onClick() }
        ),
        elevation = 8.dp,
        shape = MaterialTheme.shapes.small,
        color = color
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            val leader = startIcon()
            val trailer = endIcon()

            if (leader != null) {
                Icon(
                    leader,
                    contentDescription = contentDescription,
                    tint = startIconTint,
                    modifier = Modifier
                        .clickable(enabled = isStartIconEnabled, onClick = onStartIconClicked)
                        .padding(horizontal = 4.dp)
                )
            }

            Text(
                label,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.button.copy(color = Color.Black)
            )

            if (trailer != null) {
                Icon(
                    trailer,
                    contentDescription = contentDescription,
                    tint = startIconTint,
                    modifier = Modifier
                        .clickable(enabled = isStartIconEnabled, onClick = onStartIconClicked)
                        .padding(horizontal = 4.dp)
                )
            }

        }
    }
}

@Composable
fun SelectableChip(
    label: String,
    contentDescription: String,
    selected: Boolean,
    onClick: (nowSelected: Boolean) -> Unit
) {
    Chip(
        startIcon = { if (selected) Icons.Default.Check else null },
        startIconTint = Color.Black.copy(alpha = 0.5f),
        contentDescription = contentDescription,
        label = label,
        isClickable = true
    ) { onClick(!selected) }
}

@Composable
fun RemovableChip(
    label: String,
    contentDescription: String,
    onRemove: () -> Unit
) {
    Chip(
        endIcon = { Icons.Default.Add },
        endIconTint = Color.Black.copy(alpha = 0.5f),
        contentDescription = contentDescription,
        label = label,
        onEndIconClicked = { onRemove() }
    )
}