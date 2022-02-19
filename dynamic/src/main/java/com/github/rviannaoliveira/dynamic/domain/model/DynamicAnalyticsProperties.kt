package com.github.rviannaoliveira.dynamic.domain.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class DynamicAnalyticsProperties(
    @JsonProperty("category")
    val category: String,

    @JsonProperty("action")
    val action: String,

    @JsonProperty("label")
    val label: String,

    @JsonProperty("track")
    val track: String,
)
