package com.synd.joblogic.model.api

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.synd.joblogic.model.remote.ApiConstant


@Entity(tableName = ApiConstant.TB_ITEM_TO_BUY)
data class ItemToBuy(@PrimaryKey var id: Long = 0) : BaseItem()