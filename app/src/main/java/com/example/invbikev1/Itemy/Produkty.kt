package com.example.invbikev1.Itemy

import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.DocumentReference

data class Produkty(
    @DocumentId val id: String? = null,
    var Ilosc: Int? = null,
    var Opis: String? = null,
    var Typ: DocumentReference? = null,
    var TypRoweru: DocumentReference? = null,
    var TypStrig: String = "",
    var TypRoweruStrig: String = ""
) {
    override fun toString(): String {
        return id + ",Ilosc:" + Ilosc + ",Opis:" + Opis + "," + TypStrig + "," + TypRoweruStrig
    }
}
// miejsce na wyświetlanie danych z firebase