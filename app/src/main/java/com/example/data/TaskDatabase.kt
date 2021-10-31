package com.example.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Task::class], version = 1)
abstract class TaskDatabase : RoomDatabase(){
    abstract fun dao(): DAO

    companion object {
        private var INSTANCE: TaskDatabase? = null
        fun getAppDataBase(context: Context): TaskDatabase? {
            if (INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    TaskDatabase::class.java,
                    "task-database"
                ).build()
            }
            return INSTANCE
        }
    }
}
