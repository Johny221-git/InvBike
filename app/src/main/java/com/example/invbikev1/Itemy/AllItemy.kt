package com.example.invbikev1.Itemy

import com.google.firebase.database.DatabaseReference
import java.lang.Exception
import kotlin.jvm.Throws

data class Produkty (val id: String? = null,
                val Ilosc: Int? = null,
                val Opis: String? = null,
                val Typkierownicy: DatabaseReference? = null,
                val Typroweru: DatabaseReference? = null)
// miejsce na wyświetlanie danych z firebase poki co  working in progess