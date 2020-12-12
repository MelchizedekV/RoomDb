package com.example.roomdb.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.roomdb.model.SubscriberRepository
import java.lang.IllegalStateException

@Suppress("UNCHECKED_CAST")
class SubscriberViewModelFactory(private val subscriberRepository: SubscriberRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

     if (modelClass.isAssignableFrom(SubscriberViewModel::class.java)){

         return SubscriberViewModel(subscriberRepository)  as T
     }
         throw IllegalStateException("ViewModel not found")

    }
}