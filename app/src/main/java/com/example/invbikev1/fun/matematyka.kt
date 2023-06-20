package com.example.invbikev1.`fun`

import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import com.example.invbikev1.R

class matematyka {

    fun liczenie(intwA:Int, intwB:Int, intwC:Int,plec:String): Int {
        var mod = 0

        var suma = 0

        // Sprawdzenie, który RadioButton został zaznaczony
        if(plec == "M") {
            mod = 18
        }

        if(plec == "K") {
            mod = 16
        }

        // Obliczenie wartości sizeA, sizeB i sizeC na podstawie wprowadzonych danych
        val sizeA = mod + (intwA - 64) / 4 //ogolna
        val sizeB = intwB / sizeA //nogi
        val sizeC = intwC / sizeA //tolw

        // Sprawdzenie warunków dotyczących sizeB i sizeC oraz ustawienie wartości dla zmiennej suma
        if(sizeB < 0.55 || sizeC < 0.48){
            suma = sizeA - 2
            return suma
        } else if (sizeB > 0.59 || sizeC > 0.52) {
            suma = sizeA + 2
            return suma
        } else {
            suma = sizeA
            return suma
        }
    }
}