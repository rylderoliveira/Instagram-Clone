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
    val mediaType: String,

    @SerializedName("media_url")
    val mediaUrl: String,

    @SerializedName("user_has_stories")
    val userHasStories: Boolean,

    @SerializedName("user_id")
    val userId: Int,

    @SerializedName("user_nickname")
    val userNickname: String,

    @SerializedName("users_likes")
    val usersLikes: List<UsersLike>,

    @SerializedName("description")
    val description: String,

    @SerializedName("user_photo")
    val ownerPhotoUrl: String
) : Parcelable
