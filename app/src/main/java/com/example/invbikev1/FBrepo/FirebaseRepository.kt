package com.example.invbikev1.FBrepo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.invbikev1.Itemy.Produkty
import com.example.invbikev1.Itemy.ZleceniaTB
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseRepository {

    private val REPO_DEBUG = "REPO_DEBUG" //znacznik debugu
    private val auth =
        FirebaseAuth.getInstance()// inicjalizacja firebase czesci do autoryzacji konta
    private val cloud =
        FirebaseFirestore.getInstance() // inicjalizacja firebasestore pod robienie zleceń i przedmiotów

    fun getProdukty(): LiveData<List<Produkty>> {
        val cloudResult =
            MutableLiveData<List<Produkty>>() // Tworzenie MutableLiveData, które będzie przechowywać listę obiektów typu Produkty

        cloud.collection("Produkty") // Pobranie referencji do kolekcji "Produkty" w Firestore
            .get() // Wywołanie metody get() w celu pobrania danych z kolekcji
            .addOnSuccessListener { dokument ->
                if (dokument != null) {

                    val lista = mutableListOf<Produkty>()

                    for (d in dokument) {
                        val dok = d.toObject(Produkty::class.java)
                        lista.add(dok)
                        dok.Typ?.get()?.addOnSuccessListener { typ ->
                            dok.TypStrig = typ.id
                            cloudResult.postValue(lista)
                        }
                        dok.TypRoweru?.get()?.addOnSuccessListener { typ ->
                            dok.TypRoweruStrig = typ.id
                            cloudResult.postValue(lista)
                        }
                    }
                    cloudResult.postValue(lista)
                }
            }
            .addOnFailureListener {
                Log.d(
                    REPO_DEBUG,
                    it.message.toString()
                ) // Wyświetlanie komunikatu o błędzie w logach debugowania w przypadku niepowodzenia pobrania danych
            }
        return cloudResult // Zwracanie MutableLiveData jako wynik metody
    }

    fun getZlecenia(): LiveData<List<ZleceniaTB>> {
        val cloudResult =
            MutableLiveData<List<ZleceniaTB>>()

        cloud.collection("Zlecenia")
            .get()
            .addOnSuccessListener { dokument ->
                if (dokument != null) {

                    val lista = mutableListOf<ZleceniaTB>()

                    for (d in dokument) {
                        val dok = d.toObject(ZleceniaTB::class.java)
                        lista.add(dok)
                    }
                    cloudResult.postValue(lista)
                }
            }
            .addOnFailureListener {
                Log.d(
                    REPO_DEBUG,
                    it.message.toString()
                )
            }
        return cloudResult
    }


}