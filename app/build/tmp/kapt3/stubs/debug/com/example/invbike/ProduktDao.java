package com.example.invbike;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\'J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\'J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\f"}, d2 = {"Lcom/example/invbike/ProduktDao;", "", "delete", "", "cart", "Lcom/example/invbike/Produkt;", "findByName", "name", "", "getAll", "", "insert", "app_debug"})
public abstract interface ProduktDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM produkt")
    public abstract java.util.List<com.example.invbike.Produkt> getAll();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM produkt WHERE name = :name limit 1")
    public abstract com.example.invbike.Produkt findByName(@org.jetbrains.annotations.NotNull()
    java.lang.String name);
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.example.invbike.Produkt cart);
    
    @androidx.room.Delete()
    public abstract void delete(@org.jetbrains.annotations.NotNull()
    com.example.invbike.Produkt cart);
}