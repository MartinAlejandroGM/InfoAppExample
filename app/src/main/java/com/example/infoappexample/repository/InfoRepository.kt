package com.example.infoappexample.repository

import com.example.infoappexample.model.InfoResponse

interface InfoRepository {
    suspend fun fetchInfo(): InfoResponse
}