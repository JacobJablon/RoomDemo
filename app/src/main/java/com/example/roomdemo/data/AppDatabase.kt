package com.example.roomdemo.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdemo.data.dao.CustomerDao
import com.example.roomdemo.data.entities.Customer

@Database(entities = [Customer::class],version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun customerDao(): CustomerDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context) : AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java, "customers")
                    .build()
                INSTANCE = instance
                return instance
            }
        }

    }//companion object

}//database