package com.example.roomdb.model

import com.example.roomdb.Db.Subscriber
import com.example.roomdb.Db.SubscriberDAO

class SubscriberRepository(private val dao: SubscriberDAO) {

    val allSubscriberData = dao.getAllSubscriber()

   suspend fun insertData(subscriber: Subscriber){
      dao.insertSubscriber(subscriber)
  }




}