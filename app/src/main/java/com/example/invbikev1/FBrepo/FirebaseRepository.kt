package com.example.invbikev1.FBrepo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.invbikev1.Itemy.Produkty
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

class FirebaseRepository {

    private val REPO_DEBUG = "REPO_DEBUG" //znacznik debugu


    private val auth = FirebaseAuth.getInstance()// inicjalizacja firebase czesci do autoryzacji konta
    private val cloud = FirebaseFirestore.getInstance() // inicjalizacja firebasestore pod robienie zleceń i przedmiotów

    fun getProdukty(): LiveData<List<Produkty>> {
        val cloudResult = MutableLiveData<List<Produkty>>() // Tworzenie MutableLiveData, które będzie przechowywać listę obiektów typu Produkty

        cloud.collection("Produkty") // Pobranie referencji do kolekcji "Produkty" w Firestore
            .get() // Wywołanie metody get() w celu pobrania danych z kolekcji
            .addOnSuccessListener { dokument ->
                if (dokument != null) {
                    for (d in dokument) {
                        Log.d("cokowiek", d.data.toString()) // Wyświetlanie danych dokumentu w logach debugowania
                    }
                }
                // Konwertowanie dokumentów na listę obiektów typu Produkty

                //val user = it.toObjects(Produkty::class.java)
                //cloudResult.postValue(user) // Przypisanie przekonwertowanej listy do cloudResult
            }
            .addOnFailureListener {
                Log.d(REPO_DEBUG, it.message.toString()) // Wyświetlanie komunikatu o błędzie w logach debugowania w przypadku niepowodzenia pobrania danych
            }
        return cloudResult // Zwracanie MutableLiveData jako wynik metody
    }

    fun getFavCars(list: List<String>?): LiveData<List<Produkty>> {
        val cloudResult = MutableLiveData<List<Produkty>>()

        // Sprawdzenie, czy lista nie jest pusta ani nullowa
        if (!list.isNullOrEmpty()) {
            // Pobranie referencji do kolekcji "Przedmioty" z bazy Firestore
            cloud.collection("Przedmioty")
                // Wybierz tylko dokumenty, których pole "id" znajduje się w liście
                .whereIn("id", list)
                // Wykonaj zapytanie do bazy Firestore
                .get()
                .addOnSuccessListener {
                    // Konwersja rezultatu zapytania na listę obiektów typu Produkty
                    val resultList = it.toObjects(Produkty::class.java)
                    // Umieszczenie wyniku w obiekcie MutableLiveData
                    cloudResult.postValue(resultList)
                }
                .addOnFailureListener {
                    // Obsługa błędu w przypadku niepowodzenia zapytania
                    Log.d(REPO_DEBUG, it.message.toString())
                }
        }
        // Zwrócenie obiektu MutableLiveData, który przechowuje wynik zapytania
        return cloudResult
    }

    fun addZleceniaProdukty(Produkty: Produkty) {
        // Dodawanie ID produktu do tablicy "ZleceniaPracownika" w dokumencie o ID użytkownika
        cloud.collection("Zlecenia")
            .document(auth.currentUser?.uid!!)
            .update("ZleceniaPracownika", FieldValue.arrayUnion(Produkty.id))
            .addOnSuccessListener {
                // Obsługa sukcesu - zapisanie informacji do dziennika logów
                Log.d(REPO_DEBUG, "Dodano do zlecen")
            }
            .addOnFailureListener {
                // Obsługa niepowodzenia - zapisanie komunikatu o błędzie w dzienniku logów
                Log.d(REPO_DEBUG, it.message.toString())
            }
    }

    fun removeZleceniaProdukty(Produkty: Produkty) {
        // Usuwanie ID produktu z tablicy "ZleceniaPracownika" w dokumencie o ID użytkownika
        cloud.collection("Zlecenia")
            .document(auth.currentUser?.uid!!)
            .update("ZleceniaPracownika", FieldValue.arrayRemove(Produkty.id))
            .addOnSuccessListener {
                // Obsługa sukcesu - zapisanie informacji do dziennika logów
                Log.d(REPO_DEBUG, "Usunięto z zleceń")
            }
            .addOnFailureListener {
                // Obsługa niepowodzenia - zapisanie komunikatu o błędzie w dzienniku logów
                Log.d(REPO_DEBUG, it.message.toString())
            }
    }








}