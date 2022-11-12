package com.example.instagramclone.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Comment(

    @SerializedName("comment")
    val comment: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("user_has_stories")
    val user_has_stories: Boolean,

    @SerializedName("user_id")
    val user_id: Int,

    @SerializedName("user_nickname")
    val user_nickname: String
) : Parcelable