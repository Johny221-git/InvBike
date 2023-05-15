package com.example.invbike

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class ekran_wyszukiwania : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ekran_wyszukiwania)
    }

    fun OnClickButton5(view: View) { //akcja przejscia ekranu
        var przejscie1 = Intent(
            this,
            koszytk_lista_zyczen::class.java)
        startActivity(przejscie1)
    }

    fun OnClickButton6(view: View) { //akcja przejscia ekranu
        var przejscie2 = Intent(
            this,
            kalkulator_ramy::class.java)
        startActivity(przejscie2)
    }

}