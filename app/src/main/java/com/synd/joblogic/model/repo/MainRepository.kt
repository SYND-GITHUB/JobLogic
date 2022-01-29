package com.synd.joblogic.model.repo

import androidx.lifecycle.MutableLiveData
import com.synd.joblogic.model.api.ItemToBuy
import com.synd.joblogic.model.api.ItemToSell
import com.synd.joblogic.model.api.Person
import com.synd.joblogic.model.local.preference.PreferenceConstants
import com.synd.joblogic.model.local.preference.PreferenceHelper
import com.synd.joblogic.model.local.roomdb.dao.MainDao
import com.synd.joblogic.model.remote.ApiResponse
import com.synd.joblogic.model.remote.ApiServices
import com.synd.joblogic.model.remote.DataFetchCall
import com.synd.joblogic.model.remote.ReflectionUtil
import org.koin.core.KoinComponent
import org.koin.core.inject
import retrofit2.Response


class MainRepository(
    private val apiServices: ApiServices,
    private val preferences: PreferenceHelper? = null,
    private val mainDao: MainDao? = null
) : KoinComponent {

    /** ReflectionUtil get Object using koin DI
     * used to convert  request Model class to HashMap */
    private val reflectionUtil: ReflectionUtil by inject()

    fun getPersonList(response: MutableLiveData<ApiResponse<List<Person>>>) {
        object : DataFetchCall<List<Person>>(response) {
            override suspend fun createCallAsync(): Response<List<Person>> {
                return apiServices.getCallListingAsync()
            }
            /** If you want to save to DB, let override methods below */
//            override fun saveResult(result: List<Person>) {
//                result.run {
//                    forEach { mainDao?.insertPerson(it) }
//                    preferences?.put(PreferenceConstants.IS_PERSON_SAVED_TO_DB, true)
//                }
//            }
//
//            override fun shouldFetchFromDB(): Boolean {
//                return preferences?.getBoolean(PreferenceConstants.IS_PERSON_SAVED_TO_DB) ?: false
//            }
//
//            override fun loadFromDB(): List<Person>? {
//                return mainDao?.retrieveAllPerson()
//            }
        }.execute()
    }

    fun getItemToBuyList(response: MutableLiveData<ApiResponse<List<ItemToBuy>>>) {
        object : DataFetchCall<List<ItemToBuy>>(response) {
            override suspend fun createCallAsync(): Response<List<ItemToBuy>> {
                return apiServices.getBuyListingAsync()
            }

            /** If you want to save to DB, let override methods below */
//            override fun saveResult(result: List<ItemToBuy>) {
//                result.run {
//                    forEach { mainDao?.insertItemToBuy(it) }
//                    preferences?.put(PreferenceConstants.IS_ITEM_TO_BUY_SAVED_TO_DB, true)
//                }
//            }
//
//            override fun shouldFetchFromDB(): Boolean {
//                return preferences?.getBoolean(PreferenceConstants.IS_ITEM_TO_BUY_SAVED_TO_DB) ?: false
//            }
//
//            override fun loadFromDB(): List<ItemToBuy>? {
//                return mainDao?.retrieveAllItemToBuy()
//            }
        }.execute()
    }

    fun getItemToSellList(response: MutableLiveData<ApiResponse<List<ItemToSell>>>) {
        object : DataFetchCall<List<ItemToSell>>(response) {
            override suspend fun createCallAsync(): Response<List<ItemToSell>> {
                return Response.success(null)
            }

            override fun saveResult(result: List<ItemToSell>) {
//                result.run {
//                    forEach { mainDao?.insertItemToSell(it) }
//                    preferences?.put(PreferenceConstants.IS_ITEM_TO_SELL_SAVED_TO_DB, true)
//                }
            }

            override fun shouldFetchFromDB(): Boolean {
//                return preferences?.getBoolean(PreferenceConstants.IS_ITEM_TO_SELL_SAVED_TO_DB) ?: false
                return true
            }

            override fun loadFromDB(): List<ItemToSell>? {
                return mainDao?.retrieveAllItemToSell()
            }
        }.execute()
    }
}