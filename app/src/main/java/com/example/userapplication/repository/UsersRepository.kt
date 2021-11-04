package com.example.userapplication.repository

import com.example.userapplication.date.DateSource
import com.example.userapplication.utils.performGetOperation
import javax.inject.Inject

class UsersRepository @Inject constructor(private val dateSource: DateSource) {

    fun getUsers() = performGetOperation { dateSource.getUsers() }

}