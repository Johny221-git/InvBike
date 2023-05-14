package com.example.invbike

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class ekran_wyszukiwania : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ekran_wyszukiwania)
        title = "EkranLogowania"
        val button5: Button = findViewById(R.id.button5)
        button5.setOnClickListener {
            val intent = Intent(this, koszytk_lista_zyczen::class.java)
            startActivity(intent)
        }
        val button6: Button = findViewById(R.id.button6)
        button6.setOnClickListener {
            val intent = Intent(this, kalkulator_ramy::class.java)
            startActivity(intent)

        }
        val button3:Button = findViewById(R.id.button3)
        button3.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java )
            startActivity(intent)
        }

    }
}