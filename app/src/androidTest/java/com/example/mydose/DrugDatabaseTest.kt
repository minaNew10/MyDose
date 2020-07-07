package com.example.mydose

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.mydose.data.Drug
import com.example.mydose.data.DrugDao
import com.example.mydose.data.DrugDatabase
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


@RunWith(AndroidJUnit4::class)
class DrugDatabaseTest {

    private lateinit var drugDao: DrugDao
    private lateinit var db : DrugDatabase

    @Before
    fun createDb(){
        val context =  InstrumentationRegistry.getInstrumentation().targetContext
        db = Room.inMemoryDatabaseBuilder(context, DrugDatabase::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        drugDao = db.drugDao
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetTask(){
        val drug = Drug()
        //the id is assigned by Auto generation
        var id = drugDao.insert(drug)
        drug.drugId = id
        val returnedDrug = drugDao.getLastDrug()
        assertEquals(returnedDrug, drug)
    }
}