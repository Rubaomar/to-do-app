package com.example.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.text.DateFormat
import java.util.*

@Parcelize
@Entity(tableName = "To_Do")
data class Task (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var taskName: String,
    var priority: String,
    var dueDate: String,
    ) : Parcelable

//    var completed: Boolean = false,
//    var detail: String,
//    val createdDate: Long = System.currentTimeMillis()
//-----------------------------------------------------------
//    val createDateFormatted: String
//    get() = DateFormat.getDateTimeInstance().format(createdDate)
//}
