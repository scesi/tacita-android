package org.scesi.tacita.data.model

data class  Task(
    val id: Int,
    val name: String,
    val description: String,
    val subject: String,
    val status: String,
)
