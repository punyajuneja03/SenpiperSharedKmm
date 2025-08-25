package com.example.shared.network

import com.example.shared.models.KmmModelCompanyConfig
import io.ktor.client.HttpClient
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlin.jvm.JvmStatic

class KMMSPNetwork private constructor() {

    lateinit var  client:HttpClient //= KtorClientFactory().createClient()
    private var ktorService: KtorService? = null
    val json = Json {
        ignoreUnknownKeys = true // so extra keys like faviconUrl won’t crash
    }

    fun initialize(baseUrl: String, tokenMap: HashMap<String, String>) {
        client = KtorClientFactory().createClient(tokenMap)
        ktorService = KtorService(client)
        KtorService.baseUrl = baseUrl
    }

    private fun getService(): KtorService {
        return ktorService ?: throw IllegalStateException("SPNetwork is not initialized. Please call initialize(baseUrl) first.")
    }

    suspend fun fetchCompanyConfig(domainName: String): KmmModelCompanyConfig {
        val response =getService().fetchCompanyConfig(domainName)
        val element: JsonElement? = response.response

        return json.decodeFromJsonElement(KmmModelCompanyConfig.serializer(), element!!)
    }

    companion object {
        @JvmStatic
        val instance: KMMSPNetwork by lazy { KMMSPNetwork() }
        // adding comment
    }
} 