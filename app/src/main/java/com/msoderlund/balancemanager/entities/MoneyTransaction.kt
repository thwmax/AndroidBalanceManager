package com.msoderlund.balancemanager.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "money_transaction", foreignKeys = [ForeignKey(entity = MoneyAccount::class,
    parentColumns = arrayOf("id"),
    childColumns = arrayOf("account_id"),
    onDelete = CASCADE)]
)
data class MoneyTransaction(@PrimaryKey var id: Int,
                            var amount: Float,
                            @ColumnInfo(name = "creation_date") var creationDate: Date,
                            @ColumnInfo(name = "operation_date") var operationDate: Date,
                            var cuotes: Int,
                            @ColumnInfo(name = "is_expense") var isExpense: Boolean,
                            @ColumnInfo(name = "account_id") var accountId: Int)