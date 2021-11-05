package com.example.userapplication.utils

import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

class ExtraKeys{
    companion object{

        const val REPOSITORY_INFO = "repository_info"
        const val ACCEPT= "application/vnd.github.v3+json"
        const val USERNAME = "user"
        const val  TYPE= "owner"
        const val  SORT= "full_name"
        const val DIRECTION = "asc"


    }
}