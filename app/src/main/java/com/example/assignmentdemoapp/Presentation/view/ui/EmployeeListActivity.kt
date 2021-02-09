package com.example.assignmentdemoapp.Presentation.view.ui

import android.os.Bundle
import android.util.Log
import android.widget.PopupWindow
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assignmentdemoapp.Domain.domain.entity.EmployeeE
import com.example.assignmentdemoapp.R
import kotlinx.android.synthetic.main.activity_employee_list.*

class EmployeeListActivity : AppCompatActivity(),
    androidx.appcompat.widget.SearchView.OnQueryTextListener {

    private var filterPopup: PopupWindow? = null
    lateinit var employeeList : ArrayList<EmployeeE>
    private var adapter: EmployeeAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_list)
        employeeList =
            intent.getSerializableExtra("FILES_TO_SEND") as ArrayList<EmployeeE>
        init()

    }

    private fun init() {
        if(employeeList!= null){
            showEmployeeAdapter()
        }else{
            Log.d("Test","List"+employeeList)
        }

    }



    private fun showEmployeeAdapter() {

        val linearLayoutManagerAccessory =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recycl_sub_categpry.layoutManager = linearLayoutManagerAccessory
        val adapter = EmployeeAdapter(employeeList)
        recycl_sub_categpry.adapter = adapter
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        adapter?.filter?.filter(query);
        return false

    }

    override fun onQueryTextChange(newText: String?): Boolean {
        adapter!!.filter.filter(newText)
        return false
    }
}