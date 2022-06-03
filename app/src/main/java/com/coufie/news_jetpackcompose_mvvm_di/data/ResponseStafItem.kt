package com.coufie.news_jetpackcompose_mvvm_di.data


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ResponseStafItem(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("director")
    val director: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("name")
    val name: String
) : Serializable