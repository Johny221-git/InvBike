package com.example.invbike

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "EkranLogowania"
        val button2:Button = findViewById(R.id.button2)
        button2.setOnClickListener{
            val intent = Intent(this@MainActivity, ekran_wyszukiwania::class.java )
            startActivity(intent)
        }
    }
}