package com.synd.joblogic.view.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.synd.joblogic.R
import com.synd.joblogic.databinding.ActivityRecyclerBinding


abstract class BaseRecyclerActivity : BaseActivity() {
    private lateinit var binding: ActivityRecyclerBinding

    override fun getLayout(): Int {
        return R.layout.activity_recycler
    }

    override fun initUI(binding: ViewDataBinding?) {
        this.binding = binding as ActivityRecyclerBinding
        initRecyclerView()
    }

    fun getBinding(): ActivityRecyclerBinding {
        return binding
    }

    private fun initRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )
    }
}
