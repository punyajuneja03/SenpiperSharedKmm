package com.example.shared.models


import kotlinx.serialization.Serializable

@Serializable
data class KmmFormReportConfiguration(
    val reportId: String? = null, // UUID as String for multiplatform compatibility
    val reportDisplayConfiguration: KmmReportDisplayConfiguration? = null
) {
    // No need to override toString() as data class provides it
}

@Serializable
data class KmmReportDisplayConfiguration(
    val mode: String? = null,
    val displayType: String? = null
) {
    companion object {
        const val VIEW = "view"
        const val SELECT = "select"
    }
    // No need to override toString() as data class provides it
}