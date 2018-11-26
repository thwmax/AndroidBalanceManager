package com.msoderlund.balancemanager.daos

import androidx.room.*
import com.msoderlund.balancemanager.entities.MoneyAccount

@Dao
interface MoneyAccountDao {
    @Insert
    fun insert(moneyAccountDao: MoneyAccountDao)

    @Update
    fun update(moneyAccountDao: MoneyAccountDao)

    @Delete
    fun delete(moneyAccountDao: MoneyAccountDao)

    @Query("SELECT * from money_account where is_credit is 0")
    fun getActiveAccounts(): List<MoneyAccount>

    @Query("SELECT * from money_account where is_credit is 1")
    fun getCreditAccounts(): List<MoneyAccount>
}