package com.example.shared.models


import kotlinx.serialization.Serializable

@Serializable
data class KmmMasterConfiguration(
    val pageSizeForFetchingMasters: Int? = null,
    val shouldBlockUiTillCompleteMasterSync: Boolean? = null,
    val fetchDistinctValues: Boolean = false
)