package com.example.recyclerviewcheckboxkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Button
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var modelArrayList: ArrayList<ReModel>? = null
    private var customAdapter: ReAdapter? = null
    private var btnselect: Button? = null
    private var btndeselect: Button? = null
    private var btnnext: Button? = null
    private val animallist = arrayOf("Lion", "Tiger", "Leopard", "Cat", "Balu" , "wolf", "monkey", "Elephant" ,"Panda", "Rabbit","Giraffe")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler) as RecyclerView
        btnselect = findViewById(R.id.select) as Button
        btndeselect = findViewById(R.id.deselect) as Button
        btnnext = findViewById(R.id.next) as Button

        modelArrayList = getModel(false)
        customAdapter = ReAdapter(this, modelArrayList!!)
        recyclerView!!.adapter = customAdapter
        recyclerView!!.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

        btnselect!!.setOnClickListener {
            modelArrayList = getModel(true)
            customAdapter = ReAdapter(this@MainActivity, modelArrayList!!)
            recyclerView!!.adapter = customAdapter
        }
        btndeselect!!.setOnClickListener {
            modelArrayList = getModel(false)
            customAdapter = ReAdapter(this@MainActivity, modelArrayList!!)
            recyclerView!!.adapter = customAdapter
        }
        btnnext!!.setOnClickListener {
            val intent = Intent(this@MainActivity, NextActivity::class.java)
            startActivity(intent)
        }

    }

    private fun getModel(isSelect: Boolean): ArrayList<ReModel> {
        val list = ArrayList<ReModel>()
        for (i in 0..10) {

            val model = ReModel()
            model.setSelecteds(isSelect)
            model.setAnimals(animallist[i])
            list.add(model)
        }
        return list
    }
}

