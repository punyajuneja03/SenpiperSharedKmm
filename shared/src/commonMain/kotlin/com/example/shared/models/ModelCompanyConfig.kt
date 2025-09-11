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
    val timeOutConfiguration: KmmTimeoutConfiguration? = null,
    val retryCountForApiCallsFromApp: Map<String, Int>? = null,
    val customResourceReferences: Map<String, KmmResourceReferences>? = null


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
data class KmmTimeoutConfiguration(
    val apiTimeOutInSeconds: Int = 0
)

@Serializable
data class KmmResourceReference(
    val target: String? = null,
    val formId: String? = null,
    val groupId: String? = null,
    var chatId: String? = null,
    var companyId: String? = null,
    var answerId: String? = null,
    var reportId: String? = null,
    var workFlowId: String? = null
)

@Serializable
data class KmmResourceReferences(
    val domain: String? = null,
    val formId: String? = null,
    val groupId: String? = null,
)
