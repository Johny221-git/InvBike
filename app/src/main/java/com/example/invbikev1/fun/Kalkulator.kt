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

    fun ButtonLicz(view: View?) {

        val pisz = findViewById<TextView>(R.id.textViewRozmiar)
        val wartoscA = findViewById<EditText>(R.id.editTextDA).text.toString().toInt()
        val wartoscB = findViewById<EditText>(R.id.editTextDB).text.toString().toInt()
        val wartoscC = findViewById<EditText>(R.id.editTextDC).text.toString().toInt()
        val radioMen = findViewById<RadioButton>(R.id.radioButton).isChecked

        var plec = "K"
        if (radioMen) {
            plec = "M"

        }

        val suma = matematyka().liczenie(wartoscA,wartoscB,wartoscC,plec)
        pisz.setText(suma.toString())
    }

}
