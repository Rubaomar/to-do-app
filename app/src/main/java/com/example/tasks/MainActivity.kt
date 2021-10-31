package com.example.tasks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.data.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_view.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var database: TaskDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        database = Room.databaseBuilder(
            applicationContext,TaskDatabase::class.java, "To_Do"
        ).build()

        addBtn.setOnClickListener {
            val intent = Intent (this,CreateCard::class.java )
            startActivity(intent)
        }
        deleteAllBtn.setOnClickListener {
            DataObject.deleteAll()
            GlobalScope.launch {
                database.dao().deleteAll()
            }
            setRecycler()
        }
        setRecycler()
    }

    fun setRecycler(){
        recycler_view.adapter=Adapter(DataObject.getAllData())
        recycler_view.layoutManager=LinearLayoutManager(this)
    }

}

//private lateinit var database: TaskDatabase
// private lateinit var addBtn: FloatingActionButton

//        addBtn.setOnClickListener {
//            var intent = Intent(this, CreateCard::class.java)
//            startActivity(intent)
//        }
//        database = Room.databaseBuilder(
//            applicationContext, TaskDatabase::class.java, "To_Do"
//        ).build()


//        checkbox_completed.setOnClickListener{
//            Toast.makeText(this,
//            "Task Completed",
//            Toast.LENGTH_LONG).show()
//        }
