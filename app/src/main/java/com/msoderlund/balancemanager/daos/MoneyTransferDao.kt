package com.msoderlund.balancemanager.daos

import androidx.room.*
import com.msoderlund.balancemanager.entities.MoneyTransfer
import java.util.*

@Dao
interface MoneyTransferDao {
    @Insert
    fun insert(moneyTransfer: MoneyTransfer)

    @Update
    fun update(moneyTransfer: MoneyTransfer)

    @Delete
    fun delete(moneyTransfer: MoneyTransfer)

    @Query("SELECT * from money_transfer where destination_account = :moneyAccount")
    fun getTransfersToAccount(moneyAccount: Int): List<MoneyTransfer>

    @Query("SELECT * from money_transfer where origin_account = :moneyAccount")
    fun getTransfersFromAccount(moneyAccount: Int): List<MoneyTransfer>

    @Query("SELECT * from money_transfer where operation_date >= :dateStart and operation_date <= :dateEnd " +
            "AND destination_account = :moneyAccount")
    fun getTransfersBetweenDatesToAccount(dateStart: Date, dateEnd: Date, moneyAccount: Int): List<MoneyTransfer>

    @Query("SELECT * from money_transfer where operation_date >= :dateStart and operation_date <= :dateEnd " +
            "AND origin_account = :moneyAccount")
    fun getTransfersBetweenDatesFromAccount(dateStart: Date, dateEnd: Date, moneyAccount: Int): List<MoneyTransfer>
}