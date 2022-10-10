package org.scesi.tacita.data

import org.scesi.tacita.data.model.Task
import org.scesi.tacita.data.network.ApiClient

object TasksRepository {

    suspend fun getTasks(): List<Task> {
        return ApiClient.tasksService.getTasks()
    }
}