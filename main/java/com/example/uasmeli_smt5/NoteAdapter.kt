package com.example.uasmeli_smt5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.uasmeli_smt5.model.Note

class NoteAdapter(
    private val listItems: ArrayList<Note>,
    private val listener: NoteListener
): RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var textViewTitle = itemView.findViewById<TextView>(R.id.text_view_title)
        var textViewBody = itemView.findViewById<TextView>(R.id.text_view_body)
        var textViewnilai = itemView.findViewById<TextView>(R.id.text_view_nilai)
        var textViewketerangan = itemView.findViewById<TextView>(R.id.text_view_keterangan)
        var textViewjumlahksk = itemView.findViewById<TextView>(R.id.text_view_jumlahsks)
        var textViewhargasks = itemView.findViewById<TextView>(R.id.text_view_hargasks)
        var textViewtotal = itemView.findViewById<TextView>(R.id.text_view_total)

    }

    interface NoteListener{
        fun OnItemClicked(note: Note)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteAdapter.NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent,false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteAdapter.NoteViewHolder, position: Int) {
        val item = listItems[position]
        holder.textViewTitle.text = "Npm : ${item.npm}"
        holder.textViewBody.text = "Nama : ${item.nama}"
        holder.textViewnilai.text = "Nilai : ${item.nilai}"
        holder.textViewketerangan.text = "Keterangan : ${item.keterangan}"
        holder.textViewjumlahksk.text = "Jumlah SKS : ${item.jumlahsks}"
        holder.textViewhargasks.text = "Harga SKS : ${item.hargasks}"

        val jumlahsks = item.jumlahsks.toDoubleOrNull() ?: 0.0

        val hargasks = item.hargasks.toDoubleOrNull() ?: 0.0
        val result = jumlahsks * hargasks

        holder.textViewtotal.text = "Total: Rp. $result"
        holder.itemView.setOnClickListener {
            listener.OnItemClicked(item)
        }
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}