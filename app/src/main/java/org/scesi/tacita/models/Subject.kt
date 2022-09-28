package org.scesi.tacita.models

data class Subject(
    var name: String,
    var nextClass: String,
    var taskCount: Int,
    var examCount: Int,
    var eventCount: Int
)