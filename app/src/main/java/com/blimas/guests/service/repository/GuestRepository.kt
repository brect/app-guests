package com.blimas.guests.service.repository

import android.content.Context
import com.blimas.guests.service.model.GuestModel
import java.lang.Exception

class GuestRepository constructor(context: Context) {

    private var mDataBase = GuestDataBase.getDatabase(context).guestDAO()

    fun save(guest: GuestModel): Boolean {
        return mDataBase.save(guest) > 0
    }

    fun getGuestById(id: Int): GuestModel? {
        return mDataBase.getGuest(id)
    }

    fun getAll(): List<GuestModel> {
        return mDataBase.getAll()
    }

    fun getPresent(): List<GuestModel> {
        return mDataBase.getPresent()
    }

    fun getAbsent(): List<GuestModel> {
        return mDataBase.getAbsent()
    }

    fun update(guest: GuestModel): Boolean {
        return mDataBase.update(guest) > 0
    }

    fun delete(guest: GuestModel) {
        mDataBase.delete(guest)
    }
}