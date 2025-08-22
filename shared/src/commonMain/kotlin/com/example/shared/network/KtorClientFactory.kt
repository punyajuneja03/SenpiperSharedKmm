package com.example.shared.network

import io.ktor.client.HttpClient

expect class KtorClientFactory() {
    fun createClient(tokenMap: HashMap<String, String>): HttpClient
}