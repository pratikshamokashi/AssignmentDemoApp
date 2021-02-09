package com.example.assignmentdemoapp.Presentation.view.ui

import android.view.View

interface RecyclerviewCallbacks<T> {

    fun onItemClick(view: View, position: Int, item: T)

}