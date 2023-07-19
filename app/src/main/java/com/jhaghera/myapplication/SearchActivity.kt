package com.jhaghera.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SearchActivity : AppCompatActivity() {

    private lateinit var searchEditText: EditText
    private lateinit var searchButton: Button
    private lateinit var medicineRecyclerView: RecyclerView

    private lateinit var medicineList: List<Medicine>
    private lateinit var medicineAdapter: MedicineAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        searchEditText = findViewById(R.id.searchEditText)
        searchButton = findViewById(R.id.searchButton)
        medicineRecyclerView = findViewById(R.id.medicineRecyclerView)

        medicineList = createMedicineList()
        medicineAdapter = MedicineAdapter(medicineList)

        medicineRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@SearchActivity)
            adapter = medicineAdapter
        }

        searchButton.setOnClickListener {
            val medicineId = searchEditText.text.toString()
            val filteredList = medicineList.filter { it.name.contains(medicineId, ignoreCase = true) }
            medicineAdapter.updateData(filteredList)
        }
    }

    private fun createMedicineList(): List<Medicine> {
        val medicines = mutableListOf<Medicine>()

        // Add sample medicines
        medicines.add(
            Medicine("Medicine1", "10mg", "Manufacturer A", "2023-12-31", 9.99, 50, "Pharmacy A")
        )
        medicines.add(
            Medicine("Medicine1", "10mg", "Manufacturer A", "2023-12-31", 9.99, 50, "Pharmacy A")
        )
        medicines.add(
            Medicine("Medicine1", "10mg", "Manufacturer A", "2023-12-31", 9.99, 50, "Pharmacy A")
        )
        medicines.add(
            Medicine("Medicine2", "5mg", "Manufacturer B", "2022-10-15", 19.99, 20, "Pharmacy B")
        )
        medicines.add(
            Medicine("Medicine3", "20mg", "Manufacturer C", "2024-06-30", 14.99, 100, "Pharmacy C")
        )

        return medicines
    }
}



