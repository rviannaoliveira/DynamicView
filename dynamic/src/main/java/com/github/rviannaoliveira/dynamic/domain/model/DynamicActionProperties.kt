package com.github.rviannaoliveira.dynamic.domain.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class DynamicActionProperties (
    @JsonProperty("deeplink")
    val deeplink : String?,

    @JsonProperty("actionData")
    val actionData: Any?,

    @JsonProperty("analytics")
    val analytics: DynamicAnalyticsProperties?,
)