package com.example.shared.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit


actual class KtorClientFactory {
    actual fun createClient(tokenMap: HashMap<String, String>): HttpClient {
        return HttpClient(OkHttp) {
            engine {
                config {
                    connectTimeout(120, TimeUnit.SECONDS)
                    readTimeout(120, TimeUnit.SECONDS)
                    writeTimeout(120, TimeUnit.SECONDS)

                    val logging = HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }
                    addInterceptor(logging)
                    addInterceptor(object : Interceptor {
                        override fun intercept(chain: Interceptor.Chain): Response {
                            val originalRequest = chain.request()

                            val requestWithHeaders = originalRequest.newBuilder()
                                .removeHeader("User-Agent")
                                .header(
                                    "User-Agent",
                                    tokenMap["User-Agent"] ?: ""
                                )
                                .removeHeader("auth")
                                .addHeader(
                                    "auth",
                                    tokenMap["auth"] ?: ""
                                )
                                .removeHeader("deviceId")
                                .addHeader(
                                    "deviceId",
                                    tokenMap["deviceId"] ?: ""
                                )
                                .removeHeader("Cookie")
                                .addHeader(
                                    "Cookie",
                                    tokenMap["Cookie"] ?: ""
                                )
                                .removeHeader("lang")
                                .addHeader(
                                    "lang",
                                    tokenMap["lang"] ?: ""
                                )
                                .removeHeader("tz")
                                .addHeader(
                                    "tz",
                                    tokenMap["tz"] ?: ""
                                )
                                .build()

                            return chain.proceed(requestWithHeaders)
                        }
                    })
                }

                addNetworkInterceptor { chain ->
                    val request = chain.request()
                    val t1 = System.nanoTime()
                    val response = chain.proceed(request)
                    val t2 = System.nanoTime()
                    response
                }
            }

            install(ContentNegotiation) {
                json(
                    Json {
                        ignoreUnknownKeys = true
                        prettyPrint = true
                    }
                )
            }
        }
    }
}