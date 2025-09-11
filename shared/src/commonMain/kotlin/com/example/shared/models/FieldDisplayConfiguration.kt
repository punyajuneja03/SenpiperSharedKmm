package com.example.shared.models


import kotlinx.serialization.Serializable

@Serializable
data class FieldDisplayConfiguration(
    val key: String? = null,
    val hideMenuIcon: Boolean = false,
    val voiceInputEnabled: Boolean = false,
    val renderAsMd: Boolean? = null,
    val fieldContainerConfiguration: KmmContainerConfiguration? = null,
    val displayOrientation: KmmDisplayOrientationConfiguration? = null,
    val titleConfiguration: KmmContainerConfiguration? = null,
    val descriptionConfiguration: KmmContainerConfiguration? = null,
    val errorConfiguration: KmmContainerConfiguration? = null,
    val valueConfiguration: KmmContainerConfiguration? = null,
    val fieldSelectedConfiguration: KmmContainerConfiguration? = null,
    val fieldUnSelectedConfiguration: KmmContainerConfiguration? = null,
    val addAnotherButtonConfiguration: KmmContainerConfiguration? = null,
    val buttonConfig: KmmButtonConfiguration? = null
)