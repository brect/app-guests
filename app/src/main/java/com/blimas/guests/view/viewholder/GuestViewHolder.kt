package com.blimas.guests.view.viewholder

import android.app.AlertDialog
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.blimas.guests.R
import com.blimas.guests.service.model.GuestModel
import com.blimas.guests.view.listener.GuestListener

class GuestViewHolder(itemView: View, private val listener: GuestListener) : RecyclerView.ViewHolder(itemView) {

    fun bind(guest: GuestModel) {
        val textName = itemView.findViewById<TextView>(R.id.text_name)
        textName.text = guest.name

        textName.setOnClickListener{
            listener.onClickListener(guest.id)
        }

        textName.setOnLongClickListener {
            showDialog(guest.id)
            true
        }
    }

    private fun showDialog(id: Int) {
        AlertDialog.Builder(itemView.context)
            .setTitle(R.string.remocao_convidado)
            .setMessage(R.string.deseja_remover)
            .setPositiveButton(R.string.remover) { dialog, which ->
                listener.onLongClickListener(id)
            }
            .setNegativeButton(R.string.cancelar, null)
            .show()
    }
}
