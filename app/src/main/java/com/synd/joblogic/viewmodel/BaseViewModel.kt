package com.synd.joblogic.viewmodel


import androidx.lifecycle.ViewModel
import com.synd.joblogic.model.repo.AppRepository
import org.koin.core.KoinComponent
import org.koin.core.inject

open class BaseViewModel : ViewModel(), KoinComponent {

    /**
     *  ApplicationRepository is injected here to access application level
     *  functions & preference
     *
     */
    val appRepo: AppRepository by inject()

}