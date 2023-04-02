package com.example.invbike

import androidx.room.*

@Entity //obiekty
data class Produkty(
    @PrimaryKey val Name: String, //pierwsza kolumna takiego jakby id plikow do ktorych w nastepnych kolumnach przypisane beda wartosci
    @ColumnInfo(name = "ID") val ID: Int?, //kolumna zmiennej ww w ktorej beda te wartosci w formie inta
    @ColumnInfo(name = "Nazwa_produktu") val Prod: Int?,

)

@Dao //sposob dzialania takie komenty zapytan
interface ProduktyDao {
    @Query("SELECT * FROM produkty")
    fun getAll(): List<Produkty> //wczytuje wszystko z list playercart

    @Query("SELECT * FROM produkty WHERE name = :name limit 1")
    fun findByName(name: String): Produkty //znajduje dane wartosci z listy

    @Insert
    fun insert(cart: Produkty) //zapisuje liste wartosci

    @Delete
    fun delete(cart: Produkty) //usuwa liste wartosci
}

@Database(entities = [Produkty::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun produktyDao(): ProduktyDao
}