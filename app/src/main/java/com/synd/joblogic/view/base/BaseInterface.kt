package com.synd.joblogic.view.base

import androidx.databinding.ViewDataBinding

interface BaseInterface {
    val layout: Int
    val enableBackToolbar: Boolean
    val toolbarTitle: Int
    fun initUI(binding: ViewDataBinding?)
}