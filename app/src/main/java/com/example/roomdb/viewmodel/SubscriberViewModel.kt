package com.example.roomdb.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdb.Db.Subscriber
import com.example.roomdb.model.SubscriberRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SubscriberViewModel(private val subscriberRepository: SubscriberRepository) :ViewModel() {

       var subscriberData = subscriberRepository.allSubscriberData

      private  var statusMsg =MutableLiveData<String>()

        val message : LiveData<String>
         get() = statusMsg


     fun insertSubscriberData(
         title: String,
         desc: String,
         date: String,
         time: String
     ) {

          viewModelScope.launch {
              subscriberRepository.insertData(Subscriber(0,title,desc,date,time))
              statusMsg.value = "Data inserted successfully"
          }

     }

     fun updateSubscriberData(
         title: String,
         desc: String,
         date: String,
         time: String
     ) {
          viewModelScope.launch {
//               subscriberRepository.updateData(Subscriber(0,title,desc,date,time))
          }
     }


//     fun deleteAll(){
//
//          viewModelScope.launch {
//               subscriberRepository.deleteAll()
//          }
//     }



}