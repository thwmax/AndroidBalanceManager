package com.msoderlund.balancemanager.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "money_account")
data class MoneyAccount (@PrimaryKey(autoGenerate = true) var id: Int,
                         @ColumnInfo(name = "account_name") var name: String,
                         @ColumnInfo(name = "is_credit") var isCredit: Boolean,
                         @ColumnInfo(name = "creation_date") var creationDate: Date = Date(),
                         @ColumnInfo(name = "updated_at") var updatedAt: Date,
                         @ColumnInfo(name = "billing_day") var billingDay: Int,
                         @ColumnInfo(name = "icon_id") var iconId: Int,
                         @ColumnInfo(name = "live") var live: Boolean,
                         @Embedded var currency: Currency)