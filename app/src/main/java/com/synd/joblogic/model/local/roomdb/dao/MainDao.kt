package com.synd.joblogic.model.local.roomdb.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.synd.joblogic.model.api.ItemToBuy
import com.synd.joblogic.model.api.ItemToSell
import com.synd.joblogic.model.api.Person
import com.synd.joblogic.model.remote.ApiConstant


@Dao
interface MainDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPerson(person: Person)

    @Query("SELECT * FROM ${ApiConstant.TB_PERSON_TO_CALL}")
    fun retrieveAllPerson(): List<Person>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItemToBuy(itemToBuy: ItemToBuy)

    @Query("SELECT * FROM ${ApiConstant.TB_ITEM_TO_BUY}")
    fun retrieveAllItemToBuy(): List<ItemToBuy>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItemToSell(itemToSell: ItemToSell)

    @Query("SELECT * FROM ${ApiConstant.TB_ITEM_TO_SELL}")
    fun retrieveAllItemToSell(): List<ItemToSell>
}
