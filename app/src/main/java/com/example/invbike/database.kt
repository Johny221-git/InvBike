package com.example.invbike

import androidx.room.*

@Entity //obiekty
data class Produkt(
    @PrimaryKey val Name: String, //pierwsza kolumna takiego jakby id plikow do ktorych w nastepnych kolumnach przypisane beda wartosci
    @ColumnInfo(name = "nazwa") val N: Int?, //kolumna zmiennej nazwy w ktorej beda te wartosci w formie wartości INT

)

@Dao //sposob dzialania takie komenty zapytan
interface ProduktDao {
    @Query("SELECT * FROM produkt")
    fun getAll(): List<Produkt> //wczytuje wszystko z list playercart

    @Query("SELECT * FROM produkt WHERE name = :name limit 1")
    fun findByName(name: String): Produkt //znajduje dane wartosci z listy

    @Insert
    fun insert(cart: Produkt) //zapisuje liste wartosci

    @Delete
    fun delete(cart: Produkt) //usuwa liste wartosci
}

@Database(entities = [Produkt::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun produktDao(): ProduktDao
}