package com.example.shared.ColorConfiguration

import kotlinx.serialization.Serializable

@Serializable
data class KmmColorShadeConfiguration(
    val _300: String? = null,
    val _300Alpha5: String? = null,
    val _300Alpha10: String? = null,
    val _300Alpha20: String? = null,
    val _300Alpha30: String? = null,
    val _300Alpha40: String? = null,
    val _300Alpha50: String? = null,
    val _300Alpha70: String? = null,
    val _300Alpha100: String? = null,
    val _400: String? = null,
    val _400Alpha5: String? = null,
    val _400Alpha10: String? = null,
    val _400Alpha20: String? = null,
    val _400Alpha30: String? = null,
    val _400Alpha40: String? = null,
    val _400Alpha50: String? = null,
    val _400Alpha70: String? = null,
    val _400Alpha100: String? = null,
    val _500: String? = null,
    val _500Alpha5: String? = null,
    val _500Alpha10: String? = null,
    val _500Alpha20: String? = null,
    val _500Alpha30: String? = null,
    val _500Alpha40: String? = null,
    val _500Alpha50: String? = null,
    val _500Alpha70: String? = null,
    val _500Alpha100: String? = null,
    val _600: String? = null,
    val _600Alpha5: String? = null,
    val _600Alpha10: String? = null,
    val _600Alpha20: String? = null,
    val _600Alpha30: String? = null,
    val _600Alpha40: String? = null,
    val _600Alpha50: String? = null,
    val _600Alpha70: String? = null,
    val _600Alpha100: String? = null,
    val _700: String? = null,
    val _700Alpha5: String? = null,
    val _700Alpha10: String? = null,
    val _700Alpha20: String? = null,
    val _700Alpha30: String? = null,
    val _700Alpha40: String? = null,
    val _700Alpha50: String? = null,
    val _700Alpha70: String? = null,
    val _700Alpha100: String? = null,
)

@Serializable
data class KmmColorModeConfiguration(
    val primary: String? = null,
    val secondary: String? = null,
    val tertiary: String? = null
)

@Serializable
data class ColorConfiguration(
    val primaryColor: KmmColorShadeConfiguration? = null,
    val accentColor: KmmColorShadeConfiguration? = null,
    val semanticColor: KmmColorShadeConfiguration? = null,
    val supportColor: KmmColorShadeConfiguration? = null,
    val hoverColor: KmmColorShadeConfiguration? = null,
    val backgroundColorConfiguration: KmmColorModeConfiguration? = null,
    val shadowColorConfiguration: KmmColorModeConfiguration? = null,
    val navigationBarColorConfiguration: KmmColorModeConfiguration? = null,
    val gradientColorConfiguration: KmmColorModeConfiguration? = null,
)