package com.msoderlund.balancemanager.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "expense_label_transaction",
    primaryKeys = ["expense_label_id", "transaction_id"],
    foreignKeys = [
        ForeignKey(entity = ExpenseLabel::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("expense_label_id")),
        ForeignKey(entity = MoneyTransaction::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("transaction_id"))]
)
data class ExpenseLabelTransactionJoin(
    @ColumnInfo(name = "expense_label_id") val expenseLabelId: Int,
    @ColumnInfo(name = "transaction_id") val transactionId: Int)