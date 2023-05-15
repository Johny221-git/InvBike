package com.example.invbike

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
/*
private lateinit var binding: ActivityMainBinding
lateinit var username : EditText
lateinit var password: EditText
lateinit var loginButton: Button */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //    FirebaseFirestore firestone;

    fun OnClickButton2(view: View) { //akcja przejscia ekranu
        var przejscie = Intent(
            this,
            ekran_wyszukiwania::class.java)
        startActivity(przejscie)
    }


/*
        binding.loginButton.setOnClickListener(View.OnClickListener {
            if (binding.username.text.toString() == "admin" && binding.password.text.toString() == "123"){
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
            }
        })
*/


}