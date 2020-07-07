package com.example.mydose.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface DrugDao {
    @Insert
    fun insert(drug: Drug):Long

    @Update
    fun update(drug: Drug)

    @Query("SELECT * from drug_table WHERE drugId = :key")
    fun get(key: Long): Drug?

    @Query("DELETE FROM drug_table")
    fun clear()

    @Delete
    fun deleteDrugs(vararg drugs: Drug?)

    @Query("SELECT * FROM drug_table ORDER BY drugId DESC LIMIT 1")
    fun getLastDrug(): Drug?

    @Query("SELECT * FROM drug_table ORDER BY drugId DESC")
    fun getAllNights(): LiveData<List<Drug>>
}