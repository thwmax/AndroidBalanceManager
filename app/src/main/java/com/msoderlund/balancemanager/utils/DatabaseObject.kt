package com.msoderlund.balancemanager.utils

import androidx.room.Database
import androidx.room.RoomDatabase
import com.msoderlund.balancemanager.daos.*
import com.msoderlund.balancemanager.entities.*

@Database(entities = [Currency::class, ExpenseLabel::class, ExpenseLabelTransactionJoin::class,
            MoneyAccount::class, MoneyTransaction::class, MoneyTransfer::class], version = 1)
abstract class DatabaseObject: RoomDatabase() {
    abstract fun getCurrencyDao(): CurrencyDao
    abstract fun getExpenseLabelDao(): ExpenseLabelDao
    abstract fun getExpenseLabelTransactionJoinDao(): ExpenseLabelTransactionJoinDao
    abstract fun getMoneyAccountDao(): MoneyAccountDao
    abstract fun getMoneyTransactionDao(): MoneyTransactionDao
    abstract fun getMoneyTransferDao(): MoneyTransferDao
}