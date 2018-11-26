package com.msoderlund.balancemanager.daos

import androidx.room.*
import com.msoderlund.balancemanager.entities.MoneyTransaction

@Dao
interface MoneyTransactionDao {
    @Insert
    fun insert(moneyTransaction: MoneyTransaction)

    @Update
    fun update(moneyTransaction: MoneyTransaction)

    @Delete
    fun delete(moneyTransaction: MoneyTransaction)

    @Query("SELECT * from money_transaction where account_id = :moneyAccount")
    fun getTransactionsFromAccount(moneyAccount: Int): List<MoneyTransaction>
}