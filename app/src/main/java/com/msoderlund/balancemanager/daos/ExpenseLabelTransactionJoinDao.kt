package com.msoderlund.balancemanager.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.msoderlund.balancemanager.entities.ExpenseLabel
import com.msoderlund.balancemanager.entities.ExpenseLabelTransactionJoin
import com.msoderlund.balancemanager.entities.MoneyTransaction
import java.util.*

@Dao
interface ExpenseLabelTransactionJoinDao {
    @Insert
    fun insert(expenseLabelTransactionJoinDao: ExpenseLabelTransactionJoin)

    @Delete
    fun delete(expenseLabelTransactionJoinDao: ExpenseLabelTransactionJoin)

    @Query("SELECT * FROM expense_label INNER JOIN expense_label_transaction " +
            "ON expense_label.id=expense_label_transaction.expense_label_id " +
            "WHERE expense_label_transaction.transaction_id=:transactionId")
    fun getLabelsForTransaction(transactionId: Int): List<ExpenseLabel>

    @Query("SELECT * FROM money_transaction INNER JOIN expense_label_transaction " +
            "ON money_transaction.id=expense_label_transaction.transaction_id " +
            "WHERE expense_label_transaction.expense_label_id=:labelId")
    fun getTransactionsForLabel(labelId: Int): List<MoneyTransaction>

    @Query("SELECT * FROM money_transaction INNER JOIN expense_label_transaction " +
            "ON money_transaction.id=expense_label_transaction.transaction_id " +
            "WHERE expense_label_transaction.expense_label_id=:labelId " +
            "AND money_transaction.operation_date >= startDate AND money_transaction.operation_date <= endDate")
    fun getTransactionsForLabelInDateRange(labelId: Int, startDate: Date, endDate: Date): List<MoneyTransaction>
}