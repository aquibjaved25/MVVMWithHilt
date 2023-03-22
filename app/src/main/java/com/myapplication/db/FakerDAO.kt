package com.mvvmdaggercheezycode.db

import androidx.room.Dao
import androidx.room.*
import com.mvvmdaggercheezycode.models.Product

@Dao
interface FakerDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(products: List<Product>)

    @Query("SELECT * FROM Product")
    suspend fun getProducts() : List<Product>

}