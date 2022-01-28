package com.synd.joblogic.view.productitem

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.synd.joblogic.R
import com.synd.joblogic.model.api.ItemToSell
import com.synd.joblogic.model.remote.ApiResponse
import com.synd.joblogic.utils.Connectivity
import com.synd.joblogic.utils.showToast
import com.synd.joblogic.view.base.BaseRecyclerActivity
import com.synd.joblogic.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class SellListActivity : BaseRecyclerActivity() {

    private val mainViewMode: MainViewModel by viewModel()

    private lateinit var mAdapter: ItemListAdapter
    private var dataList = mutableListOf<ItemToSell>()

    private val itemListObserver: Observer<ApiResponse<List<ItemToSell>>> by lazy {
        Observer<ApiResponse<List<ItemToSell>>> {
            handleGlobalSettingResponse(it)
        }
    }

    override fun initUI(binding: ViewDataBinding?) {
        super.initUI(binding)
        mAdapter = ItemListAdapter(this, dataList.toMutableList())
        getBinding().recyclerView.adapter = mAdapter

        getCallItemToSellList()
    }

    private fun getCallItemToSellList() {
        if (Connectivity.isConnected(this)) {
            /*** request viewModel to get data ***/
            mainViewMode.getItemToSellList()
            /*** observe live data of viewModel*/
            mainViewMode.itemToSellListResponse.observe(this, itemListObserver)
        } else {
            showToast(applicationContext, R.string.no_network_error)
        }
    }

    private fun handleGlobalSettingResponse(response: ApiResponse<List<ItemToSell>>) {
        when (response.status) {
            ApiResponse.Status.LOADING -> {
                showLoading()
            }
            ApiResponse.Status.SUCCESS -> {
                hideLoading()
                dataList = response.data?.toMutableList() ?: mutableListOf()
                mAdapter.updateNewData(dataList.toMutableList())
            }
            ApiResponse.Status.ERROR -> {
                hideLoading()
                if (response.error?.code == 500) {
                    showToast(applicationContext, response.error?.message)
                } else {
                    showToast(applicationContext, R.string.internal_server_error)
                }
            }
        }
    }

    companion object {
        fun open(context: Context) {
            context.run {
                startActivity(Intent(this, SellListActivity::class.java))
            }
        }
    }
}