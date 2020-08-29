package com.blimas.guests.service.repository

import androidx.room.*
import com.blimas.guests.service.model.GuestModel

@Dao
interface GuestDAO {

    @Insert
    fun save(guest: GuestModel): Long

    @Update
    fun update(guest: GuestModel): Int

    @Delete
    fun delete(guest: GuestModel)

    @Query("SELECT * FROM Guest WHERE id = :id")
    fun getGuest(id: Int): GuestModel

    @Query("SELECT * FROM Guest")
    fun getAll(): List<GuestModel>

    @Query("SELECT id, name, presence FROM Guest WHERE presence = 1")
    fun getPresent(): List<GuestModel>

    @Query("SELECT id, name, presence FROM Guest WHERE presence = 0")
    fun getAbsent(): List<GuestModel>

}