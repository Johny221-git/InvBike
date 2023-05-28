package com.example.invbikev1

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity

class Wyszukiwania : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ekran_wyszukiwania)
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
