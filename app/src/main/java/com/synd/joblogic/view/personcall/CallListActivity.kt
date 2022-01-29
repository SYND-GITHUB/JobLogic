package com.synd.joblogic.view.personcall

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.synd.joblogic.R
import com.synd.joblogic.model.api.Person
import com.synd.joblogic.model.remote.ApiResponse
import com.synd.joblogic.utils.Connectivity
import com.synd.joblogic.utils.showToast
import com.synd.joblogic.view.base.BaseRecyclerActivity
import com.synd.joblogic.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class CallListActivity : BaseRecyclerActivity() {

    private val mainViewMode: MainViewModel by viewModel()

    private lateinit var mAdapter: CallListAdapter
    private var dataList = mutableListOf<Person>()

    override val enableBackToolbar: Boolean = true
    override val toolbarTitle: Int = R.string.call_list

    private val personListObserver: Observer<ApiResponse<List<Person>>> by lazy {
        Observer<ApiResponse<List<Person>>> {
            handleGlobalSettingResponse(it)
        }
    }

    override fun initUI(binding: ViewDataBinding?) {
        super.initUI(binding)
        mAdapter = CallListAdapter(this, dataList)
        getBinding().recyclerView.adapter = mAdapter

        getCallPersonList()
    }

    private fun getCallPersonList() {
        if (Connectivity.isConnected(this)) {
            /*** request viewModel to get data ***/
            mainViewMode.getPersonList()
            /*** observe live data of viewModel*/
            mainViewMode.personListResponse.observe(this, personListObserver)
        } else {
            showToast(applicationContext, R.string.no_network_error)
        }
    }

    private fun handleGlobalSettingResponse(response: ApiResponse<List<Person>>) {
        when (response.status) {
            ApiResponse.Status.LOADING -> {
                showLoading()
            }
            ApiResponse.Status.SUCCESS -> {
                hideLoading()
                dataList = response.data?.toMutableList() ?: mutableListOf()
                mAdapter.updateNewData(dataList)
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
                startActivity(Intent(this, CallListActivity::class.java))
            }
        }
    }
}