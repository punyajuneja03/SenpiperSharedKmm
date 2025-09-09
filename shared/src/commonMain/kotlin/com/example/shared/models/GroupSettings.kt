package com.example.shared.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.json.JsonElement

@Serializable
data class KmmGroupSettings(
    @SerialName("featureVisibilityConfiguration")
    val featureVisibilityConfiguration: KmmFeatureVisibilityConfiguration? = null,

    @SerialName("gridViewSettings")
    val gridViewSettings: KmmGridViewSettings? = null,

    @SerialName("groupDisplayConfiguration")
    val groupDisplayConfiguration: KmmGroupDisplayConfiguration? = null,

    @SerialName("formSequenceInfo")
    val formSequenceInfo: KmmSequenceInfo? = null // This property was in Java but lacked getters/setters in your provided code
)

@Serializable
data class KmmFeatureVisibilityConfiguration(
    @SerialName("poll")
    val poll: Boolean? = null,
    @SerialName("taskCreation")
    val taskCreation: Boolean? = null,
    @SerialName("assignedTask")
    val assignedTask: Boolean? = null,
    @SerialName("mediaDirectory")
    val mediaDirectory: Boolean? = null,
    @SerialName("tracker")
    val tracker: Boolean? = null,
    @SerialName("timelineView")
    val timelineView: Boolean? = null, // Logic 'if (timelineView == null) return true;' should be handled where the value is used
    @SerialName("conversationView")
    val conversationView: Boolean? = null
) {
    companion object {
        const val JSON_NAME = "groupFeatureVisibilityConfiguration"
    }
}

@Serializable
data class KmmGridViewSettings(
    @SerialName("showGridViewForAdmins")
    val showGridViewForAdmins: Boolean? = null,
    @SerialName("showGridViewForNonAdmins")
    val showGridViewForNonAdmins: Boolean? = null,
    @SerialName("gridViewLayoutConfiguration")
    val gridViewLayoutConfiguration: KmmGridViewLayoutConfiguration? = null,
    @SerialName("formAnswerNodeDataSource")
    val formAnswerNodeDataSource: KmmFormAnswerNodeDataSource? = null
) {
    companion object {
        const val JSON_NAME = "groupGridViewSettings"
    }
}

@Serializable
data class KmmGroupDisplayConfiguration(
    @SerialName("backgroundColor")
    val backgroundColor: String? = null,
    @SerialName("backgroundImageUrl")
    val backgroundImageUrl: String? = null,
    @SerialName("showChatAndFormSeparately")
    val showChatAndFormSeparately: Boolean? = null,
    @SerialName("displayProfileImageInGridView")
    val displayProfileImageInGridView: Boolean? = null,
    @SerialName("defaultContentTypeInTimelineView")
    val defaultContentTypeInTimelineView: String? = null,
    @SerialName("renderCardLayout")
    val renderCardLayout: Boolean? = null,
    @SerialName("enableSorting")
    val enableSorting: Boolean? = null,
    @SerialName("cardDisplayConfiguration")
    val cardDisplayConfiguration: TileLayoutConfiguration? = null
) {
    companion object {
        const val JSON_NAME = "groupDisplayConfiguration"
    }
}

@Serializable
data class KmmSequenceInfo (
    var formAnswerIdentifier: ArrayList<FormIdentifier>? = null
)

@Serializable
data class KmmGridViewLayoutConfiguration(
    val formTileLayoutConfiguration: KmmTileLayoutConfiguration? = null,
    val timelineTileLayoutConfiguration: KmmTileLayoutConfiguration? = null,
    val learningCenterTileLayoutConfiguration: KmmTileLayoutConfiguration? = null,
    val schedulerTileLayoutConfiguration: KmmTileLayoutConfiguration? = null,
    val pendingActionsTileLayoutConfiguration: KmmTileLayoutConfiguration? = null,
    val failedSubmissionsTileConfiguration: KmmTileLayoutConfiguration? = null,
    val sortingCriteriaForPendingActions: List<SortingCriteria>? = null
)

@Serializable
data class KmmFormAnswerNodeDataSource(
    val formAnswerIdentifier: KmmFormAnswerIdentifier? = null,
    val searchDto: KmmFullSearchQueryDto? = null,
    val searchKeysToBePopulated: ArrayList<String>? = null,
    @Transient
    val nodeId: String? = null,
    val nodeTitle: String? = null
)


@Serializable
data class KmmTileLayoutConfiguration(
    val tileWidth: String? = null,
    val tileName: String? = null,
    val tileDescription: String? = null,
    val localisationMap: Map<String, Map<String, JsonElement>>? = null,
    val childrenTilesConfig: List<KmmTileLayoutConfiguration>? = null, // ArrayList becomes List
    val uniqueId: String? = null,
    val uniqueIdType: String? = null, // FORM, GROUP
    val tileNameConfiguration: KmmTextConfiguration? = null,
    val tileDescriptionConfiguration: KmmTextConfiguration? = null,
    val tileBackgroundConfiguration: KmmBackgroundConfiguration? = null,
    val displayOrientationConfiguration: KmmDisplayOrientationConfiguration? = null,
    val ctaConfig: KmmButtonConfiguration? = null,
    val showRetryButtonOnFailedSubmissionsTile: Boolean = false
) {
    companion object {
        const val HALF = "HALF"
        const val FULL = "FULL"
    }

}

@Serializable
data class FormIdentifier(
    val groupId: String? = null, // UUID as String for multiplatform compatibility
    val formId: String? = null   // UUID as String for multiplatform compatibility
)

@Serializable
data class SortingCriteria(
    @SerialName("key") var key: String? = null,
    @SerialName("direction") var direction: String? = "DESC",
    @SerialName("keyType") var keyType: String? = "string",
    @SerialName("weightageMap") var weightageMap: HashMap<String, Int>? = null
)

@Serializable
data class KmmFormAnswerIdentifier(
    val formAnswerId: String? = null,
    val formSchemaId: String? = null,
    val groupId: String? = null,
)

@Serializable
data class KmmFullSearchQueryDto(
    val order: List<Order>? = null, // ArrayList becomes List
    val searchQueries: List<KmmSearchQueryDto> = emptyList() // ArrayList and @NonNull becomes List with a non-nullable default
)

@Serializable
data class KmmSearchQueryDto(
    val resourceReference: KmmResourceReference? = null,
    val searchQuery: KmmSearchQuery? = null
)

@Serializable
data class Order(
    @SerialName("key")
    val key: String,
    @SerialName("direction")
    val direction: String
)