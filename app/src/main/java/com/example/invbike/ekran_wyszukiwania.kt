package com.example.invbike
https:// DATABASE_NAME . InvBike .europe-west1.firebasedatabase.app
import com.google.firebase.ktx.Firebase

class ekran_wyszukiwania {
    // Write a message to the database
    val database = Firebase.database
    val myRef = database.getReference("message")

    myRef.setValue("Hello, World!")


}