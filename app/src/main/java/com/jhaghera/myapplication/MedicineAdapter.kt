package com.jhaghera.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MedicineAdapter(private var medicineList: List<Medicine>) :
    RecyclerView.Adapter<MedicineAdapter.MedicineViewHolder>() {

    inner class MedicineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val medicineNameTextView: TextView = itemView.findViewById(R.id.medicineNameTextView)
        private val dosageTextView: TextView = itemView.findViewById(R.id.dosageTextView)
        private val storeNameTextView: TextView = itemView.findViewById(R.id.storeNameTextView)
        private val manufacturerNameTextView: TextView = itemView.findViewById(R.id.manufacturerNameTextView)
        private val enquireButton: Button = itemView.findViewById(R.id.enquireButton)

        fun bind(medicine: Medicine) {
            medicineNameTextView.text = medicine.name
            dosageTextView.text = medicine.dosage
            storeNameTextView.text = medicine.pharmacy
            manufacturerNameTextView.text = medicine.manufacturer

            enquireButton.setOnClickListener {
                // Handle enquire button click
                // You can perform any necessary action here, such as starting an activity or displaying a dialog
                // For example: startActivity(Intent(context, EnquiryActivity::class.java))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicineViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_medicine, parent, false)
        return MedicineViewHolder(view)
    }

    override fun onBindViewHolder(holder: MedicineViewHolder, position: Int) {
        val medicine = medicineList[position]
        holder.bind(medicine)
    }

    override fun getItemCount(): Int {
        return medicineList.size
    }

    fun updateData(newList: List<Medicine>) {
        medicineList = newList
        notifyDataSetChanged()
    }
}
