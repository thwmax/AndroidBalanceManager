package com.msoderlund.balancemanager.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Currency(@PrimaryKey (autoGenerate = true) var currency_id: Int, var name: String, var exchangeRate: Float)