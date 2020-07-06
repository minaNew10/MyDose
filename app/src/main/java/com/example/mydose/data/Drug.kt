package com.example.mydose.data

import java.util.*

data class Drug(
    var id: Long = 0L,
    var name: String = "",
    var startTime: Date? = null,
    var period : Long? = null,
    var endTime: Date? = null,
    var intervals : Long,
    var completed :Boolean = false,
    var doctor: String = ""
)