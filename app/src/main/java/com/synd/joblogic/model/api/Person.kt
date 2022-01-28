package com.synd.joblogic.model.api

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.synd.joblogic.model.remote.ApiConstant
import java.io.Serializable


@Entity(tableName = ApiConstant.TB_PERSON_TO_CALL)
data class Person(@PrimaryKey var id: Long = 0) : Serializable {

    @ColumnInfo(name = "name")
    @SerializedName("name")
    var name: String = ""

    @ColumnInfo(name = "number")
    @SerializedName("number")
    var number: String = ""

}