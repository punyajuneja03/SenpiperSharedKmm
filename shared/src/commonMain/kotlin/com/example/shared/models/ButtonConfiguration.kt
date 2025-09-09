package com.example.shared.models


import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class KmmButtonConfiguration(
    val displayOrientation: KmmDisplayOrientationConfiguration? = null,
    val textConfiguration: KmmTextConfiguration? = null,
    val backgroundConfiguration: KmmBackgroundConfiguration? = null,
    val buttonState: String? = null, // disabled(click disabled)/selected
    val text: String? = null,
    val editModeText: String? = null,
    val drawableStart: Int = 0,
    val localisationMap: Map<String, Map<String, JsonElement>>? = null,
    val onSuccessConfig: KmmPopupConfiguration? = null,
    val onFailureConfig: KmmPopupConfiguration? = null,
    val confirmationConfig: KmmPopupConfiguration? = null
)
@Serializable
data class KmmDisplayOrientationConfiguration(
    val layout: String? = null,
    val titleAndValueArrangement: String? = null, // default, sideBySide
    val titleHorizontalPercentage: String? = null,
    val spaceBetweenTitleAndValuePercentage: String? = null,
    val widthPercentage: String? = null,
    val heightPercentage: String? = null,
    val scrollDirection: String? = null,
    val buttonPosition: String? = null,
    val isSnappy: Boolean? = null
) {
    companion object {
        const val SIDE_BY_SIDE = "sideBySide"
        const val ONE_THIRD = "ONE_THIRD"
        const val HALF_SCREEN = "HALF_SCREEN"
        const val FULL_SCREEN = "FULL_SCREEN"
    }
}

@Serializable
data class KmmPopupConfiguration(
    val title: String? = null,
    val description: String? = null,
    val localisationMap: Map<String, Map<String, JsonElement>>? = null,
    val titleConfiguration: KmmTextConfiguration? = null,
    val descriptionConfiguration: KmmTextConfiguration? = null,
    val containerConfiguration: KmmContainerConfiguration? = null,
    val imageContainerConfig: KmmContainerConfiguration? = null,
    val buttonsConfig: List<KmmButtonConfiguration>? = null,
    val buttonContainerConfig: KmmContainerConfiguration? = null,
    val templateType: String? = null,
    val showFullScreen: Boolean = false,
    val showCancelButton: Boolean = false,
    val shouldAutoDismiss: Boolean = false,
    val dismissDurationInMiliseconds: Double = 0.0,
    val canceledOnTouchOutside: Boolean = false
)