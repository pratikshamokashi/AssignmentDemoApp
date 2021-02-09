package com.example.assignmentdemoapp.Presentation.view.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class UserEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Int=0
    @ColumnInfo(name = "Country")
    var Country :String=""
    @ColumnInfo(name = "Zone")
    var Zone :String=""
    @ColumnInfo(name = "Region")
    var Region :String=""
    @ColumnInfo(name = "Area")
    var Area :String=""
    @ColumnInfo(name = "Employee")
    var Employee :String=""
//    @ColumnInfo(name = "country")
//    var country :String=""
//    @ColumnInfo(name = "addressView")
//    var addressView:String=""

}