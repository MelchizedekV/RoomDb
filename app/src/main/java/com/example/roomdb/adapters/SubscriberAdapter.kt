package com.example.roomdb.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdb.Db.Subscriber
import com.example.roomdb.R


class SubscriberAdapter(
        private var subscriberData: List<Subscriber>
) : RecyclerView.Adapter<SubscriberAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(v)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.titleTxt.text = subscriberData[position].title
        holder.descTxt.text = subscriberData[position].description
        holder.dateTxt.text = subscriberData[position].date
        holder.timeTxt.text = subscriberData[position].time
    }

    override fun getItemCount(): Int {
        return subscriberData.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val titleTxt = itemView.findViewById(R.id.titleText) as TextView
        val descTxt  = itemView.findViewById(R.id.descText) as TextView
        val dateTxt = itemView.findViewById(R.id.DateTxt) as TextView
        val timeTxt  = itemView.findViewById(R.id.timeTxt) as TextView
    }




}