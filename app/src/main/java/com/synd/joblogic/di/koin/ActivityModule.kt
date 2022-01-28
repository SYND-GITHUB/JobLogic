package com.synd.joblogic.di.koin

import com.synd.joblogic.view.main.MainActivity
import org.koin.core.qualifier.named
import org.koin.dsl.module


var splashActivityModule = module {

    scope(named<MainActivity>()) {
        scoped {
            //todo define provide object here  which is used for splashActivty Scope only
        }
    }
}