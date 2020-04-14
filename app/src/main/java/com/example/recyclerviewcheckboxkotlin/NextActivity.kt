package com.example.recyclerviewcheckboxkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class NextActivity : AppCompatActivity() {

    private var tv: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        tv = findViewById(R.id.tv) as TextView

        for (i in 0 until ReAdapter.imageModelArrayList.size) {
            if (ReAdapter.imageModelArrayList.get(i).getSelecteds()) {
                tv!!.text = tv!!.text.toString() + " " + ReAdapter.imageModelArrayList.get(i).getAnimals()
            }
        }
    }
}
