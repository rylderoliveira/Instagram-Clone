package com.example.instagramclone.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post(

    @SerializedName("comments")
    val comments: List<Comment>,

    @SerializedName("id")
    val id: Int,

    @SerializedName("media_type")
    val media_type: String,

    @SerializedName("media_url")
    val media_url: String,

    @SerializedName("user_has_stories")
    val user_has_stories: Boolean,

    @SerializedName("user_id")
    val user_id: Int,

    @SerializedName("user_nickname")
    val user_nickname: String,

    @SerializedName("users_likes")
    val users_likes: List<UsersLike>
) : Parcelable
