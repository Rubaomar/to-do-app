package com.example.data

import com.example.tasks.CardInfo


object DataObject {
    var listdata = mutableListOf<CardInfo>()

    fun setData(taskName: String,priority: String,detail: String) {
       listdata.add(CardInfo(taskName,priority,detail))
    }

    fun getAllData(): List<CardInfo> {
        return listdata
    }

    fun deleteAll(){
        listdata.clear()
    }

    fun getData(pos:Int): CardInfo {
        return listdata[pos]
    }

    fun deleteData(pos: Int){
        listdata.removeAt(pos)
    }

    fun updateData(pos:Int, taskName:String, priority:String, detail: String) {
        listdata[pos].taskName= taskName
        listdata[pos].priority= priority
        listdata[pos].detail= detail

    }

}


