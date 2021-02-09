package com.example.assignmentdemoapp.Presentation.view.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.assignmentdemoapp.Domain.domain.entity.EmployeeE
import com.example.assignmentdemoapp.Domain.domain.entity.RegionE
import com.example.assignmentdemoapp.R

class EmployeeAdapter (
    val items: List<EmployeeE>
) : RecyclerView.Adapter<EmployeeAdapter.MyViewHolder>(), Filterable {
    var items_list = items
    var callback: RecyclerviewCallbacks<EmployeeE>? = null

    fun setOnClick(click: RecyclerviewCallbacks<EmployeeE>) {
        callback = click
    }

    fun selectedItem(position: Int) {
        notifyItemChanged(position)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmployeeAdapter.MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items_list.size
    }

    inner class MyViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        var tvName: TextView = itemView.findViewById(R.id.search_item_name)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvName.text = items_list.get(position).name

    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence?): FilterResults {
                val charString = charSequence.toString()
                if (charString.isEmpty()) {
                    items_list = items
                } else {
                    val filteredList: MutableList<EmployeeE> = ArrayList()
                    for (row in items) {
                        // name match condition. this might differ depending on your requirement
                        // here we are looking for name or phone number match
                        if (row.name!!.toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row)
                        }
                    }
                    items_list = filteredList
                }
                val filterResults = FilterResults()
                filterResults.values = items_list
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                items_list = (results!!.values as List<EmployeeE>?)!!
                // refresh the list with filtered data
                // refresh the list with filtered data
                notifyDataSetChanged()
            }
        }
    }
}