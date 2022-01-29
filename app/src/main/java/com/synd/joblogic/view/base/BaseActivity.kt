package com.synd.joblogic.view.base

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import com.synd.joblogic.R
import com.synd.joblogic.viewmodel.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.reflect.KClass


abstract class BaseActivity : AppCompatActivity(), BaseInterface, LifecycleOwner {

    private val baseViewModel: BaseViewModel by viewModel()

    private val progressDialog: ProgressDialog by lazy {
        ProgressDialog(this).apply {
            setMessage(getString(R.string.loading_data))
        }
    }

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(enableBackToolbar)
        supportActionBar?.setDisplayShowHomeEnabled(enableBackToolbar)
        supportActionBar?.title = getString(toolbarTitle)
        val layoutIdRes = layout
        if (layoutIdRes != 0) {
            val binding = DataBindingUtil.setContentView(this, layoutIdRes) as ViewDataBinding
            initUI(binding)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    protected fun showLoading() {
        progressDialog.show()
    }

    protected fun hideLoading() {
        progressDialog.isShowing.let {
            progressDialog.hide()
        }
    }

    protected fun open(javaClass: KClass<BaseActivity>) {
        startActivity(Intent(this, javaClass.java))
    }
}
