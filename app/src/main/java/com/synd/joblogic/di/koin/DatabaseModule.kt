package com.synd.joblogic.di.koin

import androidx.room.Room
import com.synd.joblogic.MyApplication
import com.synd.joblogic.model.local.roomdb.AppDB
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module


var databaseModule = module {

    /** DB Singleton Provider */
    single {
        Room.databaseBuilder(
            (androidApplication() as MyApplication),
            AppDB::class.java,
            "synd_joblogic.db"
        ).build()
    }
    single { (get() as AppDB).mainDao() }

}