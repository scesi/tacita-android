package org.scesi.tacita.data.network

import org.scesi.tacita.data.model.Task
import org.scesi.tacita.data.network.model.ApiResponse
import retrofit2.http.GET

interface TasksService{

    @GET("/v1/46d8cc59-5016-44c7-8253-cb32241113c0")
    suspend fun getTasks():List<Task>
}
