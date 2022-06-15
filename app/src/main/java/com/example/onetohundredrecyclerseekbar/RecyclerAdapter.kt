package com.example.onetohundredrecyclerseekbar

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onetohundredrecyclerseekbar.models.NumberData
import kotlinx.android.synthetic.main.list_item.view.*

class RecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items: List<NumberData> = ArrayList()
    override fun getItemViewType(position: Int): Int = position

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NumberViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is NumberViewHolder -> {
                holder.bind(items[position])
            }
        }
//        holder.setIsRecyclable(false)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(numList: List<NumberData>) {
        items = numList
        Log.d("list0", items.toString())
    }

    class NumberViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val numDisplay: TextView = itemView.text
        private val seekShow: SeekBar = itemView.seek_bar
        private val thumbText: TextView = itemView.thumb_text

        fun bind(numData: NumberData) {
            numDisplay.text = (numData.number).toString()
            seekShow.progress = numData.seekBar!!
            thumbText.text = (numData.thumbPopText).toString()

            seekShow.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, p2: Boolean) {
                    if (p2) {
                        if (progress in 0..99) {
                            val newNumber = progress.toString().toInt() + 1
                            numDisplay.text = newNumber.toString()
                            numData.number = newNumber
                            seekBar?.incrementProgressBy(1)
                            val value = seekBar?.progress
                            if (value != null) {
                                numData.seekBar = value
                            }
                            thumbText.text = newNumber.toString()
                            numData.thumbPopText = newNumber
                            val width: Int = seekBar!!.width - seekBar!!.paddingLeft - seekBar!!.paddingRight
                            val displacement = width * (seekBar.progress/seekBar.max.toFloat())
                            thumbText.translationX = displacement

                        }
                    }

                }

                override fun onStartTrackingTouch(p0: SeekBar?) {
                }

                override fun onStopTrackingTouch(p0: SeekBar?) {
                }

            })

        }
    }
}