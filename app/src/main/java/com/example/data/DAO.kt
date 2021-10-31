package com.example.data

import androidx.room.*
import com.example.tasks.CardInfo

@Dao
interface DAO {

    @Insert
    suspend fun insertTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

   // @Query("Delete  from To_Do")
 //   suspend fun deleteAll() : List<Task>

    @Query("select * from To_Do")
    suspend fun getTasks() : List<CardInfo>
}