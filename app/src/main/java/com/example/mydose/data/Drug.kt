package com.example.mydose.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
@Entity(tableName = "drug_table")
data class Drug(
    @PrimaryKey(autoGenerate = true)
    var drugId: Long = 0L,
    var name: String = "",
    var firstDoseDate: Long? = null,
    var firstDoseTime: Long? = null,
    var period : Long? = null,
    var noOfDoses : Int = 0,
    var intervals : Long? = null,
    var completed :Boolean = false,
    var doctor: String = ""
)