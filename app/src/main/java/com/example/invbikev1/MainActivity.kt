package com.example.invbikev1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun ButtonMAEW(view: View?){
        var PrzejscieMAEW = Intent(
            this,
            Wyszukiwania::class.java)
        startActivity(PrzejscieMAEW)
    }

    fun ButtonHelp(view: View?){

        Toast.makeText(this, "NIE MA POMOCY", Toast.LENGTH_LONG).show()

    }

}
