package com.example.appcondominio

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReservaAdapter(private val reservas: List<String>) : RecyclerView.Adapter<ReservaAdapter.ReservaViewHolder>(){



    class ReservaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val item: TextView = itemView.findViewById(R.id.txtReserva)

    }

    override fun onCreateViewHolder(
        p0: ViewGroup,
        p1: Int
    ): ReservaViewHolder {
        val view = LayoutInflater.from(p0.context)
            .inflate(R.layout.item_reserva, p0, false)
        return ReservaViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReservaViewHolder, p1: Int) {
        val item = reservas[p1]
        holder.item.text = item


    }

    override fun getItemCount(): Int {
      return reservas.size
    }
}