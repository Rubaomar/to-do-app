package com.example.tasks

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.data.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_update_card.*
import kotlinx.android.synthetic.main.activity_update_card.create_detail
import kotlinx.android.synthetic.main.activity_update_card.create_deuDate
import kotlinx.android.synthetic.main.activity_update_card.create_priority
import kotlinx.android.synthetic.main.activity_update_card.create_task
import kotlinx.android.synthetic.main.activity_update_card.updateBtn
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class UpdateCard() : AppCompatActivity() {

    private lateinit var database: TaskDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_card)

        database = Room.databaseBuilder(
            applicationContext, TaskDatabase::class.java,"To_Do"
        ).build()

        val pos = intent.getIntExtra("id", -1)
        if (pos != -1) {
            val task = DataObject.getData(pos).taskName
            val priority = DataObject.getData(pos).priority
            val detail = DataObject.getData(pos).detail
            create_task.setText(task)
            create_priority.setText(priority)
            create_detail.setText(detail)

            deleteBtn.setOnClickListener {
                DataObject.deleteData(pos)
                GlobalScope.launch {
                    database.dao().deleteTask(
                        Task(pos+1,task,priority,detail)
                    )
                }
                Toast.makeText(this,"Deleted", Toast.LENGTH_SHORT).show()
                myIntent()
            }
            updateBtn.setOnClickListener {
                DataObject.updateData(
                    pos,
                    create_task.text.toString(),
                    create_priority.text.toString(),
                    create_detail.text.toString()
                )
                GlobalScope.launch {
                    database.dao().updateTask(
                        Task(pos+1,
                            create_task.text.toString(),
                            create_priority.text.toString(),
                            create_detail.text.toString()

                        )
                    )
                }

                Toast.makeText(this,"Updated!", Toast.LENGTH_SHORT).show()
                myIntent()
            }
        }
    }
    fun myIntent(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)

    }
}









//        database = Room.databaseBuilder(
//            applicationContext, TaskDatabase::class.java, "To_Do"
//        ).build()
//
//
//
//        // update functions
//
//        deleteBtn = findViewById(R.id.deleteBtn)
//    //-------- fun deleteTask()
//
//        updateBtn = findViewById(R.id.updateBtn)
//    //-------- fun updateTask()
//    }
//}

//    private lateinit var database: TaskDatabase
//    private lateinit var deleteBtn: FloatingActionButton
//    private lateinit var updateBtn: FloatingActionButton






