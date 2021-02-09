package com.example.assignmentdemoapp.Presentation.view.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentdemoapp.Domain.domain.entity.RegionE
import com.example.assignmentdemoapp.R

class RegionAdapter (
    val items: List<RegionE>
) : RecyclerView.Adapter<RegionAdapter.MyViewHolder>() {
    var items_list = items
    var callback: RecyclerviewCallbacks<RegionE>? = null

    fun setOnClick(click: RecyclerviewCallbacks<RegionE>){
        callback = click
    }

    fun selectedItem(position: Int){
//        selectedItem = position
//        notifyItemChanged(position)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RegionAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.alert_filter_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items_list.size
    }

    inner class MyViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        var tvName: TextView = itemView.findViewById(R.id.alert_filter_name)
        //        var alert_filter_icon: ImageView = itemView.findViewById(R.id.alert_filter_icon)
//        var alert_filter_selected: ImageView = itemView.findViewById(R.id.alert_filter_selected)
        var filterLayout: ConstraintLayout = itemView.findViewById(R.id.alert_filter_item_layout)
        init {
            setClickListener(filterLayout)
        }

        private fun setClickListener(view: View) {
            view.setOnClickListener {
                callback?.onItemClick(it, adapterPosition, items_list[adapterPosition])
            }
        }

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvName.text = items_list.get(position).region

    }

}