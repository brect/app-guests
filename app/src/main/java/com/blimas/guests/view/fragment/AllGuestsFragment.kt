package com.blimas.guests.view.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blimas.guests.R
import com.blimas.guests.service.constants.GuestConstants
import com.blimas.guests.service.model.GuestModel
import com.blimas.guests.view.activity.GuestFormActivity
import com.blimas.guests.view.adapter.GuestAdapter
import com.blimas.guests.view.listener.GuestListener
import com.blimas.guests.viewmodel.GuestsViewModel

class AllGuestsFragment : Fragment() {

    private lateinit var mViewModel: GuestsViewModel
    private val mAdapter: GuestAdapter = GuestAdapter()
    private lateinit var mListener: GuestListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        mViewModel =
            ViewModelProvider(this).get(GuestsViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_all, container, false)

        val recycler = root.findViewById<RecyclerView>(R.id.recycler_all_guests)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = mAdapter

        mListener = object: GuestListener {
            override fun onClickListener(id: Int) {

                val intent = Intent(context, GuestFormActivity::class.java)

                val bundle = Bundle()
                bundle.putInt(GuestConstants.GUEST_ID, id)

                intent.putExtras(bundle)

                startActivity(intent)
            }

            override fun onLongClickListener(id: Int) {
                mViewModel.deleteGuest(id)
                mViewModel.load(GuestConstants.FILTER.EMPTY)
            }
        }

        mAdapter.attachListener(mListener)
        observe()

        mViewModel.load(GuestConstants.FILTER.EMPTY)

        return root
    }

    override fun onResume() {
        super.onResume()
        mViewModel.load(GuestConstants.FILTER.EMPTY)
    }

    private fun observe() {
        mViewModel.guestList.observe(viewLifecycleOwner, Observer {
            mAdapter.updateGuests(it)
        })
    }
}