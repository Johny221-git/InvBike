package com.example.invbikev1

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity

class Zlecenia : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ekran_zelcenia)
    }


    fun ButtonOut(view: View?){
        var PrzejscieOUT = Intent(
            this,
            MainActivity::class.java)
        startActivity(PrzejscieOUT)
    }

}

