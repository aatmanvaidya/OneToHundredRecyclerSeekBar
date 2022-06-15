package com.example.onetohundredrecyclerseekbar

import android.util.Log
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onetohundredrecyclerseekbar.models.NumberData

class RecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<NumberData> = ArrayList()
    override fun getItemViewType(position: Int): Int = position
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return items.size
    }
    fun submitList(numList: List<NumberData>) {
        items = numList
        Log.d("list0", items.toString())
    }


}