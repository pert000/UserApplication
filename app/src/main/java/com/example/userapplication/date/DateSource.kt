package com.example.userapplication.date

import com.example.userapplication.utils.ExtraKeys
import javax.inject.Inject

class DateSource @Inject constructor(private val apiService: ApiService) : BaseDataSource() {
    suspend fun getUsers() = getResult {
        apiService.getUsers(
            ExtraKeys.ACCEPT,
            ExtraKeys.USERNAME,ExtraKeys.TYPE,ExtraKeys.SORT,ExtraKeys.DIRECTION,30,1
        )
    }
//todo
}