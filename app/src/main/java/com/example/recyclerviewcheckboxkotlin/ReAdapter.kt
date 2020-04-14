package com.example.recyclerviewcheckboxkotlin

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast

import java.util.ArrayList

/**
 * Created by Parsania Hardik on 29-Jun-17.
 */
class ReAdapter(private val ctx: Context, imageModelArrayListMain: ArrayList<ReModel>) :
    RecyclerView.Adapter<ReAdapter.MyViewHolder>() {

    companion object {
         lateinit var imageModelArrayList: ArrayList<ReModel>
    }

    private val inflater: LayoutInflater
   // var imageModelArrayList: ArrayList<ReModel>

    init {

        inflater = LayoutInflater.from(ctx)
        imageModelArrayList = imageModelArrayListMain
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReAdapter.MyViewHolder {

        val view = inflater.inflate(R.layout.rv_item, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReAdapter.MyViewHolder, position: Int) {

        holder.checkBox.text = "Checkbox $position"
        holder.checkBox.isChecked = imageModelArrayList[position].getSelecteds()
        holder.tvAnimal.setText(imageModelArrayList[position].getAnimals())

        // holder.checkBox.setTag(R.integer.btnplusview, convertView);
        holder.checkBox.tag = position
        holder.checkBox.setOnClickListener {
            val pos = holder.checkBox.tag as Int
            Toast.makeText(ctx, imageModelArrayList[pos].getAnimals() + " clicked!", Toast.LENGTH_SHORT).show()

            if (imageModelArrayList[pos].getSelecteds()) {
                imageModelArrayList[pos].setSelecteds(false)
            } else {
                imageModelArrayList[pos].setSelecteds(true)
            }
        }


    }

    override fun getItemCount(): Int {
        return imageModelArrayList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

         var checkBox: CheckBox
         val tvAnimal: TextView

        init {

            checkBox = itemView.findViewById(R.id.cb) as CheckBox
            tvAnimal = itemView.findViewById(R.id.animal) as TextView
        }

    }

}