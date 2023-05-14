package com.example.invbike

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class koszytk_lista_zyczen : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.koszytk_lista_zyczen)
        title = "EkranLogowania"
        val button4:Button = findViewById(R.id.button4)
        button4.setOnClickListener{
            val intent = Intent(this, ekran_wyszukiwania::class.java )
            startActivity(intent)
        }
        val button7:Button = findViewById(R.id.button7)
        button7.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java )
            startActivity(intent)
        }
    }
}