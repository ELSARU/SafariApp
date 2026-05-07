package com.victor.safariwalk.data.repositories

import com.victor.safariwalk.data.models.TodoModel
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.storage.Storage

class TodoRepository : TodoService {
    val supabase = createSupabaseClient(
        supabaseUrl = "https://pllxgaxtkmcstuwfbgzg.supabase.co",
        supabaseKey = "sb_publishable_gryw4UHYE85Qa2fdB2_hKg_IyhWUevf"
    ) {
        install(Postgrest)
        install(Storage)
        install(Auth)
    }

    override suspend fun createTask(todo: TodoModel): TodoModel? {
        val task = supabase.from("Todo").insert(todo) {
            select()
        }.decodeSingle<TodoModel>()
        return task
    }

    override suspend fun getAllTasks(): List<TodoModel> {
        val tasks = supabase.from("Todo").select().decodeList<TodoModel>()
        return tasks
    }

    override suspend fun getTask(id: Int): TodoModel? {
        val todo = supabase.from("Todo").select() {
            filter {
                TodoModel::id eq id
            }
        }.decodeAsOrNull<TodoModel>()
        return todo
    }

    override suspend fun updateTask(todo: TodoModel): TodoModel? {
        val todo = supabase.from("Todo").update(
            todo
        ) {
            select()
            filter {
                eq("id", todo.id!!)
            }
        }.decodeSingle<TodoModel>()
        return todo
    }

    override suspend fun deleteTask(id: Int): Boolean {
        supabase.from("Todo").delete {
            filter {
                eq("id", id)
            }
        }
        return getTask(id) == null
    }

}
