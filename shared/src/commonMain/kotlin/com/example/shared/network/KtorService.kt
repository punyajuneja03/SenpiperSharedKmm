package com.example.shared.network

import com.example.shared.models.SPResult
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.delete
import io.ktor.client.request.get
import io.ktor.client.request.patch
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.http.appendPathSegments
import io.ktor.http.headers
import io.ktor.http.takeFrom

class KtorService(
    private val client: HttpClient,
) {
    companion object {
         var baseUrl = "https://api.senpiper.com/"
    }

    suspend fun fetchCompanyConfig(domainName: String): SPResult {
        return client.get {
            url {
                takeFrom(baseUrl)
                appendPathSegments("api/core/companies/config", domainName)
            }
        }.body()
    }

    suspend fun getFormAnswers(
        groupId: String,
        formId: String,
        startTime: Long,
        endTime: Long
    ): SPResult {
        return client.get {
            url {
                takeFrom(baseUrl)
                appendPathSegments("api/core/form/answer/all", groupId, formId, startTime.toString(), endTime.toString())
            }
        }.body()
    }

    suspend fun performLogin(arguments: Map<String, Any>): SPResult {
        return client.post {
            url {
                takeFrom(baseUrl)
                appendPathSegments("api/core/auth/login")
            }
            setBody(arguments)
        }.body()
    }

    suspend fun performCompanySpecificLogin(
        sessionId: String,
        arguments: Map<String, Any>
    ): SPResult {
        return client.post {
            url {
                takeFrom(baseUrl)
                appendPathSegments("api/core/v2/auth/login")
            }
            headers { append("X-SENPIPER-LOGIN-SESSION-ID", sessionId) }
            setBody(arguments)
        }.body()
    }


    suspend fun sendOtpForLogin(params: Map<String, Any>): SPResult {
        return client.get {
            url {
                takeFrom(baseUrl)
                appendPathSegments("api/core/v2/auth/otp")
                params.forEach { (k, v) -> parameters.append(k, v.toString()) }
            }
        }.body()
    }

    suspend fun sendOtpForSignUp(sessionId: String, params: Map<String, Any>): SPResult {
        return client.get {
            url {
                takeFrom(baseUrl)
                appendPathSegments("api/core/v2/auth/otp/form")
                params.forEach { (k, v) -> parameters.append(k, v.toString()) }
            }
            headers { append("X-SENPIPER-SIGNUP-SESSION-ID", sessionId) }
        }.body()
    }

    suspend fun sendOtpForPhoneFormField(
        sessionId: String,
        groupId: String,
        formId: String,
        phone: String,
        formFieldKey: String
    ): SPResult {
        return client.get {
            url {
                takeFrom(baseUrl)
                appendPathSegments("api/core/forms/answers/otp", groupId, formId)
                parameters.append("phone", phone)
                parameters.append("formFieldKey", formFieldKey)
            }
            headers { append("X-SENPIPER-FORMANSWER-OTP-SESSION-ID", sessionId) }
        }.body()
    }

    suspend fun sendOtpForEmailFormField(
        sessionId: String,
        groupId: String,
        formId: String,
        email: String,
        formFieldKey: String
    ): SPResult {
        return client.get {
            url {
                takeFrom(baseUrl)
                appendPathSegments("api/core/forms/answers/otp", groupId, formId)
                parameters.append("email", email)
                parameters.append("formFieldKey", formFieldKey)
            }
            headers { append("X-SENPIPER-FORMANSWER-OTP-SESSION-ID", sessionId) }
        }.body()
    }

    suspend fun resetPassword(sessionId: String, body: Map<String, Any>): SPResult {
        return client.post {
            url {
                takeFrom(baseUrl)
                appendPathSegments("api/core/v2/auth/password")
            }
            headers { append("X-SENPIPER-LOGIN-SESSION-ID", sessionId) }
            setBody(body)
        }.body()
    }

    suspend fun getDataForApp(): SPResult {
        return client.get {
            url {
                takeFrom(baseUrl)
                appendPathSegments("api/core/user")
            }
        }.body()
    }

    suspend fun sendRegistrationIdToServer(registrationId: String): SPResult {
        return client.post {
            url {
                takeFrom(baseUrl)
                appendPathSegments("api/core/gcm", registrationId)
            }
        }.body()
    }

    suspend fun createUser(arguments: Map<String, Any>): SPResult {
        return client.post {
            url {
                takeFrom(baseUrl)
                appendPathSegments("api/core/auth/create")
            }
            setBody(arguments)
        }.body()
    }

    suspend fun completeUserRegistration(arguments: Map<String, Any>): SPResult {
        return client.post {
            url {
                takeFrom(baseUrl)
                appendPathSegments("api/core/auth/password")
            }
            setBody(arguments)
        }.body()
    }

    suspend fun completeUserRegistrationUsingEmail(arguments: Map<String, Any>): SPResult {
        return client.post {
            url {
                takeFrom(baseUrl)
                appendPathSegments("api/core/auth/registration/completion")
            }
            setBody(arguments)
        }.body()
    }

    suspend fun completeUserRegistrationThroughGoogle(arguments: Map<String, Any>): SPResult {
        return client.post {
            url {
                takeFrom(baseUrl)
                appendPathSegments("api/core/auth/oauth/signup")
            }
            setBody(arguments)
        }.body()
    }

    suspend fun updateUserImageProfile(userId: String, body: List<Map<String, Any>>): SPResult {
        return client.patch {
            url {
                takeFrom(baseUrl)
                appendPathSegments("api/core/users", userId)
            }
            setBody(body)
        }.body()
    }

    suspend fun getUser(userId: String): SPResult {
        return client.get {
            url {
                takeFrom(baseUrl)
                appendPathSegments("api/core/users", userId)
            }
        }.body()
    }

    suspend fun makeLogoutCall(): SPResult {
        return client.delete {
            url {
                takeFrom(baseUrl)
                appendPathSegments("api/core/auth/session")
            }
        }.body()
    }

    suspend fun registerUser(sessionId: String, userDetails: Map<String, Any>): SPResult {
        return client.post {
            url {
                takeFrom(baseUrl)
                appendPathSegments("api/core/users/registration")
            }
            headers { append("X-SENPIPER-SIGNUP-SESSION-ID", sessionId) }
            setBody(userDetails)
        }.body()
    }

}
