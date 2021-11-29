package com.example.infoappexample.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.infoappexample.extension.launch
import com.example.infoappexample.model.InfoResponse
import com.example.infoappexample.repository.impl.InfoRepositoryImpl
import com.example.infoappexample.extension.Result
import kotlinx.coroutines.Dispatchers

class RandomUserViewModel(application: Application): AndroidViewModel(application) {
    private val infoRepository = InfoRepositoryImpl()
    private val _fetchInfo: MutableLiveData<Result<InfoResponse>> = MutableLiveData()

    val fetchInfo: LiveData<Result<InfoResponse>>
    get() = _fetchInfo

    fun fetchInfo(){
        viewModelScope.launch(_fetchInfo, Dispatchers.IO){
            val result = infoRepository.fetchInfo()
            if (result.error.isNotBlank())
                throw Exception(result.error)
            else if (result.results.isEmpty())
                throw Exception("Error: Empty info")
            result
        }
    }
}