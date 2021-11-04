package com.example.userapplication.ui.users.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.example.userapplication.date.Resource
import com.example.userapplication.model.UserRespons
import com.example.userapplication.repository.UsersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class UsersViewModel @Inject constructor(private var repository: UsersRepository):ViewModel() {
    private  var usersRequest = MutableLiveData<String>()



    var  usersRespons: LiveData<Resource<List<UserRespons>>> = usersRequest.switchMap { repository.getUsers() }


    fun getUsers(){
        usersRequest.value = ""
    }
}