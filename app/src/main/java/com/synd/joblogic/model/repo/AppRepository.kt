package com.synd.joblogic.model.repo

import com.synd.joblogic.model.local.preference.PreferenceConstants
import com.synd.joblogic.model.local.preference.PreferenceHelper


class AppRepository(private val preferences: PreferenceHelper) {

    fun getIsAppFirstTimeLaunched(): Boolean {
        return preferences.getBoolean(PreferenceConstants.IS_FIRST_TIME_LAUNCHED)
    }
}