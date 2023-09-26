package com.example.earthquakemonitor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.earthquakemonitor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.eqRecycler.layoutManager = LinearLayoutManager(this)

        val eqList = mutableListOf<Earthquake>()

        eqList.add(Earthquake("1", "Buenos Aires", 4.3, 2938984989L, -234.55335,28.57576))
        eqList.add(Earthquake("2", "Santiago", 2.3, 7898984989L, -234.55335,28.57576))
        eqList.add(Earthquake("3", "Lima", 3.1, 3458984989L, -234.55335,28.57576))
        eqList.add(Earthquake("4", "Cancun", 1.4, 79897984989L, -234.55335,28.57576))
        eqList.add(Earthquake("5", "Nuevo Leon", 3.3, 45984989L, -234.55335,28.57576))
        eqList.add(Earthquake("6", "Santiago", 2.2, 8838984989L, -234.55335,28.57576))
        eqList.add(Earthquake("7", "Montevideo", 4.3, 1248984989L, -234.55335,28.57576))

        val adapter= EqAdapter()
        binding.eqRecycler.adapter = adapter
        adapter.submitList(eqList)

        adapter.onItemClickListener = {
            Toast.makeText(this, it.place, Toast.LENGTH_SHORT).show()
        }

        if (eqList.isEmpty()){
            binding.eqEmptyView.visibility  = View.VISIBLE
        }else{
            binding.eqEmptyView.visibility = View.GONE
        }




    }
}