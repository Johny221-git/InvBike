package com.example.invbikev1.ekranStarotwy

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.invbikev1.R
import com.example.invbikev1.Itemy.Wyszukiwania
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {


    private val fbAuth = FirebaseAuth.getInstance() //inicjalizacja autoryzacji kont firebase
    private val LOG_DEUBG = "LOG_DEBUG" //znacznik debugu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun ButtonMAEW(view: View?) {
        // Pobieranie referencji do pól tekstowych emailLoginInput i passLoginInput
        val email = findViewById<EditText>(R.id.emailLoginInput)
        val pass = findViewById<EditText>(R.id.passLoginInput)

        // Pobieranie wartości wprowadzonych przez użytkownika z pól tekstowych
        val e = email.text.toString().trim() //trim obcina spacje
        val p = pass.text.toString()

        // Logika logowania użytkownika przy użyciu podanych danych
        fbAuth.signInWithEmailAndPassword(e, p)
            .addOnSuccessListener { authRes ->
                // Sprawdzenie, czy logowanie powiodło się poprzez weryfikację obiektu użytkownika
                if (authRes.user != null)  Przejscie() // Wywołanie metody Przejscie() w przypadku poprawnego logowania
            }
            .addOnFailureListener { exc ->
                // Obsługa nieudanego logowania
                Toast.makeText(this, "złe logowanie", Toast.LENGTH_LONG).show()
                Log.d(LOG_DEUBG, exc.message.toString())
            }
    }

    private fun Przejscie() {
        val PrzejscieMAEW = Intent(
            this,
            Wyszukiwania::class.java)
        startActivity(PrzejscieMAEW)
    }

/*
        var PrzejscieMAEW = Intent(
            this,
            Wyszukiwania::class.java)
        startActivity(PrzejscieMAEW)

 */
    fun ButtonHelp(view: View?){

        Toast.makeText(this,
            "NIE MA POMOCY", Toast.LENGTH_LONG).show()

}


}








