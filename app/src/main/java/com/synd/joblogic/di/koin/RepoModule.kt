package com.synd.joblogic.di.koin

import com.synd.joblogic.model.repo.AppRepository
import com.synd.joblogic.model.repo.MainRepository
import org.koin.dsl.module


val repoModule = module {

    /**Provide ContactRepository class Singleton object
     * you can use it any KoinComponent class  below is declaration
     *  private val globalRepository: ContactRepository by inject() */

    single { MainRepository(get(), get(), get()) }
    single { AppRepository(get()) }

}