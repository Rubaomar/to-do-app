package com.example.tasks

import android.content.Context
import android.widget.CheckBox
import com.example.data.Task
import com.example.data.TaskDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

data class CardInfo (
    var taskName: String,
    var priority: String,
    var detail: String
    )

/*

*/