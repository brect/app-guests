package com.blimas.guests.view.listener

import com.blimas.guests.service.model.GuestModel

interface GuestListener {
    fun onClickListener(id: Int)
    fun onLongClickListener(id: Int)
}