package com.example.assignmentdemoapp.Presentation.view.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDAO {

        @Insert
        fun saveData(address_entity: UserEntity)

        @Query("select * from UserEntity")
        fun reademp():List<UserEntity>
}