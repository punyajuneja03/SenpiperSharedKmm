package com.example.shared.models

import com.example.shared.ColorConfiguration.KmmColorConfiguration
import kotlinx.serialization.Serializable

@Serializable
data class KmmModelCompanyConfig(
    val accountRevokeConfiguration: KmmAccountRevokeConfiguration? = null,
    val displayConfiguration: KmmDisplayConfiguration? = null,
    val whiteLabelConfiguration: KmmWhiteLabelConfiguration? = null,
    var companyName: String? = null,
    var companyId: String? = null,
    var baseUrl: String? = null,
    val termsUrl: String? = null,
    val countryCode: String? = null,
    val scopeRolePermissionEnabled: Boolean? = null,
    val companyAuthConfig: KmmCompanyAuthConfig? = null,
    val groupSettings: KmmGroupSettings? = null,
    val supportedLanguages: List<String>? = null,
    val timeOutConfiguration: TimeoutConfiguration? = null,
    val retryCountForApiCallsFromApp: Map<String, Int>? = null,
    val customResourceReferences: Map<String, ResourceReference>? = null


) {
    companion object {
        const val FAILED_SUBMISSION_RETRY_COUNT = "failed_submission_retry_count"
    }
}


@Serializable
data class KmmAccountRevokeConfiguration(
    val recipientList: List<String>? = null
)

@Serializable
data class KmmWhiteLabelConfiguration(
    val lightModeColorConfiguration: KmmColorConfiguration? = null,
    val darkModeColorConfiguration: KmmColorConfiguration? = null,
)


@Serializable
data class TimeoutConfiguration(
    val apiTimeOutInSeconds: Int = 0
)

@Serializable
data class ResourceReference(
    val formId: String? = null,
    val groupId: String? = null,
    var domain: String? = null
)
