package com.example.invbikev1.Itemy

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import com.example.invbikev1.FBrepo.FirebaseRepository
import com.example.invbikev1.`fun`.Kalkulator
import com.example.invbikev1.R
import com.example.invbikev1.ekranStarotwy.MainActivity

class Wyszukiwania : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ekran_wyszukiwania)

        val test = FirebaseRepository().getProdukty().value // zmienna do testowania czy poprawinie zasysa produkty z FireBase



    }

    fun ButtonWZ(view: View?){
        var PrzejscieWZ = Intent(
            this,
            Zlecenia::class.java)
        startActivity(PrzejscieWZ)
    }


    fun ButtonWK(view: View?){
        var PrzejscieWK = Intent(
            this,
            Kalkulator::class.java)
        startActivity(PrzejscieWK)
    }

    fun ButtonOut(view: View?){
        var PrzejscieOUT = Intent(
            this,
            MainActivity::class.java)
        startActivity(PrzejscieOUT)
    }


}
