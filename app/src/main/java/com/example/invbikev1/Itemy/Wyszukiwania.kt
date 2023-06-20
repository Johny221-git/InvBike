package com.example.invbikev1.Itemy

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.invbikev1.FBrepo.FirebaseRepository
import com.example.invbikev1.`fun`.Kalkulator
import com.example.invbikev1.R
import com.example.invbikev1.ekranStarotwy.MainActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class Wyszukiwania : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ekran_wyszukiwania)

        FirebaseRepository().getProdukty().observe(this) { produkty ->
            val spinner = findViewById<Spinner>(R.id.Spinner1)
            if (spinner != null) {
                val adapter = ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_item, produkty
                )
                spinner.adapter = adapter

                spinner.onItemSelectedListener = object :
                    AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>,
                        view: View, position: Int, id: Long
                    ) {
                      
                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {
                        // write code to perform some action

                    }
                }
            }
        }
    }

    fun ButtonWZ(view: View?) {
        val PrzejscieWZ = Intent(
            this,
            Zlecenia::class.java
        )
        startActivity(PrzejscieWZ)
    }

    fun ButtonWK(view: View?) {
        val PrzejscieWK = Intent(
            this,
            Kalkulator::class.java
        )
        startActivity(PrzejscieWK)
    }

    fun ButtonOut(view: View?) {
        val PrzejscieOUT = Intent(
            this,
            MainActivity::class.java
        )
        startActivity(PrzejscieOUT)
    }

}
