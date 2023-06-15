package com.example.composeapp.data.models

import com.google.gson.annotations.SerializedName

data class ApiResult(
    val errors: List<Any>,
    val `get`: String,
    val paging: Paging,
    val parameters: Parameters,
    @SerializedName("response")
    val resp: List<Resp>,
    val results: Int
)