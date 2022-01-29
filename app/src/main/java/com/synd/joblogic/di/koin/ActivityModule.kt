package com.synd.joblogic.di.koin

import com.synd.joblogic.view.main.MainActivity
import org.koin.core.qualifier.named
import org.koin.dsl.module


var activityModule = module {

    scope(named<MainActivity>()) {
        scoped {
        }
    }
}