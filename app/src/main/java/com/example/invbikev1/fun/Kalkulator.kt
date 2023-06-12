package com.example.invbikev1.`fun`

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.invbikev1.Itemy.Wyszukiwania
import com.example.invbikev1.R
import com.example.invbikev1.ekranStarotwy.MainActivity

class Kalkulator : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ekran_kalkulator)
    }

    fun ButtonOut(view: View?) {
        // Tworzenie nowego zamiaru (Intent) w celu przejścia do MainActivity
        val przejscieOUT = Intent(
            this,
            MainActivity::class.java)
        // Uruchamianie aktywności z użyciem utworzonego zamiaru
        startActivity(przejscieOUT)
    }

    fun ButtonBack(view: View?){
        var PrzejscieBack = Intent(
            this,
            Wyszukiwania::class.java)
        startActivity(PrzejscieBack)
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

        // Sprawdzenie, który RadioButton został zaznaczony
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

        // Obliczenie wartości sizeA, sizeB i sizeC na podstawie wprowadzonych danych
        var sizeA = mod + (intwA - 64) / 4 //ogolna
        var sizeB = intwB / sizeA //nogi
        var sizeC = intwC / sizeA //tolw

        // Sprawdzenie warunków dotyczących sizeB i sizeC oraz ustawienie wartości dla zmiennej suma
        if(sizeB < 0.55 || sizeC < 0.48){
            suma = sizeA - 2
            pisz.setText("${suma}")
        } else if (sizeB > 0.59 || sizeC > 0.52) {
            suma = sizeA + 2
            pisz.setText("${suma}")
        } else {
            suma = sizeA
            pisz.setText("${suma}")
        }

        return suma
    }

}
