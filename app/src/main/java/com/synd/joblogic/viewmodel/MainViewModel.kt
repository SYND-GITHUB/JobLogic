package com.synd.joblogic.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.synd.joblogic.model.api.ItemToBuy
import com.synd.joblogic.model.api.ItemToSell
import com.synd.joblogic.model.api.Person
import com.synd.joblogic.model.remote.ApiResponse
import com.synd.joblogic.model.repo.MainRepository


class MainViewModel constructor(private val mainRepository: MainRepository) : BaseViewModel() {

    private val _personListResponse by lazy {
        MutableLiveData<ApiResponse<List<Person>>>()
    }
    private val _itemToBuyListResponse by lazy {
        MutableLiveData<ApiResponse<List<ItemToBuy>>>()
    }
    private val _itemToSellListResponse by lazy {
        MutableLiveData<ApiResponse<List<ItemToSell>>>()
    }

    /*** LiveData that view observing
     * you can modify this as MediatorLiveData if you want to modify data model coming from api*/
    val personListResponse: LiveData<ApiResponse<List<Person>>> = _personListResponse
    val itemToBuyListResponse: LiveData<ApiResponse<List<ItemToBuy>>> = _itemToBuyListResponse
    val itemToSellListResponse: LiveData<ApiResponse<List<ItemToSell>>> = _itemToSellListResponse

    fun getPersonList() {
        mainRepository.getPersonList(_personListResponse)
    }

    fun getItemToBuyList() {
        mainRepository.getItemToBuyList(_itemToBuyListResponse)
    }

    fun getItemToSellList() {
        mainRepository.getItemToSellList(_itemToSellListResponse)
    }

}