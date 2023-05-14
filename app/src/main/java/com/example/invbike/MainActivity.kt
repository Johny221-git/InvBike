package com.example.invbike

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    fun button_login(view: View) {
        var przejscie = Intent(
            this,
            ekran_wyszukiwania::class.java)
        startActivity(przejscie) }
}


/*class MainActivity : AppCompatActivity() {
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

 */
