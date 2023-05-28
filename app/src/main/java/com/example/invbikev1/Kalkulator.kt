package com.example.invbikev1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity

class Kalkulator : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ekran_kalkulator)
    }

    fun ButtonOut(view: View?){
        var PrzejscieOUT = Intent(
            this,
            MainActivity::class.java)
        startActivity(PrzejscieOUT)
    }

    fun ButtonLicz(view: View?){

        var pisz = findViewById<TextView>(R.id.textViewRozmiar)
        var wartoscA = findViewById<EditText>(R.id.editTextDA)
        var wartoscB = findViewById<EditText>(R.id.editTextDB)
        var wartoscC = findViewById<EditText>(R.id.editTextDC)

        var wA = wartoscA.text.toString()
        var wB = wartoscB.text.toString()
        var wC = wartoscC.text.toString()

        var intwA = 0
        if (wA != "") {
            intwA = wA.toInt()
        }

        var intwB = 0
        if (wB != "") {
            intwB = wB.toInt()
        }

        var intwC = 0
        if (wC != "") {
            intwC = wC.toInt()
        }


        var suma = intwA + intwB + intwC

        pisz.setText("${suma}")

    }


}
