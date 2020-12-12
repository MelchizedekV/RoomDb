package com.example.roomdb.Db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Subscriber_table_name")
data class Subscriber(

        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "Subscriber_id")
        val id:Int,
        @ColumnInfo(name = "Subscriber_title")
        val title:String,
        @ColumnInfo(name = "Subscriber_description")
        val description:String,
        @ColumnInfo(name = "Subscriber_date")
        val date:String,
        @ColumnInfo(name = "Subscriber_time")
        val time:String
)
