package com.example.assignmentdemoapp.Presentation.view.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [(UserEntity::class)],version = 1)
abstract class UserDB : RoomDatabase() {
    abstract fun getUser(): UserDAO
}

