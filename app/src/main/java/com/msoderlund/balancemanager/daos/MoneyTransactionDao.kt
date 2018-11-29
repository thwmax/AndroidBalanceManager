package com.msoderlund.balancemanager.daos

import androidx.room.*
import com.msoderlund.balancemanager.entities.MoneyTransaction
import java.util.*

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

    @Query("SELECT * from money_transaction where operation_date >= :date")
    fun getTransactionsAfterDate(date: Date): List<MoneyTransaction>

    @Query("SELECT * from money_transaction where operation_date >= :dateStart and operation_date <= :dateEnd")
    fun getTransactionsBetweenDates(dateStart: Date, dateEnd: Date): List<MoneyTransaction>
}