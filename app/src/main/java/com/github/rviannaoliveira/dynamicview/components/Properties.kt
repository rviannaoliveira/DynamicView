package com.github.rviannaoliveira.dynamicview.components

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.github.rviannaoliveira.dynamic.domain.model.DynamicActionProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class AnalyticsProperties(
    @JsonProperty("category") val category: String,
    @JsonProperty("event") val event: String,
    @JsonProperty("action") val action: String
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class TextProperties(
    @JsonProperty("text") val text: String,
    @JsonProperty("textColor") val textColor: String? = null,
)

@JsonIgnoreProperties(ignoreUnknown = true)
data class ButtonProperties(
    @JsonProperty("text") val text: String,
    @JsonProperty("textColorHex") val textColorHex: String? = null,
    @JsonProperty("analytics") val analytics: AnalyticsProperties? = null,
    @JsonProperty("actionProperties") var actionProperties: DynamicActionProperties? = null,
)
