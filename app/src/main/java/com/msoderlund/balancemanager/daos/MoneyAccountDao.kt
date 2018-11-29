package com.msoderlund.balancemanager.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.msoderlund.balancemanager.entities.MoneyAccount

@Dao
interface MoneyAccountDao {
    @Insert
    fun insert(moneyAccountDao: MoneyAccount)

    @Update
    fun update(moneyAccountDao: MoneyAccount)

    @Query("SELECT * from money_account where is_credit is 0 and live is 1")
    fun getAccounts(): List<MoneyAccount>

    @Query("SELECT * from money_account where is_credit is 0 and live is 1")
    fun getActiveAccounts(): List<MoneyAccount>

    @Query("SELECT * from money_account where is_credit is 1 and live is 1")
    fun getCreditAccounts(): List<MoneyAccount>
}