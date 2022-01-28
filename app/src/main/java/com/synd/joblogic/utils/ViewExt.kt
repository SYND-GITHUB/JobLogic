package com.synd.joblogic.utils

import android.app.Activity
import android.content.Context
import android.widget.Toast

fun Activity.showToast(context: Context, stringId: Int) {
    Toast.makeText(context, stringId, Toast.LENGTH_SHORT).show()
}

fun Activity.showToast(context: Context, string: String) {
    Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
}