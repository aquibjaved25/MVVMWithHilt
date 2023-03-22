package com.mvvmdaggercheezycode.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mvvmdaggercheezycode.models.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class FakerDB : RoomDatabase() {

    abstract fun getFakerDao(): FakerDAO

}