package com.example.tasks


import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.data.DataObject
import com.example.data.TaskDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class SplashScreen : AppCompatActivity() {

    private lateinit var database: TaskDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        database = Room.databaseBuilder(
            applicationContext,TaskDatabase::class.java,"To_Do"
        ).build()

        GlobalScope.launch {
            DataObject.listdata=database.dao().getTasks() as MutableList<CardInfo>
        }
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)


        },2000)



    }
}
