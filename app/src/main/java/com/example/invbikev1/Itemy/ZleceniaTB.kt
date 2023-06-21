package com.example.invbikev1.Itemy


import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.DocumentReference
import java.sql.Timestamp
import java.util.Date

data class ZleceniaTB (
    @DocumentId
        val id: String? = null,
        var DataZlozenia: Date? = null,
        var Uzytkownik: DocumentReference? = null,
        var Zawartosc: List<DocumentReference?>? = null, //to jest kurda array
)