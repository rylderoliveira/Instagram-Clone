package com.example.instagramclone.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UsersLike(

    @SerializedName("user_id")
    val user_id: Int,

    @SerializedName("user_nickname")
    val user_nickname: String
) : Parcelable