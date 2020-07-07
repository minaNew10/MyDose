package com.example.mydose.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Drug::class],version = 1,exportSchema = false)
abstract class DrugDatabase : RoomDatabase(){
    abstract val drugDao: DrugDao
    companion object{
        @Volatile
        private var INSTANCE: DrugDatabase? = null
        fun getInstance(context: Context): DrugDatabase{
            synchronized(this){
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DrugDatabase::class.java,
                        "sleep_history_database").fallbackToDestructiveMigration().build()
                         INSTANCE = instance
                }
                return instance
            }
        }
    }
}