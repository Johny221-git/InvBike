package com.example.invbikev1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
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

    fun ButtonLicz(view: View?): Int {
        var mod = 0
        var pisz = findViewById<TextView>(R.id.textViewRozmiar)
        var wartoscA = findViewById<EditText>(R.id.editTextDA)
        var wartoscB = findViewById<EditText>(R.id.editTextDB)
        var wartoscC = findViewById<EditText>(R.id.editTextDC)
        var radioMen = findViewById<RadioButton>(R.id.radioButton)
        var radioWom = findViewById<RadioButton>(R.id.radioButton2)
        var suma = 0

        if(radioMen.isChecked) {
            mod = 18
        }

        if(radioWom.isChecked) {
            mod = 16
        }

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


        var sizeA = mod + (intwA - 64)/4 //ogolna
        var sizeB = intwB/sizeA //nogi
        var sizeC = intwC/sizeA //tolw


        if(sizeB < 0.55 || sizeC < 0.48){
            suma = sizeA - 2
            pisz.setText("${suma}")
        } else (if (sizeB > 0.59 || sizeC > 0.52) {
                suma = sizeA + 2
                pisz.setText("${suma}")
            } else {
                suma = sizeA
                pisz.setText("${suma}")
            })

        return suma
    }
}
