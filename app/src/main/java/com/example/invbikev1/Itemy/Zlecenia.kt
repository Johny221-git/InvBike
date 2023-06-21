package com.example.invbikev1.Itemy

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.ComponentActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.invbikev1.FBrepo.FirebaseRepository
import com.example.invbikev1.R
import com.example.invbikev1.ekranStarotwy.MainActivity

class Zlecenia : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ekran_zelcenia)

        FirebaseRepository().getZlecenia().observe(this) { zlecenia ->
            val spinner = findViewById<Spinner>(R.id.Spinner3)
            if (spinner != null) {
                val adapter = ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_item, zlecenia
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

                    }
                }
            }
        }
    }

    fun ButtonOut(view: View?) {
        val PrzejscieOUT = Intent(
            this,
            MainActivity::class.java
        )
        startActivity(PrzejscieOUT)
    }

    fun ButtonBack(view: View?) {
        val PrzejscieBack = Intent(
            this,
            Wyszukiwania::class.java
        )
        startActivity(PrzejscieBack)
    }
}