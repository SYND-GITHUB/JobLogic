package com.synd.joblogic.model.api

import androidx.room.ColumnInfo
import com.google.gson.annotations.SerializedName
import java.io.Serializable

open class BaseItem : Serializable {

    @ColumnInfo(name = "name")
    @SerializedName("name")
    var name: String = ""

    @ColumnInfo(name = "price")
    @SerializedName("price")
    var price: Float = 0F

    @ColumnInfo(name = "quantity")
    @SerializedName("quantity")
    var quantity: Int = 0

    @ColumnInfo(name = "type")
    @SerializedName("type")
    var type: Int = 0

}