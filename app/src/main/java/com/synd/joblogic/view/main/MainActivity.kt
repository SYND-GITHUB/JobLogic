package com.synd.joblogic.view.main


import androidx.databinding.ViewDataBinding
import com.synd.joblogic.R
import com.synd.joblogic.databinding.ActivityMainBinding
import com.synd.joblogic.view.base.BaseActivity
import com.synd.joblogic.view.personcall.CallListActivity
import com.synd.joblogic.view.productitem.BuyListActivity
import com.synd.joblogic.view.productitem.SellListActivity


class MainActivity : BaseActivity(), MainInteract {

    private lateinit var binding: ActivityMainBinding

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun initUI(binding: ViewDataBinding?) {
        this.binding = binding as ActivityMainBinding
        this.binding.mainInteract = this
    }

    override fun navigateToCallList() {
        CallListActivity.open(this)
    }

    override fun navigateToBuyList() {
        BuyListActivity.open(this)
    }

    override fun navigateToSellList() {
        SellListActivity.open(this)
    }
}