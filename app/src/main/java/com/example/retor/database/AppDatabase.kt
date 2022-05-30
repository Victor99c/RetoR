package com.example.retor.database

import androidx.room.Database
import androidx.room.RoomDatabase

const val TABLE_USERS="uss"
const val DATABASE_VERSION=1
const val DATABASE_NAME="database.sqlite"


@Database(entities = [UserEntity::class],
    version = DATABASE_VERSION
)
abstract class AppDatabase : RoomDatabase(){
    abstract  fun userDao(): UserDao
}