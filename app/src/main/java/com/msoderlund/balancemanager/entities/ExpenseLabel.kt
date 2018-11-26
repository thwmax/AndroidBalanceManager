package com.msoderlund.balancemanager.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "expense_label")
data class ExpenseLabel(@PrimaryKey var id: Int,
                        @ColumnInfo(name = "account_name") var name: String,
                        @ColumnInfo(name = "creation_date") var creationDate: Date = Date(),
                        @ColumnInfo(name = "updated_at") var updatedAt: Date,
                        @ColumnInfo(name = "icon_id") var iconId: Int)