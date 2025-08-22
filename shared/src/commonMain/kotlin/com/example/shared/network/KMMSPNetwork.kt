package com.example.shared.network

import com.example.shared.models.SPResult
import io.ktor.client.HttpClient
import kotlin.jvm.JvmStatic

class KMMSPNetwork private constructor() {

    lateinit var  client:HttpClient //= KtorClientFactory().createClient()
    private var ktorService: KtorService? = null

    fun initialize(baseUrl: String, tokenMap: HashMap<String, String>) {
        client = KtorClientFactory().createClient(tokenMap)
        ktorService = KtorService(client)
        KtorService.baseUrl = baseUrl
    }

    private fun getService(): KtorService {
        return ktorService ?: throw IllegalStateException("SPNetwork is not initialized. Please call initialize(baseUrl) first.")
    }

    suspend fun fetchCompanyConfig(domainName: String): SPResult {
        return getService().fetchCompanyConfig(domainName)
    }

    companion object {
        @JvmStatic
        val instance: KMMSPNetwork by lazy { KMMSPNetwork() }
        // adding comment
    }
} 