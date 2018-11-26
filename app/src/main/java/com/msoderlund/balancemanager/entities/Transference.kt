package com.msoderlund.balancemanager.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(foreignKeys = arrayOf(ForeignKey(entity = MoneyAccount::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("origin_account"),
        onDelete = ForeignKey.NO_ACTION),
    ForeignKey(entity = MoneyAccount::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("destination_account"),
        onDelete = ForeignKey.NO_ACTION)))
data class Transference(@PrimaryKey var id: Int,
                        @ColumnInfo(name = "origin_account") var originAccount: Int,
                        @ColumnInfo(name = "destination_account") var destinationAccount: Int,
                        @ColumnInfo(name = "origin_amount") var originAmount: Float,
                        @ColumnInfo(name = "destination_amount") var destinationAmount: Float,
                        @ColumnInfo(name = "creation_date") var creationDate: Date,
                        @ColumnInfo(name = "operation_date") var operationDate: Date)