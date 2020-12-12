package com.example.roomdb.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdb.Db.SubscriberDAO
import com.example.roomdb.Db.SubscriberDatabase
import com.example.roomdb.R
import com.example.roomdb.adapters.SubscriberAdapter
import com.example.roomdb.model.SubscriberRepository
import com.example.roomdb.viewmodel.SubscriberViewModel
import com.example.roomdb.viewmodel.SubscriberViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel:SubscriberViewModel

    private lateinit var subscriberRepository: SubscriberRepository
    private lateinit var subscriberDAO: SubscriberDAO
    private lateinit var insertData: Button

    private lateinit var updateData: Button


    private lateinit var title: TextView
    private lateinit var description: TextView
    private lateinit var date: TextView
    private lateinit var time: TextView

    private lateinit var subscriberAdapter: SubscriberAdapter
    private lateinit var subscriberListView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        insertData =findViewById(R.id.insertData)

        title=findViewById(R.id.title_text)
        description=findViewById(R.id.desc_text)
        date=findViewById(R.id.date_text)
        time=findViewById(R.id.time_text)
        subscriberDAO = SubscriberDatabase.getInstance(application).subscriberDAO
        subscriberRepository = SubscriberRepository(subscriberDAO)
        subscriberListView =findViewById(R.id.subscriber_recyclerView)
        viewModel = ViewModelProvider(this,SubscriberViewModelFactory(subscriberRepository)).get(SubscriberViewModel::class.java)
        insertData.setOnClickListener {

            callInsertFun(title.text.toString(),description.text.toString(),date.text.toString(),time.text.toString())
        }


        viewModel.message.observe(this, Observer {

                Toast.makeText(this,it,Toast.LENGTH_LONG).show()


        })
        viewModel.subscriberData.observe(this, Observer {

            subscriberAdapter = SubscriberAdapter(it)
            subscriberListView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
            subscriberListView.adapter =subscriberAdapter
        })
    }


    private fun callInsertFun(
       title: String,
       description: String,
       date: String,
       time: String
   ) {

       viewModel.insertSubscriberData(title,description,date,time)
   }
    private fun callUpdateFun(
        title: String,
        description: String,
        date: String,
        time: String
    ) {

        viewModel.updateSubscriberData(title,description,date,time)
    }




}