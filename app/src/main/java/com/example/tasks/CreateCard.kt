package com.example.tasks

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.data.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_create_card.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CreateCard : AppCompatActivity() {
    private lateinit var database: TaskDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_card)
        database = Room.databaseBuilder(
            applicationContext,TaskDatabase::class.java,"To_Do"
        ).build()

        checkBtn.setOnClickListener {
            if (create_task.text.toString().trim { it <= ' ' }.isNotEmpty()
                && create_detail.text.toString().trim { it <= ' ' }.isNotEmpty()
                && create_priority.text.toString().trim { it <= ' ' }.isNotEmpty()
            ) {
                var task = create_task.getText().toString()
                var detail = create_detail.getText().toString()
                var priority = create_priority.getText().toString()
                DataObject.setData(task,detail,priority)
                GlobalScope.launch {
                    database.dao().insertTask(Task(0,task,priority,detail))
                }


                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)

            }

        }
    }
}


//GlobalScope.launch {
//    Log.i("harsh", database.dao().getTasks().toString())
//}