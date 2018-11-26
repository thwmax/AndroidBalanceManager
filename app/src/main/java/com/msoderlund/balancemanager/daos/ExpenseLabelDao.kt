package com.msoderlund.balancemanager.daos

import androidx.room.*
import com.msoderlund.balancemanager.entities.ExpenseLabel
import com.msoderlund.balancemanager.entities.MoneyAccount

@Dao
interface ExpenseLabelDao {
    @Insert
    fun insert(expenseLabel: ExpenseLabel)

    @Update
    fun update(expenseLabel: ExpenseLabel)

    @Delete
    fun delete(expenseLabel: ExpenseLabel)

    @Query("SELECT * from expense_label")
    fun getExpenseLabels(): List<ExpenseLabel>
}