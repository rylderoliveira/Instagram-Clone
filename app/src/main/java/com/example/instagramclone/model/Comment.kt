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
    val userHasStories: Boolean,

    @SerializedName("user_id")
    val userId: Int,

    @SerializedName("user_nickname")
    val userNickname: String
) : Parcelable