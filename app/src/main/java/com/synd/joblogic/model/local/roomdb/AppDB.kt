package com.synd.joblogic.model.local.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.synd.joblogic.model.api.ItemToBuy
import com.synd.joblogic.model.api.ItemToSell
import com.synd.joblogic.model.api.Person
import com.synd.joblogic.model.local.roomdb.dao.MainDao


@Database(entities = [Person::class, ItemToBuy::class, ItemToSell::class], version = 1)
abstract class AppDB : RoomDatabase() {

    abstract fun mainDao(): MainDao

}