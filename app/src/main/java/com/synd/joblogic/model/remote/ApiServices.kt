package com.synd.joblogic.model.remote

import com.synd.joblogic.model.api.ItemToBuy
import com.synd.joblogic.model.api.Person
import retrofit2.Response
import retrofit2.http.GET


interface ApiServices {

    @GET(ApiConstant.GET_CALL_LISTING)
    suspend fun getCallListingAsync(): Response<List<Person>>

    @GET(ApiConstant.GET_BUY_LISTING)
    suspend fun getBuyListingAsync(): Response<List<ItemToBuy>>

}