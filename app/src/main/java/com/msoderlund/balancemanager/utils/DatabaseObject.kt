package com.msoderlund.balancemanager.utils

import android.content.Context
import androidx.room.Database
import androidx.room.Room
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

    companion object {
        private const val DATABASE_NAME = "balance_manager_db_v1.db"
        @Volatile private var INSTANCE: DatabaseObject? = null

        fun getInstance(context: Context): DatabaseObject =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }

        fun buildDatabase(context: Context): DatabaseObject = Room.databaseBuilder(context.applicationContext,
            DatabaseObject::class.java, DATABASE_NAME).build()
    }
}