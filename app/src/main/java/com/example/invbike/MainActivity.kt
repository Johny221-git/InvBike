package com.example.invbike

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun OnClickButton2(view: View) { //akcja przejscia ekranu
        var przejscie = Intent(
            this,
            ekran_wyszukiwania::class.java)
        startActivity(przejscie)
    }

}