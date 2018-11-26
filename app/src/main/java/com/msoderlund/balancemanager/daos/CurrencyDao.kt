package com.msoderlund.balancemanager.daos

import androidx.room.*
import com.msoderlund.balancemanager.entities.Currency
import com.msoderlund.balancemanager.entities.ExpenseLabel
import com.msoderlund.balancemanager.entities.MoneyAccount

@Dao
interface CurrencyDao {
    @Insert
    fun insert(currency: Currency)

    @Update
    fun update(currency: Currency)

    @Delete
    fun delete(currency: Currency)

    @Query("SELECT * from currency")
    fun getCurrencies(): List<Currency>
}