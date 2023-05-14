package com.example.invbike

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class kalkulator_ramy : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.kalkulator_ramy)
        title = "EkranLogowania"
        val button12: Button = findViewById(R.id.button12)
        button12.setOnClickListener {
            val intent = Intent(this, koszytk_lista_zyczen::class.java)
            startActivity(intent)
        }
        val button10:Button = findViewById(R.id.button10)
        button10.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java )
            startActivity(intent)
        }
    }

}