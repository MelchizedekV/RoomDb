package com.example.roomdb.Db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface SubscriberDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSubscriber(subscriber: Subscriber)

    @Query("SELECT * FROM Subscriber_table_name")
    fun getAllSubscriber():LiveData<List<Subscriber>>

}