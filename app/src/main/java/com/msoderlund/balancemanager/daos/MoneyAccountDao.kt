package com.msoderlund.balancemanager.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.msoderlund.balancemanager.entities.MoneyAccount

@Dao
interface MoneyAccountDao {
    @Insert
    fun insert(moneyAccountDao: MoneyAccountDao)

    @Update
    fun update(moneyAccountDao: MoneyAccountDao)

    @Query("UPDATE money_account set live = 0 where id = :moneyAccountDaoId")
    fun delete(moneyAccountDaoId: Int)

    @Query("SELECT * from money_account where is_credit is 0 and live is 1")
    fun getAccounts(): LiveData<MoneyAccount>

    @Query("SELECT * from money_account where is_credit is 0 and live is 1")
    fun getActiveAccounts(): LiveData<MoneyAccount>

    @Query("SELECT * from money_account where is_credit is 1 and live is 1")
    fun getCreditAccounts(): LiveData<MoneyAccount>
}