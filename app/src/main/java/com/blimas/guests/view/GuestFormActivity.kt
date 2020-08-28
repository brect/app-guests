package com.blimas.guests.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.blimas.guests.R
import com.blimas.guests.viewmodel.GuestFormViewModel

class GuestFormActivity : AppCompatActivity() , View.OnClickListener{

    private lateinit var mViewModel: GuestFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_form)

        mViewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        setListners()
    }

    private fun setListners() {

    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.button_save){

        }
    }
}