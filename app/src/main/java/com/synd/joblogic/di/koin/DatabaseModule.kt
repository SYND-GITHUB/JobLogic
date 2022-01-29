package com.synd.joblogic.di.koin

import androidx.room.Room
import com.synd.joblogic.BuildConfig
import com.synd.joblogic.MyApplication
import com.synd.joblogic.model.local.roomdb.AppDB
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import java.io.File


var databaseModule = module {

    /** DB Singleton Provider */
    single {
        val dataBuilder = Room.databaseBuilder(
            androidApplication() as MyApplication, AppDB::class.java, "synd_joblogic.db"
        )
        // Read local file for Item To Sell
        if (BuildConfig.DB_ITEM_SELL_ASSET_PATH.isNotEmpty()) {
            dataBuilder.createFromAsset(BuildConfig.DB_ITEM_SELL_ASSET_PATH)
        } else if (BuildConfig.DB_ITEM_SELL_STORAGE_PATH.isNotEmpty()) {
            dataBuilder.createFromFile(File(BuildConfig.DB_ITEM_SELL_STORAGE_PATH))
        }
        dataBuilder.build()
    }
    single { (get() as AppDB).mainDao() }

}