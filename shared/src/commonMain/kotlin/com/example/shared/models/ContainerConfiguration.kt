package com.example.shared.models

import kotlinx.serialization.Serializable

@Serializable
data class KmmContainerConfiguration(
    val backgroundConfiguration: KmmBackgroundConfiguration? = null,
    val textConfiguration: KmmTextConfiguration? = null,
    val spacing: KmmMarginConfiguration? = null
)


@Serializable
data class KmmBackgroundConfiguration(
    val borderThickness: Float? = null,
    val borderColor: String? = null,
  //  val borderRadius: CornerRadius? = null, // Nested data class
    val color: String? = null,
    val shadow: String? = null,
    val imageName: String? = null,
    val imageUrl: String? = null,
    val drawableStart: Int = 0 // Android resource ID, default to 0
) {
    companion object {
        const val FIELD_BACKGROUND_9_PATCH = "field_background_9_patch"
        const val FIELD_BACKGROUND_THICKER_SHADOWS_9_PATCH = "field_background_thicker_shadows_9_patch"
    }
}

@Serializable
data class KmmTextConfiguration(
    val text: String? = null,
    val placeholderTextConfiguration: KmmTextConfiguration? = null,
    val selectAllTextConfiguration: KmmTextConfiguration? = null,
    val fontConfiguration: KmmFontConfiguration? = null,
    val prefixConfiguration: KmmContainerConfiguration? = null,
    val suffixConfiguration: KmmContainerConfiguration? = null,
    val numberOfLines: Int? = null,
    val textAlignment: String? = null
) {
    companion object {
        const val LEFT = "left"
        const val RIGHT = "right"
        const val CENTER = "center"
    }
}

@Serializable
data class KmmFontConfiguration(
    val fontSize: String? = null, // small/medium/large
    val fontWeight: String? = null,  //regular/medium/light
    val fontColor: String? = null,
    val fontStyle: String? = null  //normal/bold/italic/bold_italic
)


@Serializable
data class KmmMarginConfiguration(
    val left: Int? = null,
    val top: Int? = null,
    val bottom: Int? = null,
    val right: Int? = null
)