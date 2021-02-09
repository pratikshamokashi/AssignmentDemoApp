package com.example.assignmentdemoapp.Presentation.view.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.assignmentdemoapp.Domain.domain.entity.*
import com.example.assignmentdemoapp.Presentation.view.base.Status
import com.example.assignmentdemoapp.Presentation.view.db.UserDB
import com.example.assignmentdemoapp.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel : DataViewModel by viewModel()
    var countryList: List<CountryE> = ArrayList<CountryE>()
    var zoneList: List<ZoneE> = java.util.ArrayList<ZoneE>()
    var regionList: List<RegionE> = ArrayList<RegionE>()
    var areaList: List<AreaE> = ArrayList<AreaE>()
    var employeeList: ArrayList<EmployeeE> = ArrayList<EmployeeE>()
    var adapter_state: ArrayAdapter<CountryE>? = null
    var adapter_zone: ArrayAdapter<ZoneE>? = null

    var zone :String ?= null
    var area :String ?= null
    var region :String ?= null
    var name :String ?= null
    var list = arrayListOf<String>()

    private var filterPopup: PopupWindow? = null
    private var selectedItem: Int = -1

    lateinit var  db : UserDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainViewModel.getDataRequest()
        setupObserver()

        db= Room.databaseBuilder(applicationContext, UserDB::class.java,"address.db")
            .build()
        filter.setOnClickListener {
            dismissPopup()
            filterPopup = showAlertFilter()
            filterPopup?.isOutsideTouchable = true
            filterPopup?.isFocusable = true
            filterPopup?.showAsDropDown(filter)

        }
    }

    private fun showAlertFilter(): PopupWindow? {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.alter_filter_layout, null)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))
        val adapter = ZoneAdapter(zoneList)
//        adapter.addAlertFilter(getFilterItems())
        recyclerView.adapter = adapter
        adapter.selectedItem(selectedItem)
        adapter.setOnClick(object : RecyclerviewCallbacks<ZoneE> {
            override fun onItemClick(view: View, position: Int, item: ZoneE) {
                selectedItem = position
                for (i in 0..regionList.size -1){
                    if (regionList.get(i).territory!!.contains(item.zone.toString())) {
                        zone = item.zone.toString()

                        showAlert()
                    }
                }
                dismissPopup()
            }
        })

        return PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    private fun showAlert() {
        filterPopup = showAlertRegion()
        filterPopup?.isOutsideTouchable = true
        filterPopup?.isFocusable = true
        filterPopup?.showAsDropDown(filter)

    }

    private fun showAlertRegion(): PopupWindow? {
            val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val view = inflater.inflate(R.layout.alter_filter_layout, null)
            val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
            recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))
            val adapter = RegionAdapter(regionList)


            recyclerView.adapter = adapter
            adapter.selectedItem(selectedItem)
            adapter.setOnClick(object : RecyclerviewCallbacks<RegionE> {
                override fun onItemClick(view: View, position: Int, item: RegionE) {
                    selectedItem = position
                    for (i in 0..regionList.size -1){
                        if (regionList.get(i).territory!!.contains(zone.toString())) {
                            region = item.region.toString()

                            showAlertArea()
                        }
                    }
                    dismissPopup()
                }
            })

            return PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        }

    private fun showAlertArea() {
        filterPopup = showAlertAreaData()
        filterPopup?.isOutsideTouchable = true
        filterPopup?.isFocusable = true
        filterPopup?.showAsDropDown(filter)
    }

    private fun showAlertAreaData(): PopupWindow? {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.alter_filter_layout, null)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))
        val adapter = AlertFilterAdapter(areaList)


        recyclerView.adapter = adapter
        adapter.selectedItem(selectedItem)
        adapter.setOnClick(object : RecyclerviewCallbacks<AreaE> {
            override fun onItemClick(view: View, position: Int, item: AreaE) {
                selectedItem = position
                val i =Intent(this@MainActivity,EmployeeListActivity::class.java)
                i.putExtra("FILES_TO_SEND", employeeList)
                startActivity(i)
                dismissPopup()
            }
        })

        return PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }
    private fun showAlertEmployee() {
        Log.d("TESTTAG",""+area+" "+region+""+zone)
        filterPopup = showAlertEmployeeData()
        filterPopup?.isOutsideTouchable = true
        filterPopup?.isFocusable = true
        filterPopup?.showAsDropDown(filter)
    }

    private fun showAlertEmployeeData(): PopupWindow? {
        val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.alter_filter_layout, null)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))
        val adapter = EmployeeAdapter(employeeList)


        recyclerView.adapter = adapter
        adapter.selectedItem(selectedItem)
        adapter.setOnClick(object : RecyclerviewCallbacks<EmployeeE> {
            override fun onItemClick(view: View, position: Int, item: EmployeeE) {
                selectedItem = position
                for (i in 0..employeeList.size -1){
                    if (employeeList.get(i).territory!!.toString().contains(item.name.toString())) {
                        name = item.name.toString()

                        showAlertEmployee()
                    }
                }
                dismissPopup()
            }
        })

        return PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }


    private fun setupObserver() {
        mainViewModel.dataResponse().observe(this, Observer {

            when(it.status){
                Status.SUCCESS->{
                    Log.e("TAG SUCCESS", it.data.toString())
                    countryList = it.mResponseDataEntiy?.responseData?.country!!
                    zoneList = it.mResponseDataEntiy?.responseData?.zone!!
                    regionList = it.mResponseDataEntiy?.responseData?.region!!
                    areaList = it.mResponseDataEntiy?.responseData?.area!!
                    employeeList = (it.mResponseDataEntiy?.responseData?.employee as ArrayList<EmployeeE>?)!!
                }
                Status.LOADING->{Log.e("TAG Loading", "Loading")}
                Status.ERROR->{Log.e("TAG Error", "Error")}
            }
        })
    }
    private fun dismissPopup() {
        filterPopup?.let {
            if(it.isShowing){
                it.dismiss()
            }
            filterPopup = null
        }

    }
}
