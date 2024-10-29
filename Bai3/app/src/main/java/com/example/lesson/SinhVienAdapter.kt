package com.example.lesson

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SinhVienAdapter(private var sinhVienList: List<SinhVien>) :
    RecyclerView.Adapter<SinhVienAdapter.SinhVienViewHolder>() {

    class SinhVienViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val hoTenTextView: TextView = itemView.findViewById(R.id.hoTenTextView)
        val mssvTextView: TextView = itemView.findViewById(R.id.mssvTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SinhVienViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.student_item, parent, false)
        return SinhVienViewHolder(view)
    }

    override fun onBindViewHolder(holder: SinhVienViewHolder, position: Int) {
        val sinhVien = sinhVienList[position]
        holder.hoTenTextView.text = sinhVien.hoTen
        holder.mssvTextView.text = sinhVien.mssv
    }

    override fun getItemCount(): Int = sinhVienList.size

    fun updateList(newList: List<SinhVien>) {
        sinhVienList = newList
        notifyDataSetChanged()
    }
}
