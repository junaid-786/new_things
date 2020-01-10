package com.app.mvvmframework.models

data class GridPostResponseNew(
    val APPICODERESULT: String,
    val result: List<Result>,
    val statusCode: Int
) {
    data class Result(
        val comments: Int,
        val content: List<Content>,
        val likes: List<Any>,
        val posts: Posts,
        val tagged_users: List<TaggedUser>
    ) {
        data class TaggedUser(
            val id: Int,
            val username: String
        )

        data class Posts(
            val id: String,
            val name: String,
            val parent_id: String,
            val parent_post_content: String,
            val post_content: String,
            val profile_pic: String,
            val username: String
        )

        data class Content(
            val content_type: String,
            val file_name: String,
            val id: String,
            val video_thumbnail: String
        )
    }
}