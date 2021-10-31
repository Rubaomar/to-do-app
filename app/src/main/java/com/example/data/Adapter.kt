package com.example.data

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.tasks.CardInfo

import com.example.tasks.R
import com.example.tasks.UpdateCard

import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.card_view.view.*
import kotlinx.android.synthetic.main.card_view.view.priority
import kotlin.text.toLowerCase as toLowerCase //

class Adapter( var data: List<CardInfo>) : RecyclerView.Adapter<Adapter.viewHolder>() {
   class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
       var taskName = itemView.taskName
       var detail = itemView.detail
       var priority = itemView.priority
       var layout = itemView.mylayout
   }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        var itemView = LayoutInflater.from(parent.context).
                inflate(R.layout.card_view,parent,false)
        return viewHolder(itemView)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
//        when(data[position].priority.toLowerCase()){
//            "high"-> holder.layout.setBackgroundColor(Color.parseColor("00000")) // BabyRed
//            "medium"-> holder.layout.setBackgroundColor(Color.parseColor("00000")) // BabyOrange
//            else -> holder.layout.setBackgroundColor(Color.parseColor("00000")) // BabyPurple
//        }


        holder.taskName.text = data[position].taskName
        holder.detail.text = data[position].detail
        holder.priority.text = data[position].priority
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,UpdateCard::class.java)
            intent.putExtra("id", position)
            holder.itemView.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
      return data.size
    }
}





