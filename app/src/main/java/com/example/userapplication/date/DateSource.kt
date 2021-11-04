package com.example.userapplication.date

import javax.inject.Inject

class DateSource @Inject constructor(private val apiService: ApiService) : BaseDataSource() {
    suspend fun getUsers() = getResult {
        apiService.getUsers(
            "application/vnd.github.v3+json",
            "pert000","owner","full_name","asc",30,1
        )
    }

}