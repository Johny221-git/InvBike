package com.example.invbikev1.Itemy

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import com.example.invbikev1.R
import com.example.invbikev1.ekranStarotwy.MainActivity

class Zlecenia : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ekran_zelcenia)
    }

    fun ButtonOut(view: View?){
        val PrzejscieOUT = Intent(
            this,
            MainActivity::class.java)
        startActivity(PrzejscieOUT)
    }

    fun ButtonBack(view: View?){
        val PrzejscieBack = Intent(
            this,
            Wyszukiwania::class.java)
        startActivity(PrzejscieBack)
    }

    private val zleceniaList = ArrayList<Produkty>()

    // Metoda ta ustawia listę produktów i aktualizuje zleceniaList
    fun setProdukty(list: List<Produkty>){
        zleceniaList.clear() // Czyści poprzednią listę zleceniaList
        zleceniaList.addAll(list) // Dodaje nową listę produktów do zleceniaList
        //notifyDataSetChanged() // Aktualizuje widok RecyclerView TO DO ZROBIĆ MIEJSCE DO WYSWIETLANIA!!!!
    }
}

