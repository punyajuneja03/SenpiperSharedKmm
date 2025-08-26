package com.example.shared.models

import com.example.shared.ColorConfiguration.ColorConfiguration
import kotlinx.serialization.Serializable

@Serializable
data class KmmModelCompanyConfig(
    val accountRevokeConfiguration: AccountRevokeConfiguration? = null,
    val displayConfiguration: DisplayConfiguration? = null,
    val whiteLabelConfiguration: KmmWhiteLabelConfiguration? = null,
    var companyName: String? = null,
    var companyId: String? = null,
    var baseUrl: String? = null,
    val termsUrl: String? = null,
    val countryCode: String? = null,
    val scopeRolePermissionEnabled: Boolean? = null,
    val companyAuthConfig: CompanyAuthConfig? = null,
    val groupSettings: GroupSettings? = null,
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
data class AccountRevokeConfiguration(
    val recipientList: List<String>? = null
)

@Serializable
data class KmmWhiteLabelConfiguration(
    val lightModeColorConfiguration: ColorConfiguration? = null,
    val darkModeColorConfiguration: ColorConfiguration? = null,
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
