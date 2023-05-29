package com.example.invbikev1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {
    private lateinit var fbAuth: FirebaseAuth;



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


    override fun onStart() {
        super.onStart()
        isCurrentUser()
    }

    private fun isCurrentUser() {

        fbAuth.currentUser?.let { auth ->
            val intent = Intent(applicationContext, MainActivity::class.java).apply {
                flags = (Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            }
            startActivity(intent)
        }
    }


}



