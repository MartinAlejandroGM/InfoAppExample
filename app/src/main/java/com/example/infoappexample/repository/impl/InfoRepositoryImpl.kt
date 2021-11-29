package com.example.infoappexample.repository.impl

import com.example.infoappexample.model.InfoResponse
import com.example.infoappexample.network.webservice.RandomWebService
import com.example.infoappexample.repository.InfoRepository

class InfoRepositoryImpl: InfoRepository {
    override suspend fun fetchInfo(): InfoResponse {
        val randomUserWs = RandomWebService()
        return randomUserWs.getInfo()
    }
}